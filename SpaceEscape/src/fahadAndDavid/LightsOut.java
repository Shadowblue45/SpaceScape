package fahadAndDavid;

import caveExplorer.CaveRoom;

public class LightsOut extends CaveRoom {

	private String activeDescription;
	private String inactiveDescription;
	private boolean active = true;

	public LightsOut(String description) {
		super(description);
		this.activeDescription = "Here you have to play a game of Lights Out.\nAll of the spaces on the board must be turned into '+' signs.";
		this.inactiveDescription = "This is where you completed the game of Lights Out.";
		this.active = true;
	}
	public void enter() {
		super.enter();
		System.out.println(getDescription());
		if(active) {
			FahadFrontend.main(null);
		}
		this.active = false;
	}
	
	public String getDescription() {
		if(!isActive()) {
			return super.getDescription() + "\n" + getInactiveDescription();
		}else {
			String npcDesc = "";
				npcDesc = getActiveDescription();
			return npcDesc;
		}
	}
	
	public String getContents() {
		return "L";
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

}
