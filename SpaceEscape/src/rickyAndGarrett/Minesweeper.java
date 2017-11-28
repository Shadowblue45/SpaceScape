package rickyAndGarrett;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class Minesweeper extends CaveRoom {

	public Minesweeper(String description) {
		super(description);
	}

	public void enter() {
		CaveExplorer.print("Welcome to Minesweeper.\nBeat the game in order to move on");
		RickyFrontEnd.main(null);
	}
	
	public String getContents(){
		return "M";
	}

}
