import java.util.Scanner;
class MVT
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Enter total memory: ");
		int mem=in.nextInt(),x;
		
		while(true)
		{
			System.out.print("\nEnter process requirement: ");
			x=in.nextInt();
			if(x==-1)
				break;
			else if(x<mem)
			{
				mem-=x;
				System.out.println("Process Accomodated!\nTotal fragmentation: "+mem);
			}
			else
				System.out.println("Process cannot be accomodated!");
		}
	}
}