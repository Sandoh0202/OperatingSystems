import java.util.Scanner;
class TimeArray
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Enter number of processes: ");
		int p=in.nextInt(),i,j,m,l,k,x,c=0;
		double a=0.0;
		int arrive[]=new int[p];
		int burst[]=new int[p];
		int index[]=new int[p];
		int stack[]=new int[p];
		int waiting[]=new int[p];
		for(i=0;i<p;i++)
		{
			System.out.print("\nEnter Arrival time of P"+i+" : ");
			arrive[i]=in.nextInt();
			System.out.print("\nEnter Burst time of P"+i+" : ");
			burst[i]=in.nextInt();
			c+=burst[i];
		}
		int arr[]=new int[c];
		stack[0]=burst[0];
		for(i=0,k=0;i<c;i++)						//The time array!
		{
			for(j=1;j<p;j++)			//putting on to stack
			{
				if(arrive[j]==i)
				{
					stack[++k]=burst[j];
					index[k]=j;
					break;
				}
			}
			for(j=0;j<=k;j++)			//Sorting the stack
			{
				m=j;
				for(l=j+1;l<=k;l++)
				{
					if(burst[index[m]]<burst[index[l]])
						m=l;
				}
				x=stack[m];
				stack[m]=stack[j];
				stack[j]=x;
				x=index[m];
				index[m]=index[j];
				index[j]=x;
			}
			arr[i]=index[k];
			stack[k]-=1;
			for(j=0;j<k;j++)
				waiting[index[j]]+=1;
			if(stack[k]==0)
				k--;
			System.out.println(arr[i]);
		}
		for(i=0;i<p;i++)					//Calculating waiting times!
			System.out.println("Waiting of P"+i+" = "+waiting[i]);
	}
}