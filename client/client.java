import java.net.*;
import java.io.*;
import java.util.*;
class client{
	public static void main(String args[])throws Exception
	{
		Socket sock=new Socket("localhost",9090);
		BufferedReader br=new BufferedReader(new InputStreamReader(sock.getInputStream()));
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		String str;
		PrintStream ps=new PrintStream(sock.getOutputStream());
		str=sc.readLine();
		ps.println(str);
		
		str=sc.readLine();
		ps.println(str);
		    
        str=sc.readLine();
		ps.println(str);
		
	}
}