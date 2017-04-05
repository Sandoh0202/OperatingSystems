import java.util.Scanner;
class Priority
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Processes: ");
		int p=in.nextInt(),i,j,m,x,k=0,l,c,t=0;
		int arrive[]=new int[p];
		int burst[]=new int[p];
		int prior[]=new int[p];
		int index[]=new int[p];
		int order[]=new int[p];
		int queue[]=new int[p];
		int waiting[]=new int[p];
		for(i=0;i<p;i++)
		{
			index[i]=i;
			System.out.print("\nArrival: ");
			arrive[i]=in.nextInt();
			System.out.print("\nBurst: ");
			burst[i]=in.nextInt();
			System.out.print("\nPriority: ");
			prior[i]=in.nextInt();
		}
		c=i=1;double a=0.0;
		queue[0]=burst[0];
		while(k<p)
		{
			order[k]=index[c-1];
			waiting[k]=t-arrive[order[k]];
			k++;
			t+=queue[c-1];					//Updating system time
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
			for(j=0;j<c;j++)				//Sorting stack
			{
				m=j;
				for(l=j+1;l<c;l++)
				{
					if(prior[index[m]]<prior[index[l]])
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
			System.out.println("Waiting time of P"+order[i]+" = "+waiting[i]);
			a+=waiting[i];
		}
		a/=p;
		System.out.println("Avergae waiting time = "+a);
	}
}