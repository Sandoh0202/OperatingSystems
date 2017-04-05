import java.io.*;
class DeadLockDetect
{
	public static void main(String args[])throws IOException
	{
		File data = new File("sample.txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(data)));
		//Scanner in = new Scanner(new FileInputStream(f));
		//System.out.print("Enter no of resources and processes: ");
		int r=Integer.parseInt(in.readLine()),p=Integer.parseInt(in.readLine()),s=0,k=0,i,j,c=1;
		int res[]=new int[r];
		int avl[]=new int[r];
		int clm[][]=new int[p][r];
		int alc[][]=new int[p][r];
		int done[]=new int[p];
		System.out.println("\nTotal resources - ");
		for(i=0;i<r;i++)
		{
			res[i]=Integer.parseInt(in.readLine());
			System.out.print(res[i]+"\t");
		}	
		System.out.println("\n\nAvailable resources - ");
		for(i=0;i<r;i++)
		{
			avl[i]=Integer.parseInt(in.readLine());
			System.out.print(avl[i]+"\t");
		}	
		System.out.println("\n\nAllocation array - ");
		for(i=0;i<p;i++)
		{
			for(j=0;j<r;j++)
			{
				alc[i][j]=Integer.parseInt(in.readLine());
				System.out.print(alc[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("\nClaim array - ");
		for(i=0;i<p;i++)
		{
			for(j=0;j<r;j++)
			{
				clm[i][j]=Integer.parseInt(in.readLine());
				System.out.print(clm[i][j]+"\t");
			}
			System.out.println();
		}
		//Checking if alloc + avail = resources
		for(i=0;i<r;i++)
		{
			for(s=0,j=0;j<p;j++)
				s+=alc[j][i];
			s+=avl[i];
			if(s!=res[i])
				break;
		}
		if(i==r)
			k=1;
		//Checking if claim <= resources
		abc:
		for(i=0;i<r;i++)
		{
			for(j=0;j<p;j++)
			{
				if(clm[j][i]>res[i])
					break abc;
			}
		}
		if(i==r && k==1)
		{
			//Checking for process ordering
			while(c<=p)
			{
				s=0;
				for(i=0;i<p;i++)
				{
					if(done[i]!=0)
						continue;
					for(j=0;j<r;j++)
					{
						if(clm[i][j]>avl[j])
							break;
					}
					if(j==r)
					{
						done[i]=c++;s=1;
						//System.out.println("Process P"+i+" is executed!");
						for(j=0;j<r;j++)
							avl[j]+=alc[i][j];
					}
				}
				if(i==p && s==0)
				{
					System.out.println("OMG! DeadLock cannot be avoided!");
					break;
				}	
			}
			if(c>p)
				System.out.println("No wait... Deadlock Avoided!");
		}
		else if(k==0)
			System.out.println("Invalid Input!");
		else
			System.out.println("Deadlock cannot be Avoided!");
	}
}