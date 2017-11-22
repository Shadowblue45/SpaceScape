package yonathaWins;

import caveExplorer.CaveRoom;

public class GameStarter extends CaveRoom {

	public GameStarter(String description) {
		super(description);
		
	}
	public void enter() {
		super.enter();
		newYonathanFrontEnd.main(null);
	}

}
