package fahadAndDavid;

import caveExplorer.CaveRoom;

public class LightsOut extends CaveRoom {

	private String activeDescription;
	private String inactiveDescription;
	private boolean active = true;

	public LightsOut(String description) {
		super(description);
		this.activeDescription = "Here you have to play a game of Lights Out.\nAll of the spaces on the board must be turned into '+' signs.";
		this.inactiveDescription = "The person you spoke to earlier is standing here.";
		this.active = true;
	}
	public void enter() {
		super.enter();
		if(active) {
			FahadFrontend.main(null);
		}
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
