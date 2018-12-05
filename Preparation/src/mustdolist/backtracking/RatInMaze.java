package mustdolist.backtracking;

public class RatInMaze
{
	private static int M=4;
	public static void main(String[] args) {
		int input[][]={{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1},};
		int output[][]=findPath(input);
		for(int i=0;i<M;i++)
		{
			for(int j=0;j<M;j++)
				System.out.print(output[i][j]+" ");
			System.out.println();
		}
	}
	private static int[][] findPath(int[][] input) {
		int output[][]=new int[M][M];
		solve(input, 0,0,output);
		return output;
	}
	private static boolean solve(int[][] input, int row, int col, int[][] output)
	{
		if(row==M-1 && col==M-1 && input[row][col]==1)
		{
			output[row][col]=1;
			return true;
		}
		
		if(row==M || col==M)
			return false;
		
		if(isSafe(input,row,col))
		{
			output[row][col]=1;
			if(solve(input,row+1,col,output))
				return true;

			else if(solve(input,row,col+1,output))
				return true;

			output[row][col]=0;
		}
		return false;
	}
	private static boolean isSafe(int[][] input, int row, int col) {
		
		if(input[row][col]==1)
			return true;
		return false;
	}
}
