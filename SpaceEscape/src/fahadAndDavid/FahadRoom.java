package fahadAndDavid;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class FahadRoom extends CaveRoom {
	
	private boolean active;
	private String activeDescription;
	private String inactiveDescription; 
	
	public FahadRoom(String description) {
		super(description);
		this.activeDescription = "There is a person waiting to talk to you.";
		this.inactiveDescription = "The person you spoke to earlier is standing here.";
		this.active = true;
	}
	
	//underneath replace
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
			CaveExplorer.print("That key does nothing.");
		}
	}

	public void interact() {
		CaveExplorer.print("Yo! Nice to meet you. I'm Josuke Higashikata");
		String s = CaveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase("bye")) {
			CaveExplorer.print("Why are you still here");
			s = CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("Don't you dare comeback.");
		this.active = false;
	}
	
	public String getContents() {
		return "D";
	}
	
	public boolean isActive() {
		return active;
	}

	public String getInactiveDescription() {
		return inactiveDescription;
	}

	public String getActiveDescription() {
		return activeDescription;
	}
	
	public String getDescription() {
		if(!isActive()) {
			return super.getDescription() + "\n" + getInactiveDescription();
		}else {
			String npcDesc = "";
				npcDesc = getActiveDescription();
			return super.getDescription() + "\n" + npcDesc;
		}
	}

}
