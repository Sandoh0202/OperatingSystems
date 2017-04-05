import java.util.*;
class PageRepFIFA
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Frame and Total no. of Pages: ");
		int f=in.nextInt(),n=in.nextInt(),i,ptr=0,page,c=0,x,j,a=0;
		int arr[][]=new int[f][n];
		for(i=0;i<n;i++)
		{
			x=0;
			System.out.print("\nEnter page value: ");
			page=in.nextInt();
			if(c==0)
			{
				arr[0][0]=page;
				c++;a++;continue;
			}
			for(j=0;j<f;j++)
			{
				arr[j][i]=arr[j][i-1];
				if(arr[j][i]==page)
					x=1;
			}
			if(x==1)
				continue;
			
			if(c<3)
			{
				arr[c++][i]=page;
				a++;
			}
			else
			{
				arr[ptr++][i]=page;
				ptr%=f;a++;
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