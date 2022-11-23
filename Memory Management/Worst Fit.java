import java.util.Scanner;
class worstfit{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of partitions: ");
        int npart = sc.nextInt();
        System.out.print("Enter size of partitions: ");
        int part[] = new int[npart];
        for(int i=0;i<npart;i++)
            part[i] = sc.nextInt();
        System.out.print("Enter no. of processes: ");
        int npro = sc.nextInt();
        System.out.print("Enter size of processes: ");
        int pro[] = new int[npro];
        for(int i=0;i<npro;i++)
            pro[i] = sc.nextInt();
      
        int allocation[] = new int[npro];
		for (int i = 0; i < npro; i++)
			allocation[i] = -1;
		for (int i=0; i<npro; i++)
		{			int wstIdx = -1;
			for (int j=0; j<npart; j++)
			{
				if (part[j] >= pro[i])
				{
					if (wstIdx == -1)
						wstIdx = j;
					else if (part[wstIdx] < part[j])
						wstIdx = j;
				}
			}
			if (wstIdx != -1)
			{
				allocation[i] = wstIdx;
				part[wstIdx] -= pro[i];
			}
			if((allocation[i] != -1)) 
                System.out.println("Worst Fit found for process "+(i+1)+" in block no: "+(allocation[i]+1)+" with hole of : "+part[wstIdx]);
            else 
                System.out.println("Worst Fit for process "+(i+1)+" not found.");
		}
            
    }
}
