import java.util.Scanner;
class MFT
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter total memory and no. of partitions - ");
		int mem=in.nextInt(),p=in.nextInt(),size=mem/p,frag=(mem%p),x;
		System.out.println("External Fragmentation: "+frag);
		while(true)
		{
			System.out.print("\nEnter process requirement: ");
			x=in.nextInt();
			if(x==-1)
				break;
			else if(x>size || p==0)
			{
				System.out.println("Process cannot be accomodated!");
				continue;
			}
			else
			{
				frag+=(size-x);
				p--;System.out.println("Process Accomodated!\nInternal Fragmentation: "+(size-x)+"\nTotal fragmentation: "+frag);
			}
		}
	}
}