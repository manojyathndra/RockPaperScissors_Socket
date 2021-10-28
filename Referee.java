import java.io.*;
import java.net.*;


public class Referee {
	private final int times = 10;
	private int player1, player2;

	public static void main(String[] args){
		//This method is complete. Do not change it.
		new Referee();
	}

	@SuppressWarnings("resource")
	public Referee() {
		//Complete this method
		//Select 16790 and 16791 the port # for Player1 and Player 2
		player1 = 0;
		player2 = 0;
	
		try {
			int player1port=16790;
			int player2port=16791;
			ServerSocket serverSocket1 = new ServerSocket(player1port); 
		    ServerSocket serverSocket2 = new ServerSocket(player2port);
		    Socket clientSocket = null;
		    Socket clientSocket2 = null;
		    clientSocket = serverSocket1.accept();
		    clientSocket2 = serverSocket2.accept();
			PrintWriter out1 = new PrintWriter(clientSocket.getOutputStream(), true);
		    BufferedReader in1 = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out2 = new PrintWriter(clientSocket2.getOutputStream(), true);
		    BufferedReader in2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));
			play(in1,in2);
			if (player1>player2){
				System.out.println("Winner is Player1");
				out1.println("Winner is Player1");
				out1.flush();
				out2.println("Winner is Player1");
				out2.flush();
				
			}
			else if(player2>player1){
				System.out.println("Winner is Player2");
				out1.println("Winner is Player2");
				out1.flush();
				out2.println("Winner is Player2");
				out2.flush();
			}
			else{
				System.out.println("It's Tie");
				out1.println("It's Tie");
				out1.flush();
				out2.println("It's Tie");
				out2.flush();
			}
		    clientSocket.close();
		    clientSocket2.close();

		}catch (IOException e) {
			System.out.println("Error: " + e);
			System.exit(0);
		}	
	}
  
	  private void play(BufferedReader in1, BufferedReader in2) {
		//Complete this method.
		//0: paper, 1: Rock, 2: Scissors    
		int sa = 0, sb=0;
		for(int i = 1; i <= times; i++ ) {
			try {
			sa = Integer.parseInt(in1.readLine());
			sb = Integer.parseInt(in2.readLine());
			} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			}
			switch(sa) 
			{
				case 0:
					switch(sb)
					{
						case 0:
							player1=player1;
							player2=player2;
							break;
						case 1:
							player1=player1+1;
							player2=player2;  
							break;
						case 2:
							player1=player1;
							player2=player2+1;
							break;
					}
				break;

				case 1:
					switch(sb)
					{
						case 0:
							player1=player1;
							player2=player2+1;
							break;
						case 1:
							player1=player1;
							player2=player2;
							break;
						case 2:
							player1=player1+1;
							player2=player2;
							break;
					}
				break;

				case 2: 
					switch(sb)
					{
						case 0:
							player1=player1+1;
							player2=player2;
							break;
						case 1:
							player1=player1;
							player2=player2+1;
							break;
						case 2:
							player1=player1;
							player2=player2;
							break;
					}
				break;
			}
		}
		
			
    }

	}
