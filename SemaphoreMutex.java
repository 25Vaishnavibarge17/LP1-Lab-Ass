import java.util.concurrent.Semaphore;
import java.util.Scanner;

class Main
{
    static Semaphore mutex = new Semaphore(1);
    static Semaphore wrt = new Semaphore(1);
    static int readCount = 0;
    static String message = "Hello";
    static public class Reader implements Runnable 
    {
        public void run()
        {
            try 
            {
                mutex.acquire();
                readCount++;  
                if(readCount==1)
                    wrt.acquire();
                mutex.release();
                
                System.out.println("Thread " +Thread.currentThread().getName() + " is reading : "+message);
                Thread.sleep(1500);
                System.out.println("Thread "+Thread.currentThread().getName()+ " has finished reading");
                
                mutex.acquire();
                readCount--; 
                if(readCount == 0)
                    wrt.release();
                mutex.release();
            } 
            catch(InterruptedException e) 
            {
                System.out.println(e.getMessage());
            }
        }
    }
    
    static public class Writer implements Runnable
    {
        public void run()
        {
            try
            {
                wrt.acquire();
                message = "Hello World";
                
                System.out.println("Thread "+Thread.currentThread().getName()+" is writing : "+message);
                Thread.sleep(1500);
                System.out.println("Thread "+Thread.currentThread().getName()+" has finished writing");
                
                wrt.release();
            }
            catch(InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void main(String[] args)
    {
        Reader r = new Reader();
       Writer w = new Writer();
        
        Thread r1 = new Thread(r);
        r1.setName("Rohan");
        
        Thread r2 = new Thread(r);
        r2.setName("Rohit");
        
        Thread r3 = new Thread(r);
        r3.setName("Pratham");
        
        Thread w1 = new Thread(w);
        w1.setName("Ram");
        
        Thread w2 = new Thread(w);
        w2.setName("Prutvi");
        
        Thread w3 = new Thread(w);
        w3.setName("Raj");
        
      w1.start();
      r1.start();
      w2.start();
      r2.start();
      w3.start();
      r3.start();
    }
}
