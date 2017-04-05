import java.util.*;
class PageRepLRU
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Frame and Total no. of Pages: ");
		int f=in.nextInt(),n=in.nextInt(),i,c=0,x,j,a=0,min;
		int arr[][]=new int[f][n];
		int lru[]=new int[f];
		int page[]=new int[n];
		for(i=0;i<n;i++)
			page[i]=in.nextInt();
		for(i=0;i<n;i++)
		{
			if(c==0)
			{
				arr[0][0]=page[i];
				c++;a++;lru[0]=i;
				continue;
			}
			else if(c<f)
			{
				for(j=0;j<c;j++)
					arr[j][i]=arr[j][i-1];
				lru[c]=i;a++;
				arr[c++][i]=page[i];
			}
			else
			{
				for(j=0;j<f;j++)
					arr[j][i]=arr[j][i-1];
				for(x=0,j=0;j<f;j++)
				{
					if(arr[j][i]==page[i])
					{
						x=1;lru[j]=i;
						break;
					}
				}
				if(x==1)
					continue;
				else
				{
					min=0;
					for(j=0;j<f;j++)
					{
						if(lru[j]<lru[min])
							min=j;
					}
					arr[min][i]=page[i];
					a++;lru[min]=i;
				}
			}
		}
		for(i=0;i<f;i++)
		{
			for(j=0;j<n;j++)
			{
				if(arr[i][j]==0)
					System.out.print("   ");
				else
					System.out.print(arr[i][j]+"  ");
			}
			System.out.println();
		}
		System.out.println("Faults: "+a);
	}
}