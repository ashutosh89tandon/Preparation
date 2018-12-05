package mustdolist.backtracking;

import java.util.HashMap;
import java.util.Map;

public class Sudoku 
{
	private static int M=9;
	public static void main(String[] args) {
		int output[][]=findSudokuSolution();
		
		for(int i=0;i<M;i++)
		{
			for(int j=0;j<M;j++)
				System.out.print(output[i][j]+" ");
			System.out.println();
		}
	}
	private static int[][] findSudokuSolution() {
		int output[][]={{3, 0, 6, 5, 0, 8, 4, 0, 0}, 
                {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
                {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
                {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
                {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
                {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
                {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
                {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
                {0, 0, 5, 2, 0, 6, 3, 0, 0}}; 
		
		solve(output);
		
		return output;
	}
	
	private static boolean solve(int[][] output) 
	{
		Map<String,Integer> dimension=new HashMap<>();
		if(!findUnAssigned(output,dimension))
		{
			return true;
		}
		
		for(int num=1;num<=9;num++)
		{
			int row=dimension.get("row");
			int col=dimension.get("column");
			if(isSafe(num,row,col,output))
			{
				output[row][col]=num;
				if(solve(output))
					return true;
				output[row][col]=0;
			}
		}
		return false;
		
	}
	
	private static boolean isSafe(int num, int row, int col, int[][] output) {
		
		for(int i=0;i<M;i++)
			if(i!=row && num==output[i][col])
				return false;
		
		for(int i=0;i<M;i++)
			if(i!=col && num==output[row][i])
				return false;
		
		for(int i=row-(row%3);i<(row-(row%3))+3;i++)
		{
			for(int j=col-(col%3);j<(col-(col%3))+3;j++)
				if(i!=row && j!=col && num==output[i][j])
					return false;
		}
		
		return true;
	}
	
	private static boolean findUnAssigned(int[][] output, Map<String, Integer> dimension) {
		
		for(int i=0;i<M;i++)
		{
			for(int j=0;j<M;j++)
				if(output[i][j]==0)
				{
					dimension.put("row", i);
					dimension.put("column", j);
					return true;
				}
		}
		return false;
	}
	
}
