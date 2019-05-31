package application;

import gameAi.*;

public class GameProc {
	
	private gameAi gameAi = new NiceAi();
	private gameAi gameAiSub = new NiceAiVer2();
	
	private static final int BLACK = 1;
	private static final int WHITE = -1;
	private int[][] board = new int[8][8];
	private boolean avaWhite = false;
	private boolean avaBlack = false;
	private boolean[][] avaGridWhite = new boolean[8][8];
	private boolean[][] avaGridBlack = new boolean[8][8];
	private int countWhite = 0;
	private int countBlack = 0;
	
	public String getAiClass() {
		return this.gameAi.getClass().getName();
	}
	
	public String getSubAiClass() {
		if (gameAiSub == null) return "";
		return this.gameAiSub.getClass().getName();
	}
	
	//set playerColor
	public GameProc(){
		initBoard();
		refreshData();
	}
	
	//check x,y availability before use this method
	public void doStep(int x,int y,int color) {
		placeAtom(x,y,color);
		refreshData();
	}
	
	public void doAutoStep(int color,gameAi currentAi) {
		int[] pos = null;
		pos = currentAi.getNextPos(board, color);
		if(!getAvaGrid(pos[0],pos[1],color)) {
			System.out.println(currentAi.getClass().getName() + " returns a wrong answer !");
			System.exit(0);
		}
		doStep(pos[0],pos[1],color);
	}
	
	public gameAi getAi() {
		return this.gameAi;
	}
	
	public gameAi getSubAi() {
		return this.gameAiSub;
	}
	
	public int getCount(int color) {
		if(color == BLACK) {
			return countBlack;
		} else if ( color == WHITE ) {
			return countWhite;
		} else {
			return 0;
		}
	}
	
	public int[][] getBoard(){
		return board;
	}
	
	public boolean getAva(int color) {
		if(color == BLACK) {
			return avaBlack;
		} else if (color == WHITE) {
			return avaWhite;
		} else {
			return false;
		}
	}
	
	public boolean getAvaGrid(int x,int y,int color) {
		if(color == BLACK) {
			return avaGridBlack[x][y];
		} else if (color == WHITE) {
			return avaGridWhite[x][y];
		}
		return false;
	}
	
	public boolean[][] getAvaGridAll(int color) {
		if(color == BLACK) {
			return avaGridBlack;
		} else if (color == WHITE) {
			return avaGridWhite;
		} else {
			return null;
		}
	}
	
	//refresh checkAva, ava, counter
	public void refreshData() {
		avaWhite = checkAva(avaGridWhite,WHITE);
		avaBlack = checkAva(avaGridBlack,BLACK);
		countWhite = countColor(WHITE);
		countBlack = countColor(BLACK);
	}
	
	//place [color] at (x,y) and turn ,uses niceAva() ,doesn't check availability
	private void placeAtom(int x,int y,int color) {
		int counter = 0;
		int tempx = 0;
		int tempy = 0;
		int[] tempp = null;
		for(int dir=0;dir<8;dir++) {
			tempx = x;
			tempy = y;
			for(counter = niceAva(dir,x,y,color);counter>0;counter--) {
				tempp = getDirpos(dir,tempx,tempy);
				tempx = tempp[0];
				tempy = tempp[1];
				board[tempx][tempy] = color;
			}
		}
		board[x][y] = color;
	}
	
	//initialization board (only have 2 blacks and 2 whites)
	private void initBoard() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				board[i][j] = 0;
			}
		}
		this.board[3][3] = WHITE;
		this.board[4][4] = WHITE;
		this.board[3][4] = BLACK;
		this.board[4][3] = BLACK;
	}
	
	//return true if available // change ava into color's ava form(which means can return ava and boolean
	private boolean checkAva(boolean[][] ava ,int currentColor) {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				ava[i][j] = false;
			}
		}
		boolean check = false;
		for(int x=0;x<8;x++) {
			for(int y=0;y<8;y++) {
				if(board[x][y]!=0) continue;
				for(int dir=0;dir<8;dir++) {
					int temp = 0;
					temp = niceAva(dir,x,y,currentColor);
					if(temp>0) {
						ava[x][y] =true;
						check = true;
					}
				}
			}
		}
		return check;
	}
	
	//go 1 step forward to the direction
	private int[] getDirpos(int dir,int x,int y) {
		int[] pos = {x,y};
		switch(dir) {
		case 0:
			pos[1] += 1;
			break;
		case 1:
			pos[0] += 1;
			pos[1] += 1;
			break;
		case 2:
			pos[0] += 1;
			break;
		case 3:
			pos[0] += 1;
			pos[1] -= 1;
			break;
		case 4:
			pos[1] -= 1;
			break;
		case 5:
			pos[0] -= 1;
			pos[1] -= 1;
			break;
		case 6:
			pos[0] -= 1;
			break;
		case 7:
			pos[0] -= 1;
			pos[1] += 1;
			break;
		}
		return pos;
	}

	//return count of how many you can change
	private int niceAva(int dir,int x,int y,int currentColor) {
		int[] nextPos = getDirpos(dir,x,y);
		int tempx = nextPos[0];
		int tempy = nextPos[1];
		if(tempx<0|tempx>7|tempy<0|tempy>7) return -99;
		if(board[tempx][tempy]==0) return -99;
		if(board[tempx][tempy]==currentColor) {
			return 0;
		}
		else if(board[tempx][tempy]!=currentColor){
			return niceAva(dir,tempx,tempy,currentColor)+1;
		}
		
		return 0;
	}
	
	//count color in the board and return as int
	private int countColor(int color) {
		int count = 0;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(board[i][j]==color) {
					count++;
				}
			}
		}
		return count;
	}
	
}
