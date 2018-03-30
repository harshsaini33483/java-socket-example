import java.io.*;
import java.util.*;
import java.net.*;
//starting class 
class Server{
	public static ServerSocket ss;
	public static Socket s;
	public static Check check;
    public static void main(String args[])throws Exception
	{
		try{ss=new ServerSocket(9090);}
		catch(Exception e){System.out.println("Port Already Used");}
		while(true)
		{
			try{s=ss.accept();}
			catch(Exception e){System.out.println("Socket is Not Accepting");}
			System.out.println("New Connection Established");
            check=new Check(s);
            check.valid(); 
		}

	}
}