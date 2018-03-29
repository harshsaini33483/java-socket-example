import java.io.*;
import java.util.*;
import java.net.*;

class Check{
	public static PrintStream pw;
	public static BufferedReader br;
	public Socket s;
	public static Server serve;
	public Check(Socket s){
		this.s=s;
		try{
			pw=new PrintStream(s.getOutputStream());
		    br=new BufferedReader(new InputStreamReader(s.getInputStream()));
           }
		catch(Exception e){System.out.println("PrintStream is Not Working");}
	}

	public void valid()throws Exception
	{ 
		String login=br.readLine();
		String name;
		if(login.equalsIgnoreCase("register"))
		{
			System.out.println("New User");
		}
		else
		{
			System.out.println("Old User");
		}

	}
}