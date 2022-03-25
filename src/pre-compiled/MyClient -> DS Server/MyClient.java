import java.net.*;  
import java.io.*;  
class MyClient{  

public static void main(String args[]) throws Exception{  

	Socket clientSocket = new Socket("127.0.0.1",50000); //Socket Initialized with IP Address and Port.
	
	BufferedReader inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // Buffered Reader Initialized on Socket Input.
	DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

	// PrintWriter outputStream = new PrintWriter(clientSocket.getOutputStream(), true); //True, Enable Auto Flush.
	
	// Sending HELO
	outputStream.write(("HELO\n").getBytes());
	outputStream.flush();
	//Reply OK
	System.out.println("DS - Sim Response : " + inputStream.readLine()); 

	//Authenticating UserName
	String username = System.getProperty("user.name"); 
	outputStream.write(("AUTH " + username + "\n").getBytes()); 
	outputStream.flush();	
	// System.out.println("Authenticated: " + username);
	System.out.println("DS - Sim Response : " + inputStream.readLine());

	//Send REDY to Server
	outputStream.write(("REDY" + "\n").getBytes());
	outputStream.flush();
	System.out.println("Ds-sim Response: " + inputStream.readLine());

	
	outputStream.write(("QUIT" + "\n").getBytes());
	outputStream.flush();
	System.out.println("Ds-sim Response: " + inputStream.readLine());
	
	
	outputStream.close();
	inputStream.close();
	clientSocket.close();

	}
}
	
