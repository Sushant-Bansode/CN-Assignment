import java.net.*;
import java.io.*;
import java.util.Scanner;
public class client2
{
    public static void main(String args[]) throws IOException
    {
        Socket s=new Socket("localhost",1254);
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        Scanner scn=new Scanner(System.in);
        int i, n;
        n=din.read();
        System.out.println("Number of frames to be received:"+n);
        int a[]=new int[n];
        for(i=0; i<n; i++)
        {
            System.out.println("Recieved "+(i+1)+"th frame.");
            a[i]=din.read();
        }
        System.out.println("");
        a[2]=-1;
        for(i=0; i<n; i++)
        {
            if(a[i]==-1){
                dout.write(i);
                break;
            }
        }
        while(i<n)
        {
            System.out.println("Received "+(i+1)+"th frame.");
            a[i]=din.read();
            i=i+1;
        }
        System.out.println("");
        System.out.print("Elements recieved are:");
        for(i=0; i<n; i++)
        {
            System.out.print(a[i]+" ");
        }
        s.close();
        din.close();
        dout.close();
        scn.close();
    }
}

