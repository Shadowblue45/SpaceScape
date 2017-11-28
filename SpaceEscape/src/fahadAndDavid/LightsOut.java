package fahadAndDavid;

import caveExplorer.CaveRoom;

public class LightsOut extends CaveRoom {

	public LightsOut(String description) {
		super(description);
	}
	public void enter() {
		super.enter();
		FahadFrontend.main(null);
	}
	
	public String getContents() {
		return "L";
	}

}
