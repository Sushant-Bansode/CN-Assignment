import java.net.*;
import java.io.*;
import java.util.Scanner;
public class server2
{
    public static void main(String args[]) throws IOException
    {
        ServerSocket ss=new ServerSocket(1254);
        Socket s=ss.accept();
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        Scanner scn=new Scanner(System.in);
        int i, n, temp;
        System.out.print("Enter the number elements to be sent:");
        n=scn.nextInt();
        int a[]=new int[n];
        System.out.print("Enter the array elements:");
        for(i=0; i<n; i++)
        {
            a[i]=scn.nextInt();
        }
        System.out.println("");
        dout.write(n);
        for(i=0; i<n; i++)
        {
            System.out.println("Sending "+(i+1)+"th frame.");
            dout.write(a[i]);
        }
        temp=din.read();
        System.out.println("");
        System.out.println("Error in "+(temp+1)+"th frame.");
        System.out.println("Resending all the frames from "+(temp+1)+"th frame.");
        System.out.println("");
        for(i=temp; i<n; i++)
        {
            System.out.println("Sending "+(i+1)+"th frame.");
            dout.write(a[i]);
        }
        ss.close();
        s.close();
        dout.close();
        din.close();
        scn.close();
    }
}
