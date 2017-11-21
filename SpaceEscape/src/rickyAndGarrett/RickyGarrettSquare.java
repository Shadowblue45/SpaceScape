package rickyAndGarrett;

public class RickyGarrettSquare {

	private boolean revealed;
	private int numberOfBombsCloseby;
	private boolean isBomb;
	private int row;
	private int col;
	
	public RickyGarrettSquare(int row, int col) {
		revealed = false;
		numberOfBombsCloseby = 0;
		isBomb = false;
		this.row = row;
		this.col = col;
	}
	
	public boolean isRevealed() {
		return revealed;
	}

	public void setRevealed(boolean revealed) {
		this.revealed = revealed;
	}

	public int getNumberOfBombsCloseby() {
		return numberOfBombsCloseby;
	}

	public void setNumberOfBombsCloseby(int numberOfBombsCloseby) {
		this.numberOfBombsCloseby = numberOfBombsCloseby;
	}

	public boolean isBomb() {
		return isBomb;
	}

	public void setBomb(boolean isBomb) {
		this.isBomb = isBomb;
	}
	
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
}
