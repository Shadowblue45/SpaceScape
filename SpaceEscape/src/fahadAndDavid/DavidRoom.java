package fahadAndDavid;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class DavidRoom extends CaveRoom {

	private String activeDescription;
	private String inactiveDescription;

	public DavidRoom(String description) {
		super(description);
		this.activeDescription = "You have escaped the spaceship!";
		this.inactiveDescription = "You to seem have somehow activated the escapepod, without entiring it...";
	}

	public String validKeys() {
		return "wdsae";
	}
	
	public void printAllowedEntry() {
		CaveExplorer.print("You can only enter 'w', 'a', 's', or 'd' to move or"
				+ "you can type 'e' to interact.");
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
				interact();
		}
		else {
			CaveExplorer.print("You must press the button to escape!");
		}
	}
	
	public String getContents() {
		return "F";
	}

	public void interact() {
			CaveExplorer.print("Congratulations! You have escaped the ship!");
			CaveExplorer.playing = false;
	}
}
