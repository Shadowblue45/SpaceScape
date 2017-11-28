package fahadAndDavid;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class FahadRoom extends CaveRoom {
	
	private boolean active;
	private String activeDescription;
	private String inactiveDescription; 
	
	public FahadRoom(String description) {
		super(description);
		this.activeDescription = "You feel a menacing aura.";
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
		CaveExplorer.print("Yo! Nice to meet you. I'm Josuke Higashikata. You need help?");
		String s = CaveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase("yes")) {
			CaveExplorer.print("I only accept yes for an answer.");
			s = CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("Don't you dare comeback.");
		CaveExplorer.josukeInParty = true;
		this.active = false;
	}
	
	public String getContents() {
		return "J";
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
