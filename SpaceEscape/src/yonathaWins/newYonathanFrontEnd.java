package yonathaWins;
//new front end based version 
/*the code does five things 
 * 1. allow user to input commands (this one is back end)
 * 2. check if commands are valid (back end checks if the stop in the array is a space)
 * 3. display something to user (stop making flow all your realy doing is displaying flow not actualy making it)
 * 4. check if user won (when the two points are made start and end the end is saved unto two variables endIntX endIntY)
 * 5. stop running code 
 */
public class newYonathanFrontEnd implements TylerSupport {
	private int endIntX;
	private int endInty;
	private int startIntX;
	private int startInty;
	public static void main(String[] args) {
		String[][] board = new String[5][5];
		for(int x = 0; x<board.length; x++) {
			for(int y =0; y<board[x].length;y++) {
				board[x][y]= "b";
			}
		}
		print(board);
	}
	
	private static void print(String[][] board) {
		String currentLine = "";
		board[2][3] = "a";
		endIntX = (int)(Math.random)
		for(int y =4; y>-1;y--) {
			for(int x =0; x<board[y].length;x++) {
				currentLine += board[x][y];	
			}
			currentLine += "\n";
		}
		System.out.println(currentLine);
	}
	
}