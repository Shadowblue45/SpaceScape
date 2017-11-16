package rickyAndGarrett;

public class RickyFrontEnd implements GarrettSupport{
	
	private RickySupport backend;
	
	public static final void main(String[] args) {
		RickyFrontEnd demo = new RickyFrontEnd();
		demo.start();
	}

	public void start() {
		RickyGarrettSquare[][] squares = backend.getSquares();
		displayBoard(squares);
	}
	
	public void play() {
		  while(backend.stillPlaying()){
		        displayBoard(backend.getSquares());
		        String input = backend.getValidUserInput();
		        respondToInput(input);
		        autoReveal();
		  }
		        printGameOverMessage(backend.victorious());
	}

	private void printGameOverMessage(boolean victorious) {
		if(victorious) {
			System.out.println("You is win!");
		}else {
			System.out.println("You is lose!");
		}
	}

	public void autoReveal() {
		
	}

	public void respondToInput(String input) {
		RickyGarrettSquare[][] squares = backend.getSquares();
		int row = Integer.parseInt(input.substring(0, 1));
		int col = Integer.parseInt(input.substring(2, 3));
		if(squares[row][col].isBomb()) {
			squares[row][col].setRevealed(true);
		}
		else if(squares[row][col].getNumberOfBombsCloseby() != 0){
				squares[row][col] = squares[row][col].getNumberOfBombsCloseby();
		}
		else{
			autoReveal();
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
	}
}