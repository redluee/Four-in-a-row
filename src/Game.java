import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Game {
	private BufferedReader br;
	ArrayList<Player> players;
	HashMap<String, String> board;
	int rows = 6;
	String columns = "abcdefg";

	public Game() {
		br = new BufferedReader(new InputStreamReader(System.in));
		board = new HashMap<String, String>();
		players = new ArrayList<Player>();
		
		boardCreation(rows, columns);
		
		System.out.println("Give the name of player 1: ");
		players.add(new Player(pInput(), "X"));
		System.out.println("Give the name of player 2: ");
		players.add(new Player(pInput(), "O"));
	}
	
	private void boardCreation(int rows, String columns) {
		int counter = 0;
		
		//column loop
		for(char c : columns.toCharArray()) {
			counter = 0;
			
			//row loop
			while(counter < rows) {
				counter ++;
				
				//hashmap key creation
				String key = c + Integer.toString(counter);
				board.put(key, "_");
			}
		}
	}
	
	public void run(){
		printBoard(rows, columns);
		printPlayerStats();
	}
	
	private String pInput() {
		String pInput = null;
		
		try {
			System.out.print("> ");
			pInput = br.readLine();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		return pInput;
	}
	
	private void printBoard(int rows, String columns) {
		int counter = 0;
		
		//columns get printed
		for(char c : columns.toCharArray()) {
			counter = 0;
			
			//row gets printed
			while(counter < rows) {
				counter++;
				String key = c + Integer.toString(counter);
				
				System.out.print(board.get(key));
			}
			System.out.println();
		}
	}
	
	private void printPlayerStats() {
		for(Player p : players) {
			System.out.println(p.getName().toUpperCase());
			System.out.println("-");
			System.out.println("Sign: " + p.getSign());
			System.out.println("Wins: " + p.getWins());
			System.out.println();
		}
	}
	
	
}
