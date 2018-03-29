import java.io.*;
import java.util.*;
import java.net.*;
//starting class 
class Server{
	public static ServerSocket ss;
	public static Socket s;
	public static Check check;
	public static HashMap<String,ArrayList<String>> friends;
	public static HashMap<String,String> nameandpass;
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
			serve=new Server();
			pw=new PrintStream(s.getOutputStream());//Output Stream
		    br=new BufferedReader(new InputStreamReader(s.getInputStream()));//Input Stream
           }
		catch(Exception e){System.out.println("PrintStream is Not Working");}
	}



//Validation of User and Check if user already exist or not 
	public void valid()throws Exception
	{ 
		String login=br.readLine();
		
		if(login.equalsIgnoreCase("register"))//if Client select register
		{
		   String name=br.readLine();
		   if(serve.nameandpass.containsKey(name))
		   {
		   	//Push Notifaication
		   	System.out.println("Already Exist Try Another One");
		   }	
		   else
		   {
		   	//Successfuull Added
		   	String pass=br.readLine();
		   	serve.nameandpass.put(name,pass);
		   }
		}

		
		else//if client select old user
		{
			//Old User Chat Page
			System.out.println("Old User");
		}

	}
}