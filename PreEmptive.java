import java.util.Scanner;
class PreEmptive
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
		for(i=0,k=-1;i<c;i++)						//The time array!
		{
			for(j=0;j<p;j++)			//putting on to stack
			{
				if(arrive[j]==i)
				{
					stack[++k]=burst[j];
					index[k]=j;break;
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
				if(j!=k)
					waiting[index[j]]+=1;
			}
			stack[k]=stack[k]==1?k--:stack[k]-1;
		}
		for(i=0;i<p;i++)
		{	
			System.out.println("Waiting of P"+i+" = "+waiting[i]+"ms.");
			a+=waiting[i];
		}
		a/=p;
		System.out.println("Avg Waiting Time: "+a+"ms.");
	}
}