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
	public static String endIntX ="";
	public static String endIntY="";
	public static String startIntX="";
	public static String startIntY="";
	public static int incompleteLine =0;
	static boolean checkWin = false;
	public static String[][] board = new String[3][3];
	public static void main(String[] args) {
		
		for(int x = 0; x<board.length; x++) {
			for(int y =0; y<board[x].length;y++) {
				board[x][y]= " .";
			}
		}
		//while(!checkWin) {
		//String input = in.nextLine();
		print(board);
		System.out.println(startIntX+" "+startIntY+" "+endIntY+" "+endIntY);
		//}
	}
	
	private static void print(String[][] board) {
		String currentLine = "";
		makeGoal((int)(Math.random()*2+1));
		//board[0][0]=" a";
		for(int y =board.length-1; y>-1;y--) {
			for(int x =0; x<board[y].length;x++) {
				currentLine += board[x][y];	
			}
			currentLine += "\n";
		}
		System.out.println(currentLine);
	}
	private static void makeGoal(int lines) {
		
		int endY = (int)(Math.random()*board.length);
		int endX = (int)(Math.random()*board.length);
		 
		int startY = (int)(Math.random()*board.length);
		int startX = (int)(Math.random()*board.length);
		
		//fix these while loops so that they make sure that code isnt printed over
		while(startY==endY && startX==endX && board[startX][startY].equals(" .")==true) {
			startY = (int)(Math.random()*board.length);
			startX = (int)(Math.random()*board.length);
		}
		while(startY==endY && startX==endX && board[endX][endY].equals(" .")==true) {
			endY = (int)(Math.random()*board.length);
			endX = (int)(Math.random()*board.length);
		}
		
		endIntY += endY;
		endIntX += endX;
		startIntX += startX;
		startIntY += startY;
		
		
		
		board[endX][endY] = "e"+incompleteLine+" ";
		board[startX][startY] = "s"+incompleteLine+" ";
		incompleteLine++;
		if(lines>0) makeGoal(lines-1);
	}
	
}