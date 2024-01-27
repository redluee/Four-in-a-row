
public class Player {
	private String name;
	private int wins;
	private String sign;
	
	public Player(String name, String sign) {
		this.name = name;
		wins = 0;
		this.sign = sign;
	}
	
	public String getName() {
		return name;
	}
	
	public int getWins() {
		return wins;
	}
	
	public String getSign() {
		return sign;
	}
	
	public void addWin() {
		wins ++;
	}
}
