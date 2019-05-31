package gameAi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 2019/05/11 1.0
 * 2019/05/12 1.1 added random selection / remove consle output
 * @author ugajin
 * @version 1.1
 */
public class NiceAi extends GameAiTest implements gameAi {

	@Override
	public int[] getNextPos(int[][] board, int color) {
		int[] pos = new int[2];
		
		int[][] ava = new int[8][8];
		checkAva(ava, color, board);
		
		List<DataNext> nextList = new ArrayList<>();
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(ava[i][j] > 0) {
					nextList.add(new DataNext(doStep(board,color,i,j),i,j,color));
				}
			}
		}
		
		//ver1.0 code
		/* 
		DataNext mindata = nextList.get(0);
		for(DataNext datatry : nextList) {
			System.out.printf("x:%d y:%d enemyScore:%.2f\n", datatry.x+1,datatry.y+1,datatry.nextscore);
			if(datatry.nextscore <= mindata.nextscore) {
				mindata = datatry;
			}
		}
		*/
		
		double minscore = 0.0;
		List<DataNext> minDataList = new ArrayList<>();
		minDataList.add(nextList.get(0));
		minscore = minDataList.get(0).nextscore;
		for(DataNext datatry : nextList) {
			//System.out.printf("x:%d y:%d enemyScore:%.2f\n", datatry.x+1,datatry.y+1,datatry.nextscore);
			if(datatry.nextscore < minDataList.get(0).nextscore) {
				minscore = datatry.nextscore;
				minDataList.removeIf(s->true);
				minDataList.add(datatry);
				minscore = minDataList.get(0).nextscore;
			} else if (datatry.nextscore == minscore) {
				minDataList.add(datatry);
			}
		}
		
		Random random = new Random();
		DataNext mindata = minDataList.get(random.nextInt(minDataList.size()));

		
		pos[0] = mindata.x;
		pos[1] = mindata.y;
		/*
		System.out.println("------------------------");
		System.out.printf("result : x %d  y %d\n",pos[0]+1,pos[1]+1);
		System.out.println("------------------------");
		*/
		return pos;
	}

	public int[][] doStep(int[][] board,int color,int x,int y){
		int[][] nextboard = cloneArray(board);
		placeAtom(x,y,color,nextboard);
		return nextboard;
	}
	
	private int[][] cloneArray(int[][] origin){
		int[][] newone = new int[8][8];
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				newone[i][j] = origin[i][j];
			}
		}
		return newone;
	}
	
	//place [color] at (x,y) and turn ,uses niceAva() ,doesn't check availability
	private void placeAtom(int x,int y,int color,int[][] board) {
		int counter = 0;
		int tempx = 0;
		int tempy = 0;
		int[] tempp = null;
		for(int dir=0;dir<8;dir++) {
			tempx = x;
			tempy = y;
			for(counter = niceAva(dir,x,y,color,board);counter>0;counter--) {
				tempp = getDirpos(dir,tempx,tempy);
				tempx = tempp[0];
				tempy = tempp[1];
				board[tempx][tempy] = color;
			}
		}
		board[x][y] = color;
	}

	
	
	class DataNext{
		int[][] nextboard = null;
		int x ;
		int y ;
		int color;
		int nextcount = 0;
		int nextamount = 0;
		double nextscore = 0.0;
		public DataNext(int[][] nextboard,int x,int y,int color) {
			this.nextboard = nextboard;
			this.x = x;
			this.y = y;
			this.color = color;
			tryNext();
		}
		
		private void tryNext() {
			int[][] ava = new int[8][8];
			checkAva(ava, -1 * color, nextboard);
			for(int i =0;i<8;i++) {
				for(int j=0;j<8;j++) {
					if(ava[i][j]>0) {
						nextcount++;
						if((i==0|i==7)&(j==0|j==7)) {
							nextamount += ava[i][j] + 10;
						} else if ((i==0|i==7)|(j==0|j==7)) {
							nextamount += ava[i][j] + 5;
						} else {
							nextamount += ava[i][j];
						}
					}
				}
			}
			nextscore = ((double)nextamount)/nextcount;
		}
		
		
		
	}
}


