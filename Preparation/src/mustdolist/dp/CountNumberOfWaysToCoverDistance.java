package mustdolist.dp;

public class CountNumberOfWaysToCoverDistance
{
	public static void main(String[] args) {
		int dist=4;
		int ways=findWaysRec(dist);
		System.out.println(ways);
		
		ways=findWaysDP(dist);
		System.out.println(ways);
	}

	private static int findWaysDP(int dist) {
		int count[]=new int[dist+1];
		count[0]=1;
		count[1]=1;
		count[2]=2;
		for(int i=3;i<=dist;i++)
			count[i]=count[i-1]+count[i-2]+count[i-3];
		return count[dist];
	}

	private static int findWaysRec(int dist) {
		
		if(dist==0)
			return 1;
		if(dist<0)
			return 0;
		
		return findWaysRec(dist-1)+findWaysRec(dist-2)+findWaysRec(dist-3);
	}
}
