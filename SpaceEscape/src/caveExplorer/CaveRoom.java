package caveExplorer;

import fahadAndDavid.DavidRoom;
import fahadAndDavid.FahadRoom;
import fahadAndDavid.LightsOut;
import rickyAndGarrett.GarrettRoom;
import rickyAndGarrett.Minesweeper;
import rickyAndGarrett.RickyRoom;
import yonathaWins.GameStarter;
import yonathaWins.TylerCave;

import yonathaWins.YonathanWinsAgain;//github.com/Shadowblue45/SpaceScape.git


import yonathaWins.TylerCave;
import yonathaWins.YonathanWinsAgain;


public class CaveRoom {
	
	private String description;//tells what the room looks like
	private String directions;//tells what you can do
	private String contents;//symbol representing what's in the room
	private String defaultContents;
	//the rooms are organized by directions, 'null' signifies no room/door in that direction
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	private boolean directionNotChosen = true;
	
	//constants
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;

	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		//difference between defaultContents and contents is "contents" becomes an 'X' when you are
		//inside this room, when you leave, it goes back to defaultContents
		
		//note: by default, arrays will populate with 'null' meaning there are no connections
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}

	
	/**
	 * for every door in doors[] appends a String to "directions" describing the access.
	 * For example:
	 * 	"There is a door to the north"
	 * 	"There is a door to the south"...etc
	 * 
	 * If there are no doors at all, directions should say:
	 * 		"There are no doors, you are trapped in here."
	 */
	public void setDirections() {
		directions = "";
		boolean doorFound = false;
		for(int i = 0; i < doors.length; i++) {
			if(doors[i] != null) {
				doorFound = true;
				directions += "\n   There is a " + doors[i].getDescription() + " to " + 
				toDirection(i) + ". " + doors[i].getDetails();
			}
		}
		if(!doorFound) {
			directions += "There is no way out. You are trapped in here.";
		}
	}
	
	
	/**
	 * converts an int to a direction
	 * 	toDirection(0) -> "the North"
	 * etc
	 * @param dir
	 * @return
	 */
	public static String toDirection(int dir) {
		String[] direction = {"the North", "the East", "the South", "the West"};
		return direction[dir];
	}
	
	public void enter() {
		contents = "X";
	}
	
	public void leave() {
		contents = defaultContents;
	}
	
	/**
	 * Gives this room access to anotherRoom (and vice-versa)
	 * and sets a door between them, updating the directions
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}

	public static int oppositeDirection(int direction) {
		return (direction + 2) % 4;
	}


	public void addRoom(int direction, CaveRoom cave, Door door) {
		borderingRooms[direction] = cave;
		doors[direction] = door;
		setDirections();
	}
	
	public void interpretInput(String input) {
		while(!isValid(input)) {
			printAllowedEntry();
			input = CaveExplorer.in.nextLine();
		}
		//task: convert user input into a direction
		//DO NOT USE AN IF STATEMENT
		//(or, if you must, don't use more than 1)
		String dirs = validKeys();
		respondToKey(dirs.indexOf(input));
	}
	
	/**
	 * override to add more keys, but always include 'wdsa'
	 * @return
	 */
	public String validKeys() {
		return "wdsaer";
	}
	
	/**
	 * override to print a custom string describing what keys do
	 */
	public void printAllowedEntry() {
		System.out.println("You can only enter 'w', 'a', 's', 'd', or 'r'.");
	}


	public boolean isValid(String input) {
		String validEntries = validKeys();
		//System.out.print("Checking for input " + input + ", got index " + validEntries.indexOf(input));
		return validEntries.indexOf(input) > -1 && input.length() == 1;
	}


	public void respondToKey(int direction) {
		//first, protect against null pointer exception
		//(user cannot go through non-existent door)
		if(direction < 4) {
			if(borderingRooms[direction] != null && 
					doors[direction] != null) {
				CaveExplorer.currentRoom.leave();
				CaveExplorer.currentRoom = borderingRooms[direction];
				CaveExplorer.currentRoom.enter();
				CaveExplorer.inventory.updateMap();
			}
		}
		else if(direction == 5) {
			if(CaveExplorer.josukeInParty) {
				activateJotaro();
				CaveExplorer.josukeInParty = false;
				CaveExplorer.inventory.updateMap();
			}
			else {
				System.out.println("Josuke isn't with you yet. You have to go find him.");
			}
		}
		else {
			performAction(direction);
		}
	}
	
	public void activateJotaro() {
		String validKeys = "8624";
		System.out.println("Pick a direction");
		while(directionNotChosen) {
			String input = CaveExplorer.in.nextLine();
			if(validKeys.indexOf(input) > -1 && input.length() == 1) {
				respondToInput(validKeys.indexOf(input));
			}
			else {
				System.out.println("You can only enter '8', '6', '2', or '4'.");
			}
		}
		System.out.println("Alright. I've made a path.");
	}


	public void respondToInput(int direction) {
		if(direction < 4) {
			if(borderingRooms[direction] != null && doors[direction] == null) {
				CaveExplorer.currentRoom.setConnection(direction, borderingRooms[direction], new Door());
				directionNotChosen = false;
			}
		}
		else {
			performAction(direction);
		}
	}


	/**
	 * Override to give response to keys other than wasd
	 * @param direction
	 */
	
	public void performAction(int direction) {
		System.out.println("That key does nothing.");
	}

	/**
	 * and all the connections
	 */
	public static void setUpCaves() {
		//ALL OF THIS CODE CAN BE CHANGED
		//1. Decide how big your caves should be
		CaveExplorer.caves = new CaveRoom[5][5];
		//2. Populate with caves and a default description: hint: when starting, use coordinates (helps debugging)	
		for(int row = 0; row < CaveExplorer.caves.length; row++) {
			//PLEASE PAY ATTENTION TO THE DIFFERENCE:
			for(int col = 0; col < CaveExplorer.caves[row].length; col++) {
				//create a "default" cave
				CaveExplorer.caves[row][col] = 
						new NPCRoom("This cave has coords (" + row + "," + col + ")");
			}
		}
		//3. Replace default rooms with custom rooms
		CaveRoom customFahad = new FahadRoom("Josuke's Room");
		CaveExplorer.caves[1][4] = customFahad;
		CaveRoom customDavid = new DavidRoom("Maths Room");
		CaveExplorer.caves[4][4] = customDavid;
		CaveRoom customLightsOut = new LightsOut("Lights Out");
		CaveExplorer.caves[0][1] = customLightsOut;
		//--- WE WILL DO LATER
		
		

		CaveRoom customGar = new GarrettRoom("Trivia Room");
		CaveExplorer.caves[1][3] = customGar;
		CaveRoom customRoomRicky = new RickyRoom("Ricky Room");
		CaveExplorer.caves[0][2] = customRoomRicky;

		
		CaveExplorer.npcs = new NPC[1];
		CaveExplorer.npcs[0] = new NPC();
		CaveExplorer.npcs[0].setPosition(1,1);


		//ad each person room like this

		CaveRoom customTyler = new TylerCave("Room");
		CaveExplorer.caves[0][0] = customTyler;
		CaveRoom customYonathan = new GameStarter("Flow Room");
		CaveExplorer.caves[3][4] = customYonathan;
		CaveRoom flowRoom = new YonathanWinsAgain("Yonathan Room");
		CaveExplorer.caves[2][4] = flowRoom;
		CaveRoom minesweeperRoom = new Minesweeper("Minesweeper Room");
		CaveExplorer.caves[1][2] = minesweeperRoom;
		
		//4. Set your starting room:
		CaveExplorer.currentRoom = CaveExplorer.caves[1][1];
		CaveExplorer.currentRoom.enter();
		//5. Set up doors

		CaveRoom[][] c = CaveExplorer.caves;

		c[1][1].setConnection(WEST, c[1][0], new Door());
		
		Door locked = new Door();
		locked.setOpen(false);
		locked.setLocked(true);

		c[0][0].setConnection(SOUTH, c[1][0], new Door());
		c[1][4].setConnection(SOUTH, c[2][4], new Door());
		c[2][4].setConnection(SOUTH, c[3][4], new Door());
		c[3][4].setConnection(SOUTH, c[4][4], new Door());
		c[0][0].setConnection(EAST, c[0][1], new Door());
		c[0][1].setConnection(EAST, c[0][2], new Door());
		c[0][2].setConnection(SOUTH, c[1][2], new Door());
		c[1][2].setConnection(EAST, c[1][3], new Door());
		c[1][3].setConnection(EAST, c[1][4], new Door());
	}

 
	public String getDescription() {
		return description + "\n" + directions;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}


	public Door getDoor(int direction) {
		if(direction >= 0 && direction < doors.length) {
			return doors[direction];
		}
		else {
			return null;
		}
	}
}
