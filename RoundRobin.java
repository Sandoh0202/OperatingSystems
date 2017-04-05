import java.util.Scanner;
class RoundRobin
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Enter no. of processes & Quantum: ");
		int p=in.nextInt(),quant=in.nextInt(),i,t=0,tot=0,c=0,m=0,w;
		int bst[]=new int[p];
		int wait[]=new int[p];
		for(i=0;i<p;i++)
		{
			System.out.print("\nEnter Burst time of P"+i+" : ");
			bst[i]=in.nextInt();
			tot+=bst[i];
		}
		while(t<=tot)
		{
			//Checking finished processes
			if(bst[c]<=0)
				c++;
			if(c==p)
				c=0;
			//Waiting
			w=quant-bst[c];
			if(w<=0)
				w=quant;
			for(i=0;i<p;i++)
			{
				if(bst[i]>0 && i!=c)
					wait[i]+=w;
			}
			//Executing
			t+=quant;
			bst[c]-=quant;
			if(bst[c]<0)
				t+=bst[c];
		}
		for(i=0;i<p;i++);
			System.out.println("Waiting time of P"+i+" = "+wait[i]);
	}
}