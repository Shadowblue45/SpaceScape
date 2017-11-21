package yonathaWins;

import caveExplorer.CaveExplorer; 
import caveExplorer.CaveRoom;
import caveExplorer.NPC;

public class TylerCave extends CaveRoom {
 
	public boolean isChatting = true;
	String backstory = "You were on a space cruise when aliens came and abducted you. \n You're stuck on this spaceship now, with little chance of freedom.";
	String toEscape = "\n The aliens have killed all the human that were on the ship, except for you of course. \n Is escape possible, of course it is but it sure is difficult "
			+ "\n  ";
	String keys = "\n Some rooms that have parts require you to get keys before you can even enter. \n I won't give you any hints beyond that";
	String goodbye = "\n That's all I'm going to tell you, good luck and don't die!";
	
	String escapePods = "The escape pods are missing, search around to find them if you want to get out alive";
	String population = "The amount of people who embarked on the ship was 400, currently it is believed there are three";
	
	 
	
	public TylerCave(String description) {
		super(description);
		
	}
	public String validKeys() { 
		return "wdsae";
	}
	

	public void printAllowedEntry() {
		CaveExplorer.print("You can only enter 'w', 'a', 's', or 'd' to move or"
				+ "if you type e you can talk");}
	public void performAction(int direction) {
		if(direction == 4) {
				interact();
			}
		else {
			CaveExplorer.print("That key does nothing.");
		}
	}
		
	
	public void interact() {
		CaveExplorer.print("Hello, tell me your name");
		String userString = CaveExplorer.in.nextLine();
		while(isChatting) {
		if(userString.equalsIgnoreCase("jeff") || userString.equalsIgnoreCase("doge") ) {
			CaveExplorer.print("i like your name");
			explanation();
			}
		else {
			CaveExplorer.print("i don't like your name");
			explanation();	
				}
			}
		
		
		}
	
	public void explanation() {
		CaveExplorer.print("You know how you got here right?");
		String userString = CaveExplorer.in.nextLine();
			if(userString.equalsIgnoreCase("yes")){
				CaveExplorer.print("Well I'll tell you anyway. " + backstory + toEscape + goodbye  );
				isChatting = false;
			}
			else {
				CaveExplorer.print("Okay, " + backstory + toEscape + goodbye);
				isChatting = false;
			}
		
		}
	}



