package rickyAndGarrett;

import java.util.Scanner;

public class RickyFrontEnd implements GarrettSupport{
	
	private RickySupport backend;
	public static Scanner in;
	
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
		    String input = backend.getValidUserInput();
		    respondToInput(input);
		  }
			displayBoard(backend.getSquares());
		    printGameOverMessage(backend.victorious());
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

	public void respondToInput(String input) {
		RickyGarrettSquare[][] squares = backend.getSquares();
		int row = Integer.parseInt(input.substring(0, 1));
		int col = Integer.parseInt(input.substring(2, 3));
		if(!squares[row][col].isRevealed()){
			if(squares[row][col].isBomb()) {
				squares[row][col].setRevealed(true);
				backend.setPlaying(false);
			}
			else if(squares[row][col].getNumberOfBombsCloseby() != 0){
				squares[row][col].setRevealed(true);
			}
			else{
				autoReveal(squares[row][col]);
			}
		}
		else{
			System.out.println("This square has already been revealed.");
		}
	}
	
	public void displayBoard(RickyGarrettSquare[][] squares){
		String columns = "  0123456789";
		for(int row = 0; row < squares.length; row++) {
			System.out.print(row + " ");
			for(int col = 0; col < squares[row].length;col++) {
				if(squares[row][col].isRevealed()) {
					if(squares[row][col].isBomb()) {
						System.out.print("B");
					}else if(squares[row][col].getNumberOfBombsCloseby() != 0) {
						System.out.print(squares[row][col].getNumberOfBombsCloseby());
					}
					else {
						System.out.print(" ");
					}
				}
				else {
					System.out.print(".");
				}
			}
			System.out.println(" " + row);
		}
		System.out.println(columns.substring(0, squares[0].length+2));
	}

	public RickyFrontEnd(){
		 backend = new GarrettBackEnd(this);
		 in = new Scanner(System.in);
	}
}