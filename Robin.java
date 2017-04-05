import java.util.*;
class Robin
{
	publlic static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Processes and Quantum: ");
		int p=in.nextInt(),q=in.nextInt(),t=0,i,c=0,x,m;
		int arr[]=new int[p];
		int bst[]=new int[p];
		int ind[]=new int[p];
		for(i=0;i<p;i++)
		{
			System.out.print("\n\nEnter Arrival time: ");
			arr[i]=in.nextInt();
			System.out.print("\nEnter Burst time: ");
			bst[i]=in.nextInt();
			tot+=bst[i];
		}
		while(true)
		{
			//inception
			for(i=0;i<p;i++)
			{
				if(arr[i]>t && arr[i]<=(t+q))
				{
					queue[c]=bst[i];
					ind[c++]=i;
				}	
			}
				
			//decrementation
			x=q;
			queue[0]-=q;
			if(queue[0]<=0)
			{
				x=q+queue[0];
				for(i=0;i<c-1;i++)
					queue[i]=queue[i+1];
				c--;
			}
			t+=x;
			
			//waiting time calculation & empty process removal
			i=x==q?1:0;
			for(;i<c;i++)
				waiting[ind[i]]+=x;
			
			//flip
			x=queue[0];
			for(i=0;i<c-1;i++)
				queue[i]=queue[i+1];
			queue[i]=x;
		}
	}
}