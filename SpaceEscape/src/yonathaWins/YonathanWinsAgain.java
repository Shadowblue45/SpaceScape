package yonathaWins;

import caveExplorer.CaveRoom;

public class YonathanWinsAgain extends CaveRoom {
 String roomdescription = "you enter the room on the bed is jumpsuit with biohazard signs drawn on it the computer was left you see alot of files labeled notes";
 String notesone ="";
 String notestwo ="";
	public YonathanWinsAgain(String description) {
		super(description);
		
	}



// the minigame should unlock the door with the function in cave room also check knockles code

	public void preformAction() {
	
	}
	public void performAction(int direction) {
		System.out.println("That key does nothing.");
	}
	public void printAllowedEntry() {

		System.out.println("hello");

		System.out.println("When you enter the room you see and information kiosk");

	}
	public String validKeys() {
		return "wdsae";
	}
	 
}
 