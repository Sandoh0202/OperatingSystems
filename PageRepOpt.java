import java.util.*;
class PageRepOpt
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Frame and Total no. of Pages: ");
		int f=in.nextInt(),n=in.nextInt(),i,c=0,k,x,j,a=0,max;
		int arr[][]=new int[f][n];
		int opt[]=new int[f];
		int page[]=new int[n];
		for(i=0;i<n;i++)
			page[i]=in.nextInt();
		for(i=0;i<n;i++)
		{
			if(c==0)
			{
				arr[0][0]=page[i];
				c++;a++;
				continue;
			}
			else if(c<f)
			{
				for(j=0;j<c;j++)
					arr[j][i]=arr[j][i-1];
				a++;
				arr[c++][i]=page[i];
			}
			else
			{
				for(j=0;j<f;j++)
					arr[j][i]=arr[j][i-1];
				for(x=0,j=0;j<f;j++)
				{
					opt[j]=0;
					if(arr[j][i]==page[i])
					{
						x=1;break;
					}
				}
				if(x==1)
					continue;
				else
				{
					for(j=0;j<f;j++)
					{
						for(k=i+1;k<n;k++)
						{
							if(arr[j][i]==page[k])
							{
								opt[j]=k;
								break;
							}
						}
						opt[j]=opt[j]==0?n+1:opt[j];
					}
					for(max=0,j=0;j<f;j++)
					{
						if(opt[j]>opt[max])
							max=j;
					}
					arr[max][i]=page[i];
					a++;
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