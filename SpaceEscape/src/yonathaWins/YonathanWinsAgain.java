package yonathaWins;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class YonathanWinsAgain extends CaveRoom {
	 String roomdescription = "you enter the room on the bed is jumpsuit with biohazard signs drawn on it the computer was left you see a lot of files labeled log plus a number";
	public YonathanWinsAgain(String description) {
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
		CaveExplorer.print("you enter the room on the bed is jumpsuit with biohazard signs drawn on it the computer was left on you see a lot of files labeled log plus a number to read them write read");
		String s = CaveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase("read")) {
			CaveExplorer.print("to read write read");
			s = CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("log 1: im keeping this log as mandated in my contract in order to prove that I have followed the contract guide lines.\n"
				+ " log 2: I boarded this ship with a cage containing the alien at 16:00. I dont know why I was sent on the first escape the room themed cruise ship aside from the fact that it was going the right direction\n"
				+ " log 3: the alien seems to be restless passing around its cage. I will go eat dinner im leaving the alien at 20:00 \n"
				+ " log 4: there seems to be a technical failure with the ship but ive been imformed its nothing to worry about the time is 20:45.\n"
				+ " log 5: somethings gone terribly wrong the aliens escaped and its seemed to have killed the rest of the people on this ship me and handful of people managed to escape before it killed us. \n"
				+ " DONT LET THIS SHIP LAND OR THE ALIEN WILL ESCAPE \n"
				+ " log 6: the alien ambushed us and I dont know where the rest of the survivoirs are but I here the alien outside my hiding spot\n"
				+ " log 7: This is an automated log system the vitals of this devices user have reached dangerous levels please send aid the timer is the time is 01:13.");
	}
	
	public String getContents() {
		return "L";
	}
	 
}
 