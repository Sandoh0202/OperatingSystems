import java.util.*;
class FAS
{
	int block;
	FAS next,down;
	public FAS()
	{
		next=down=null;
	}
	public FAS(char a)				//For the sequential nodes
	{
		next=down=null;
	}
	public FAS(int a)
	{
		block=0;
		down=null;
	}
	public void work()
	{
		Scanner in=new Scanner(System.in);
		FAS start,ptr,temp;
		int n,b,c
		while(true)
		{
			System.out.print("/nEnter no of blocks in file: ");
			n=in.nextInt();
			if(n==0)
				break;
			
		}
		
	}
}

class FileAllocSeq
{
	public static void main(String args[])
	{
		FAS o=new FAS();
		o.work();	
	}
}