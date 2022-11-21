import java.util.*;
class LRU {
  public static void main(String args[]) {
  Scanner sc = new Scanner(System.in);
  System.out.println("ENTER NUMBER OF FRAMES");
    int f = sc.nextInt();
    System.out.println("ENTER NUMBER OF INPUTS");
    int n = sc.nextInt();
    int inputs[] = new int[n];
    int frame[] = new int[f];
    System.out.println("ENTER INPUT");
    for (int i = 0; i < n; i++) inputs[i] = sc.nextInt();
    for (int i = 0; i < f; i++) frame[i] = -1;
    int flag = 0, hit = 0, miss = 0, rear = -1;
    int age[] = new int[f];
    for (int i = 0; i < f; i++) age[i] = 0;

    for (int j = 0, i = 0; j < f && i < n; j = j % f, i++)
     {
      flag = 0;
      for (int y = 0; y < f; y++) 
      {
        if (frame[y] == inputs[i]) {
          flag = 1;
          hit++;
          age[y] = 0;
        }
      }
      if (flag == 0) 
      {
        if (frame[j] == -1)
         {
          frame[j] = inputs[i];
          miss++;
          rear++;
          j++;
         } 
        else
        {
        int max = age[0], loc = 0;
        miss++;
        for (int b = 0; b < f; b++) if (age[b] > max)
        {
          max = age[b];
          loc = b;
        }
          frame[loc] = inputs[i];
          age[loc] = 0;
          j++;
        }
      }
      for (int a = 0; a < f; a++) {
        if (frame[a] == -1) 
        age[a] = 0; 
        else 
        age[a]++;
      }
    }
    float hr = (float) hit / ((float) hit + (float) miss);
    System.out.println("Hit=" + hit + " miss=" + miss);
    System.out.println("page replacement ratio=" + hr);
  }
}
