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
	String columns = "ABCDEFG";
	boolean keepPlaying = true;
	Player playerOnTurn;

	public Game() {
		br = new BufferedReader(new InputStreamReader(System.in));
		board = new HashMap<String, String>();
		players = new ArrayList<Player>();
		
		boardCreation(rows, columns);
		
		System.out.println("Give the name of player 1: ");
		players.add(new Player(pInput(), "X"));
		System.out.println("Give the name of player 2: ");
		players.add(new Player(pInput(), "O"));
		
		playerOnTurn = players.get(0);
	}
	
	private void boardCreation(int rows, String columns) {
		int counter = 0;
		
		//column loop
		for(char c : columns.toCharArray()) {
			counter = 0;
			
			//row loop
			while(counter <= rows) {
				counter ++;
				
				//hashmap key creation
				String key = c + Integer.toString(counter);
				board.put(key, "_");
			}
		}
	}
	
	public void run(){
		String input;
		
		printBoard();
		System.out.println("abcdefg");
		System.out.println();
		printPlayerStats();
		System.out.println();
		
		while(keepPlaying) {
			input = pInput();
			handleInput(input);
		}
		
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
	
	private void handleInput(String pInput) {
		String[] input = pInput.split(" ");
		
		switch(input[0]) {
		case "put":
			if(!input[1].isEmpty()) {
				placeSign(input[1]);
			}else {
				System.out.println("Please give a column");
			}
			break;
			
		case "help":
			printHelp();
			break;
			
		case "board":
			printBoard();
			break;
			
		case "exit":
			keepPlaying = false;
		
		default:
			System.out.println(pInput + " is not a valid command");
		}
	}
	
	private void placeSign(String column) {
		String sign = playerOnTurn.getSign();
		int counter = 0;
		
		if(columns.contains(column)){
			
			
			
		}else {
			System.out.println(column + " is not a valid column");
		}
	}
	
	private void printBoard() {
		int counter = 0;
		
		//columns get printed
		for(char c : columns.toCharArray()) {
			counter = 0;
			
			//row gets printed
			while(counter <= rows) {
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
	
	private void printHelp() {
		System.out.println("Connect four");
		System.out.println("----------------");
		System.out.println("Try to connect four of your own signs");
		System.out.println("Type 'place' + 'column letter'");
		System.out.println("Example: place a");
		System.out.println("----------------");
	}
	
	
}
