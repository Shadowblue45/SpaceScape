package fahadAndDavid;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class DavidRoom extends CaveRoom {
	
	private boolean active = true;
	private static int ROCK = 0;
	private static int PAPER = 1;
	private static int SCISSORS = 2;
	private int numOfGames = 1;
	
	
	public DavidRoom(String description) {
		super(description);
	}

	//underneath replace
	public String validKeys() {
		return "wdsae";
	}
	
	public void printAllowedEntry() {
		CaveExplorer.print("You can only enter 'w', 'a', 's', or 'd' to move or" + "you can type 'e' to interact.");
	}

	public void performAction(int direction) {
		if(direction == 4) {
			interact();
		}else {
			CaveExplorer.print("That key does nothing.");
		}
	}
	
	public void interact() {
		if(active) {
			CaveExplorer.print("Verse me in rock paper scissors! First to win!\nType 'r', 's' or 'p' to choose rock paper or scissors respectively.");
			String s = CaveExplorer.in.nextLine();
			while(!s.equalsIgnoreCase("r")) {
				if(s.equalsIgnoreCase("s")) {
					CaveExplorer.print("I chose scissors too! We tie");
					numOfGames++;
				}
				if(s.equalsIgnoreCase("p")) {
					CaveExplorer.print("I chose scissors! You lose, try again until you win!");
					numOfGames++;
				}else {
					CaveExplorer.print("That's not a choice!");
				}
					s = CaveExplorer.in.nextLine();
			}
			CaveExplorer.print("You have beat me in this game, my choices the same. Now tell me how many tries, including our ties, it took you to win.");
			s = CaveExplorer.in.nextLine();
			int answer = Integer.valueOf(s);
			while(answer != numOfGames) {
				CaveExplorer.print("Thats not the answer!");
				s = CaveExplorer.in.nextLine();
				
				answer = Integer.valueOf(s);
			}
			CaveExplorer.print("Congradulations you beat me!");
			active = false;
		}else {
			CaveExplorer.print("You already beat me in RPS!");
		}
	}
}
