package rickyAndGarrett;

public class GarrettBackEnd implements RickySupport{
	
	private GarrettSupport frontend;
	private RickyGarrettSquare[][] squares;
	private boolean victorious = false;
	
	private static int numberOfBombs;
	private boolean isPlaying;
	
	public GarrettBackEnd(GarrettSupport frontend){
		 this.frontend = frontend;
		 squares = new RickyGarrettSquare[6][6];
		 numberOfBombs = 5;
		 isPlaying = false;
		 createBoard();
	}
	
	public void createBoard() {
		for(int row = 0; row < squares.length; row++){
			for(int col = 0; col < squares[row].length; col++){
				squares[row][col] = new RickyGarrettSquare(row, col);
			}
		}
		randomizeBombs();
		for(int row = 0; row < squares.length; row++){
			for(int col = 0; col < squares[row].length; col++){
				calculateNumberOfBombs(squares[row][col]);
			}
		}
	}

	public void randomizeBombs() {
		int count = 0;
		while(count < numberOfBombs){
			int minesweeperRow = (int)(Math.random() * squares.length);
			int minesweeperCol = (int)(Math.random() * squares[minesweeperRow].length);
			if(!squares[minesweeperRow][minesweeperCol].isBomb()) {
				squares[minesweeperRow][minesweeperCol].setBomb(true);
				count++;
			}
		}
	}

	public RickyGarrettSquare[][] getSquares() {
		return squares;
	}

	@Override
	public boolean stillPlaying() {
		return isPlaying;
	}

	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	
	public String getValidUserInput(String input) {
		while(!validInput(input)) {
			System.out.println("Please type in this format: y,x and use numbers 0-5");
			input = RickyFrontEnd.in.nextLine();
		}
		return input;
	}
	
	public boolean validInput(String input) {
		if(input.equals("")) {
			return false;
		}
		if(input.toLowerCase().equals("surfingmouse")) {
			return true;
		}
		if(input.substring(1, 2).equals(",") && input.length() == 3) {
			if((input.substring(0, 1).compareTo("5") <= 0 && input.substring(0, 1).compareTo("0") >= 0) &&
					(input.substring(2, 3).compareTo("5") <= 0 && input.substring(2, 3).compareTo("0") >= 0)) {
				return true;
			}
		}
		return false;
	}
	
	public void calculateNumberOfBombs(RickyGarrettSquare square) {
		int row = square.getRow();
		int col = square.getCol();
		int count = 0;
		if(!square.isBomb()) {
			count += countBombsInThisLine(squares, row, col);
			if(row > 0) {
				count += countBombsInALine(squares, row - 1, col);
			}
			if(row < squares.length - 1) {
				count += countBombsInALine(squares, row + 1, col);
			}
		}
		square.setNumberOfBombsCloseby(count);
	}

	public int countBombsInThisLine(RickyGarrettSquare[][] squares, int row, int col) {
		int count = 0;
		if(row >= 0 && row < squares.length) {
			if(col > 0) {
				if(squares[row][col - 1].isBomb()) {
					count++;
				}
			}
			if(col < squares[row].length - 1) {
				if(squares[row][col + 1].isBomb()) {
					count++;
				}
			}
		}
		return count;
	}

	public int countBombsInALine(RickyGarrettSquare[][] squares, int row, int col) {
		int count = 0;
		if(row >= 0 && row < squares.length) {
			if(squares[row][col].isBomb()) {
				count++;
			}
			if(col > 0) {
				if(squares[row][col - 1].isBomb()) {
					count++;
				}
			}
			if(col < squares[row].length - 1) {
				if(squares[row][col + 1].isBomb()) {
					count++;
				}
			}
		}
		return count;
	}

	public boolean isVictorious() {
		return victorious;
	}

	public void setVictorious(boolean victorious) {
		this.victorious = victorious;
	}

	public boolean checkVictorious() {
		for(int row = 0; row < squares.length; row++){
			for(int col = 0; col < squares[row].length; col++){
				if(squares[row][col].isBomb()) {
					if(squares[row][col].isRevealed()) {
						return false;
					}
				}
				else if(!squares[row][col].isRevealed()) {
					return false;
				}
			}
		}
		return true;
	}

}