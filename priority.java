import java.util.Scanner;
public class priority
{
   public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of process: ");
		int n = sc.nextInt();
		int pid[] = new int[n];   // process ids
		int ar[] = new int[n];     // arrival times
		int bt[] = new int[n];     // burst or execution times
		int ct[] = new int[n];     // completion times
		int ta[] = new int[n];     // turn around times
		int wt[] = new int[n];     // waiting times 
        int f[] = new int[n]; //set 1 if Bt finished
        int pri[] = new int[n];
		int temp, tot=0,st=0;
		float avgwt=0,avgta=0;
 
		for(int i = 0; i < n; i++)
		{
			System.out.println("enter process " + (i+1) + " arrival time: ");
			ar[i] = sc.nextInt();
			System.out.println("enter process " + (i+1) + " brust time: ");
			bt[i] = sc.nextInt();
			System.out.println("enter process " + (i+1) + " priority: ");
			pri[i] = sc.nextInt();
            
			pid[i] = i+1;
			f[i]=0;
		}
        while(true)
        {
            int min = 99  , c = n;
            if(tot == n)
                break;
                
            for(int i=0;i<n;i++)
            {
                if(ar[i]<=st && f[i]==0 && pri[i]<min )
                {
                    min = pri[i];
                    c = i;
                }
            }
            
            if(c == n) 
                st++;
                
            else
            {
                st=st+bt[c];
                ct[c] = st;
                f[c]=1;
                tot++;
            }
        }
        for(int i=0;i<n;i++)
            {
                ta[i] = ct[i] - ar[i];
                wt[i] = ta[i] - bt[i];
                avgwt += wt[i];
                avgta += ta[i];
            }
                                    
        System.out.println("pid  arrival  burst  priority complete turn waiting");
	    for(int i=0;i<n;i++)
	    {
	    	System.out.println(pid[i] +"\t"+ ar[i]+"\t"+ bt[i] +"\t"+ pri[i]+"\t"+ ct[i] +"\t"+ ta[i] +"\t"+ wt[i]);
	    }
	    
	    System.out.println("\naverage tat is "+ (float)(avgta/n));
	    System.out.println("average wt is "+ (float)(avgwt/n));
	    sc.close();
    }
    
}
