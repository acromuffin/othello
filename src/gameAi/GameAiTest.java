package gameAi;

public class GameAiTest implements gameAi{
	
	public int[] getNextPos(int[][] board,int color) {
		
		int[][] ava = new int[8][8];
		
		checkAva(ava,color,board);
		
		for(int i= 0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if((i==0 | i==7) & (j==0 | j==7) & ava[i][j] > 0) {
					ava[i][j] += 10;
				} else if (((i==0 | i==7) | (j==0 | j==7)) & ava[i][j] > 0) {
					ava[i][j] += 5;
				}
			}
		}
		
		int[] maxPos = null;
		maxPos = getMaxPos(ava);
		
		
		return maxPos;
	}
	
	protected static int[] getMaxPos(int[][] ava) {
		int[] maxPos = new int[2];
		int max = 0;
		maxPos[0] = 0;maxPos[1] = 0;
		
		for(int i =0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(ava[i][j] > max) {
					max = ava[i][j];
					maxPos[0] = i;maxPos[1] = j;
				}
			}
		}
		
		return maxPos;
	}
	
	protected static boolean checkAva(int[][] ava,int currentColor,int[][] board) {
		boolean check = false;
		for(int x=0;x<8;x++) {
			for(int y=0;y<8;y++) {
				if(board[x][y]!=0) continue;
				for(int dir=0;dir<8;dir++) {
					int temp = 0;
					temp = niceAva(dir,x,y,currentColor,board);
					if(temp>0) {
						ava[x][y] += temp;
						check = true;
					}
				}
			}
		}
		return check;
	}
	
	protected static int niceAva(int dir,int x,int y,int currentColor,int[][] board) {
		int[] nextPos = getDirpos(dir,x,y);
		int tempx = nextPos[0];
		int tempy = nextPos[1];
		if(tempx<0|tempx>7|tempy<0|tempy>7) return -99;
		if(board[tempx][tempy]==0) return -99;
		if(board[tempx][tempy]==currentColor) {
			return 0;
		}
		else if(board[tempx][tempy]!=currentColor){
			return niceAva(dir,tempx,tempy,currentColor,board)+1;
		}
		
		return 0;
	}
	
	protected static int[] getDirpos(int dir,int x,int y) {
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

}
