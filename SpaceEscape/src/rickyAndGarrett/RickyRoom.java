package rickyAndGarrett;

import caveExplorer.CaveExplorer;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;

public class RickyRoom extends NPCRoom {
	
	private NPC presentNPC;
	private String[] responses = {"I am waiting for an answer...","Help me! I'm getting bored","...","Anyday now...","A response would be lovely now."};

	public RickyRoom(String description) {
		super(description);
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			CaveExplorer.print("There's no one here who is active to talk to you... You're gonna have to wait until the NPC comes back from lunch");
			CaveExplorer.print("You can play the NPC's minigame while you wait, it should be right below this room.");
		}
		else {	
			interact();
		}
	}

	
	public void interact() {
		CaveExplorer.print("Welcome to the Break Room. Here, You will be entered for a quick break from your journey");
		String s = CaveExplorer.in.nextLine();
		while(!(s.equalsIgnoreCase("leave"))){
			CaveExplorer.print(getResponse() + " \n (If you want, you can type 'leave' in order to leave this room.)");
			CaveExplorer.print("I am waiting for an answer...(psst! Type 'leave' in order to leave this room.)");
			s = CaveExplorer.in.nextLine();
			CaveExplorer.print("Well, It was nice meeting you. Good Luck on your journey and safe travels.");
		}
	}
	
	public String getContents() {
		return "R";
	}
	

	public String getResponse() {
		return responses[(int)(Math.random()* responses.length)];
	}
}
/*
	CaveRoom customRoom = new NPCRoom("Room");
	CaveExplorer.caves[2][3] = customRoom;
*/	
