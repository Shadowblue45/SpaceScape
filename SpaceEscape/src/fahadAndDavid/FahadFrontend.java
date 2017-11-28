package fahadAndDavid;

public class FahadFrontend implements DavidSupport{

	private FahadSupport backend;
	private int row;
	private int col;
	private String[][] visuals = new String[5][5];
	private String cheat = "Clap on";

	public static void main(String[] args) {
		FahadFrontend demo = new FahadFrontend();
		demo.play();
	}

	public FahadFrontend() {
		backend = new DavidBackend(this);
	}

	public void play(){
		backend.generateGame();
		while(!backend.isVictorious()){
			displayBoard(visuals);
			String input = DavidBackend.in.nextLine();
			String userInput = backend.getValidUserInput(input);
			if(input.equals(cheat.toLowerCase())) {
				break;
			}
			respondToInput(userInput);
		}
		updateWinBoard();
		displayBoard(visuals);
		printGameOverMessage();
	}

	public void updateWinBoard() {
		boolean[][] gameBoard = backend.getGameBoard();
		for(int row = 0; row < gameBoard.length;row++) {
			for(int col = 0; col < gameBoard[row].length;col++) {
				if(gameBoard[row][col] == false) {
					gameBoard[row][col] =true;
					visuals[row][col] = "+ ";
				}
			}
		}
	}

	private void displayBoard(String[][] pic) {
		String result = "";
		setBoard();
		for(int row = 0;row < pic.length;row++) {
			result+= row + " ";
			for(int col = 0;col < pic[row].length;col++){
				result += pic[row][col];
			}
			result += "\n";
		}
		result+= "  0 1 2 3 4 ";
		System.out.println(result);
	}

	public void respondToInput(String input) {
		row = Integer.parseInt(input.substring(0,1));
		col = Integer.parseInt(input.substring(2));
		setLights(row,col);
	}

	public void printGameOverMessage() {
		System.out.println("GG. You've done well");
	}

	public void setBoard() {
		boolean[][] gameBoard = backend.getGameBoard();
		for(int row = 0; row < gameBoard.length;row++) {
			for(int col = 0; col < gameBoard[row].length;col++) {
				if(gameBoard[row][col] == false) {
					visuals[row][col] = "- ";
				}
				if(gameBoard[row][col] == true) {
					visuals[row][col] = "+ ";
				}
			}
		}
		
	}

	public void setLights(int row, int col) {
		backend.toggleLights(row, col);
	}
}