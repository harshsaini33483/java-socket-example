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

//end class







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