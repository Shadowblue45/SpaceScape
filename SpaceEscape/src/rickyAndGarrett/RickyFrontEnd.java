package rickyAndGarrett;

import java.util.Scanner;

public class RickyFrontEnd implements GarrettSupport{
	
	private RickySupport backend;
	public static Scanner in = new Scanner(System.in);
	
	public static final void main(String[] args) {
		RickyFrontEnd demo = new RickyFrontEnd();
		demo.start();
	}

	public void start() {
		RickyGarrettSquare[][] squares = backend.getSquares();
		play();
	}
	
	public void play() {
		backend.setPlaying(true);
		while(backend.stillPlaying()){
			displayBoard(backend.getSquares());
			String input = in.nextLine();
		    String validInput = backend.getValidUserInput(input);
		    respondToInput(validInput);
		  }
			displayBoard(backend.getSquares());
		    printGameOverMessage(backend.isVictorious());
	}

	private void printGameOverMessage(boolean victorious) {
		if(victorious) {
			System.out.println("You is win!");
		}else {
			System.out.println("You is lose!");
		}
	}

	public void autoReveal(RickyGarrettSquare square) {
		int row = square.getRow();
		int col = square.getCol();
		revealEmptySquares(square, row, col);
		if(row > 0) {
			revealEmptySquares(backend.getSquares()[row - 1][col], row - 1, col);
		}
		if(row < backend.getSquares().length - 1) {
			revealEmptySquares(backend.getSquares()[row + 1][col], row + 1, col);
		}
	}
	
	public void revealAll(RickyGarrettSquare square) {
		autoReveal(square);
		while(!blankSquaresRevealed()) {
			for(int row = 0; row < backend.getSquares().length; row++){
				for(int col = 0; col < backend.getSquares()[row].length; col++){
					if(backend.getSquares()[row][col].getNumberOfBombsCloseby() == 0 && backend.getSquares()[row][col].isRevealed()) {
						if(!nearbySquaresRevealed(backend.getSquares()[row][col])) {
							autoReveal(backend.getSquares()[row][col]);
						}
					}
				}
			}
		}
	}

	public boolean blankSquaresRevealed() {
		for(int row = 0; row < backend.getSquares().length; row++){
			for(int col = 0; col < backend.getSquares()[row].length; col++){
				if(backend.getSquares()[row][col].getNumberOfBombsCloseby() == 0 && 
						backend.getSquares()[row][col].isRevealed()) {
					if(!nearbySquaresRevealed(backend.getSquares()[row][col])) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public boolean nearbySquaresRevealed(RickyGarrettSquare square) {
		int row = square.getRow();
		int col = square.getCol();
		if(!checkSquaresLine(backend.getSquares(), row, col)) {
			return false;
		}
		if(row > 0) {
			if(!checkSquaresLine(backend.getSquares(), row - 1, col)) {
				return false;
			}
		}
		if(row < backend.getSquares().length - 1) {
			if(!checkSquaresLine(backend.getSquares(), row + 1, col)){
				return false;
			}
		}
		return true;
	}

	public boolean checkSquaresLine(RickyGarrettSquare[][] squares, int row, int col) {
		if(!squares[row][col].isRevealed()) {
			return false;
		}
		if(col > 0) {
			if(!squares[row][col - 1].isRevealed()){
				return false;
			}
		}
		if(col < squares[row].length - 1) {
			if(!squares[row][col + 1].isRevealed()) {
				return false;
			}
		}
		return true;
	}

	public void revealEmptySquares(RickyGarrettSquare square, int row, int col) {
		square.setRevealed(true);
		if(col > 0) {
			if(!backend.getSquares()[row][col - 1].isRevealed()) {
				backend.getSquares()[row][col - 1].setRevealed(true);
			}
		}
		if(col < backend.getSquares().length - 1) {
			if(!backend.getSquares()[row][col + 1].isRevealed()) {
				backend.getSquares()[row][col + 1].setRevealed(true);
			}
		}
	}
	
	public void revealBombs(RickyGarrettSquare[][] squares) {
		for(int brow = 0; brow < backend.getSquares().length; brow++){
			for(int bcol = 0; bcol < backend.getSquares()[brow].length; bcol++){
				if(backend.getSquares()[brow][bcol].isBomb()) {
					if(!backend.getSquares()[brow][bcol].isRevealed()) {
						backend.getSquares()[brow][bcol].setRevealed(true);
					}
				}
			}
		}
	}

	public void respondToInput(String input) {
		if(input.toLowerCase().equals("surfingmouse")) {
			revealBombs(backend.getSquares());
			backend.setVictorious(true);
			backend.setPlaying(false);
		}else {
			RickyGarrettSquare[][] squares = backend.getSquares();
			int row = Integer.parseInt(input.substring(0, 1));
			int col = Integer.parseInt(input.substring(2));
			if(!squares[row][col].isRevealed()){
				if(squares[row][col].isBomb()) {
					revealBombs(backend.getSquares());
					backend.setVictorious(false);
					backend.setPlaying(false);
				}
				else if(squares[row][col].getNumberOfBombsCloseby() != 0){
					squares[row][col].setRevealed(true);
					if(backend.checkVictorious()) {
						revealBombs(backend.getSquares());
						backend.setVictorious(true);
						backend.setPlaying(false);
					}
				}
				else{
					revealAll(squares[row][col]);
					if(backend.checkVictorious()) {
						revealBombs(backend.getSquares());
						backend.setVictorious(true);
						backend.setPlaying(false);
					}
				}
			}
			else{
				System.out.println("This square has already been revealed.");
			}
		}
	}
	
	public void displayBoard(RickyGarrettSquare[][] squares){
		String columns = "  0 1 2 3 4 5 6 7 8 9";
		for(int row = 0; row < squares.length; row++) {
			System.out.print(row + " ");
			for(int col = 0; col < squares[row].length;col++) {
				if(squares[row][col].isRevealed()) {
					if(squares[row][col].isBomb()) {
						System.out.print("B ");
					}else if(squares[row][col].getNumberOfBombsCloseby() != 0) {
						System.out.print(squares[row][col].getNumberOfBombsCloseby() + " ");
					}
					else {
						System.out.print("  ");
					}
				}
				else {
					System.out.print(". ");
				}
			}
			System.out.println(" " + row);
		}
		System.out.println(columns.substring(0, 2 * squares[0].length+2));
	}

	public RickyFrontEnd(){
		 backend = new GarrettBackEnd(this);
		 in = new Scanner(System.in);
	}
}