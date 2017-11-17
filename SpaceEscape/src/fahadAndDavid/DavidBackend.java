package fahadAndDavid;

import java.util.Scanner;

public class DavidBackend implements FahadSupport{
	
	public boolean[][] game;
	public static Scanner in = new Scanner(System.in);
	
	public void generateGame() {
		game = new boolean[5][5];
		for(int row = 0; row < game.length; row++) {
			for(int col = 0; col < game[row].length; col++) {
				if(Math.random() < .2)
					toggleLights(row, col); 
			}
		}
	}
	
	
	public void toggleLights(int row, int col) {
		toggleSlot(row+1, col);
		toggleSlot(row-1, col);
		toggleSlot(row, col);
		toggleIfInBounds(row+1,col);
		toggleIfInBounds(row,col);
		toggleIfInBounds(row-1,col);
	}
	
	public void toggleSlot(int row, int col) {
		toggleIfInBounds(row,col-1);
		toggleIfInBounds(row,col+1);
	}
	public void toggleIfInBounds(int row, int col) {
		if(row >= 0 && row < game.length && col >= 0 && col < game[row].length) {
			game[row][col] = !game[row][col];
		}
	}
	
	public DavidBackend(DavidSupport frontend) {
		
	}

	public boolean isVictorious() {
		for(int row = 0; row < game.length; row++) {
			for(int col = 0; col < game[row].length; col++) {
				if(game[row][col] == false)
					return false;
					
			}
		}
		return true;
	}

	public String getValidUserInput(String input) {
		while(!validInput(input)) {
			System.out.println("You need to use the fomat x:y, and in between 0-4");
			input = in.nextLine();
		}
		return input;
	}

	public boolean validInput(String input) {
		if(input.length() == 3 && input.substring(1,2).equals(",")) {
			if((input.substring(0,1).compareTo("4") <= 0 && input.substring(0,1).compareTo("0") >= 0) &&
					(input.substring(2,3).compareTo("4") <= 0 && input.substring(2,3).compareTo("0") >= 0)) {
				return true;
			}
		}
		return false;
	}

	public boolean[][] getGameBoard() {
		return game;
	}

}
