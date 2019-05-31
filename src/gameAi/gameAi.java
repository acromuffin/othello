package gameAi;

public interface gameAi {
	public static final int BLACK = 1;
	public static final int WHITE = -1;
	public int[] getNextPos(int[][] board,int color);
}
