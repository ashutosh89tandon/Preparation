package prep.round2;

public class Example4
{
	public static void main(String[] args) 
	{
		
		//int a[][]= {{0 ,1 ,0 ,1 ,0 ,1},{ 1 ,0 ,1 ,0, 1 ,0},{ 0 ,1 ,1,
		//		1, 1, 0,},{ 0, 0, 1 ,1 ,1, 0}, {1, 1, 1, 1, 1, 1}};
		//int a1[][] ={{1,1},{1,1}};
		
		int a3[][] ={{0,0},{0,0}};
		findMaxSizeSquareMatrix(a3);
	}

	private static void findMaxSizeSquareMatrix(int[][] a) 
	{
		int size=0;
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				if(a[i][j]==1)
				{
					int localSize=findMaxSize(a,i,j);
					if(localSize>size)
					{
						size=localSize;
					}
				}
			}
		}
		
		System.out.println("Max size "+size);
	}

	private static int findMaxSize(int[][] a, int x, int y) 
	{
		int size=1;
		for(int i=1;i+x<a.length && i+y<a[0].length;i++)
		{
			for(int j=i;j>0;j--)
			{
				if(!(a[x+i][y+i] ==1 && a[x+i][y-j+i]==1 && a[x-j+i][y+i]==1))
					return size;
			}
			size++;
		}
		
		return size;
	}
}
