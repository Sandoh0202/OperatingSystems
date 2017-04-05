import java.util.*;
class FCFS
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter number of processes: ");
		int p=in.nextInt(),i,flag=0,c,j;
		double a;
		int burst[]=new int[p];
		int arrive[]=new int[p];
		int waiting[]=new int[p];
		for(i=0;i<p;i++)
		{
			System.out.print("\nEnter Arrival Time: ");
			arrive[i]=in.nextInt();
			System.out.print("\nEnter Burst Time: ");
			burst[i]=in.nextInt();
		}c=arrive[0];
		for(i=0;i<p;i++)
		{
			waiting[i]=c-arrive[i];
			c+=burst[i];
			flag+=waiting[i];
			System.out.println("Waiting time for P"+i+" = "+waiting[i]+"ms");
		}
		a=(double)flag/p;
		System.out.println("Average waiting time: "+a+"ms");
	}
}
