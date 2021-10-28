import java.io.*;
import java.net.*;
import java.util.Random;


public class Player1 {
	public Player1() {
       Socket clientSocket = null;
    try {// Complete this part. Use the port number: 16790
	int port = 16790;
		    String host = "localhost";
		    clientSocket = new Socket(host, port);
		    PrintWriter out1 = new PrintWriter(clientSocket.getOutputStream(), true);
		    BufferedReader in1 = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			play(out1);		
			System.out.println(in1.readLine());
		    clientSocket.close();
    }catch (IOException e) {
        System.out.println("Error: " + e);
        System.exit(0);
      }      		
  }
  public static void main(String[] args){
    //This method is complete. Do not change it.
  	new Player1();
  }
  
  private void play(PrintWriter out) {
    //This method is complete. Do not change it.
    final int times = 10;
    Random rand = new Random();
    for(int i =1; i <= times; i++) {
      int ply = rand.nextInt(3);
      out.println("" + ply);
      display(ply);
    }
    System.out.println("P1=");
  }
  
  private void display(int ply) {
    //This method is complete. Do not change it.
    if(ply == 0)
    	System.out.print("Papaer,");
    else if(ply == 1)
    	System.out.print("Rock,");
    else
    	System.out.print("Scissors,");
	}
}

