package mustdolist.backtracking;

public class Nqueen {

	private static int M=5;
	public static void main(String[] args) {
		String[][] queen=solveNQueen();
		
		for(int i=0;i<M;i++)
		{
			for(int j=0;j<M;j++)
				System.out.print(queen[i][j]+" ");
			System.out.println();
		}
	}

	private static String[][] solveNQueen() 
	{
		String[][] queen=new String[M][M];
		
		for(int i=0;i<M;i++)
		{
			if(solve(i,queen))
				return queen;
		}
		
		return queen;
	}

	private static boolean solve(int row, String[][] queen)
	{
		if(row==M)
			return true;
		for(int j=0;j<M;j++)
		{
			if(isSafe(row,j,queen))
			{
				queen[row][j]="Q";
				if(solve(row+1, queen))
					return true;
				queen[row][j]=null;
			}
		}
		
		return false;
	}

	private static boolean isSafe(int row, int column, String[][] queen) {
		for(int i=row-1;i>=0;i--)
		{
			if("Q".equals(queen[i][column]))
				return false;
		}
		if(column>0)
		{
			for(int i=row-1,j=column-1;i>=0 && j>=0;i--,j--)
			{
				if("Q".equals(queen[i][j]))
					return false;
			}
		}
		if(column<M)
		{
			for(int i=row-1,j=column+1;i>=0 && j<M;i--,j++)
			{
				if("Q".equals(queen[i][j]))
					return false;
			}
		}
		return true;
	}
}
