import java.util.Scanner;
class SJFS
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter number of processes: ");
		int p=in.nextInt(),t=0,i,k=0,c=0,x,j,m,l;
		double a=0.0;
		int arrive[]=new int[p];
		int burst[]=new int[p];
		int waiting[]=new int[p];
		int index[]=new int[p];
		int order[]=new int[p];
		int queue[]=new int[p];
		for(i=0;i<p;i++)
		{
			index[i]=i;
			System.out.print("\nEnter Arrival time of P"+i+" : ");
			arrive[i]=in.nextInt();
			System.out.print("\nEnter Burst time of P"+i+" : ");
			burst[i]=in.nextInt();
		}
		index[0]=0;c=i=1;
		queue[0]=burst[0];
		while(k<p)
		{
			order[k]=index[c-1];
			waiting[k]=t-arrive[order[k]];
			k++;
			t+=queue[c-1];
			c--;
			for(;i<p;i++)
			{
				if(arrive[i]<=t)
				{
					queue[c]=burst[i];
					index[c++]=i;
				}
				else
				{
					i--;
					break;
				}
			}
			for(j=0;j<c;j++)
			{
				m=j;
				for(l=j+1;l<c;l++)
				{
					if(queue[m]<queue[l])
						m=l;
				}
				x=queue[m];
				queue[m]=queue[j];
				queue[j]=x;
				x=index[m];
				index[m]=index[j];
				index[j]=x;
			}
		}
		for(i=0;i<p;i++)
		{
			System.out.println("Waiting time for P"+order[i]+" = "+waiting[i]+"ms.");
			a+=(double)waiting[i];
		}
		a/=p;
		System.out.println("Average Waiting time: "+a+"ms.");
	}
}