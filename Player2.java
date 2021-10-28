import java.io.*;
import java.net.*;
import java.util.Random;

public class Player2{
  //Complete this class.
  //This class is similar to the class: Player1.
  //Use the por # 16791
  public Player2() {
       Socket clientSocket2 = null;
    try {// Complete this part. Use the port number: 16790
		int port = 16791;
		    String host = "localhost";
		    clientSocket2 = new Socket(host, port);
		    PrintWriter out2 = new PrintWriter(clientSocket2.getOutputStream(), true);
			BufferedReader in2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));
			play(out2);
			System.out.println(in2.readLine());
		    clientSocket2.close();
    }catch (IOException e) {
      System.out.println("Error: " + e);
      System.exit(0);
    }   		
  }
  public static void main(String[] args){
    //This method is complete. Do not change it.
  	new Player2();
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
    System.out.println("P2=");
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
  



