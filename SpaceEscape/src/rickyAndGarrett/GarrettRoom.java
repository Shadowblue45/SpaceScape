package rickyAndGarrett;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class GarrettRoom extends CaveRoom {
	
	private String[] trivia = {"The cruise ship can accelerate up to 2 kilometers per second.",
			"The most popular anime currently is Neon Genesis Evangelion.",	   
			"If you give Josuke a new pair of shoes, for one time only, Josuke will help you break down a wall. Don't ask why.",
			"This ship is the first escape room themed ship and can hold up to 400 people.",
			"A few of the bartenders that died, watered down beer. The aliens did not approve.",
			"In the year 20XX, Beyblade became the most popular sport of all."};

	public GarrettRoom(String description) {
		super(description);
	}
	
	public String validKeys() {
		return "wdsae";
	}
	
	public void printAllowedEntry() {
		System.out.println("You can only enter 'w', 'a', 's', 'd' to move, or 'e' to interact.");
	}
	
	public void performAction(int direction) {
		if(direction == 4) { 
			interact();
		}else {
			CaveExplorer.print("That key does nothing.");
		}
	}

	public void interact() {
		CaveExplorer.print("Welcome to the Trivia Room. Enter 'trivia' for a random fact");
		String s = CaveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase("trivia")) {
			CaveExplorer.print("Please type 'trivia' for knowledge.");
			s = CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("Suddenly, a slip of paper falls from the ceiling. You pick it up and read it.\n" 
				+ trivia[(int)(Math.random() * trivia.length)]);
	}
	
	public String getContents() {
		return "T";
	}
	
}
