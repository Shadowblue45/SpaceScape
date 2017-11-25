package yonathaWins;
//new front end based version 
/*the code does five things 
 * 1. allow user to input commands (this one is back end)
 * 2. check if commands are valid (back end checks if the stop in the array is a space)
 * 3. display something to user (stop making flow all your realy doing is displaying flow not actualy making it)
 * 4. check if user won (when the two points are made start and end the end is saved unto two variables endIntX endIntY)
 * 5. stop running code 
 * when code start define each segX and segY equal to -1
 * ask tyler to change isvalid to return the string that was inputed
 */
public class newYonathanFrontEnd implements TylerSupport {
	public static String endIntX ="";
	public static String endIntY="";
	public static String startIntX="";
	public static String startIntY="";
	public static int incompleteLine =0;
	static int identifier=0;
	
	public static String orientation[]= {	"___\n|"+identifier+" \n|  " ,
			"___\n "+identifier+"|\n ___",
			"___\n "+identifier+" \n___" ,
			"| |\n|"+identifier+"|\n| |",
			"|  \n|"+identifier+" \n___",
			"  |\n "+identifier+"|\n___"
	};

	public static String filler=" .";
	static boolean checkWin = false;
	public static String[][] board = new String[3][3];
	public static void main(String[] args) {
		for(int x = 0; x<board.length; x++) {
			for(int y =0; y<board[x].length;y++) {
				board[x][y]= filler;
			}
		}
		for(int i=0;i<3;i++) {
			NewTylerBackEnd.segX[i]=-1;
			NewTylerBackEnd.segY[i]=-1;
		}
		makeGoal((int)(Math.random()*2+1));
		NewTylerBackEnd.currentX=Integer.parseInt(startIntX.substring(identifier,identifier+1));
		NewTylerBackEnd.currentY=Integer.parseInt(startIntY.substring(identifier,identifier+1));
		
		while(incompleteLine<10) {
			
		print(board);
		System.out.println(startIntX+" "+startIntY+" "+endIntY+" "+endIntY);
		
		
		String input = NewTylerBackEnd.in.nextLine();
		if(input.equals("jeff")) {
			break;
		}
		String userInput = NewTylerBackEnd.validMove(input);
		makeChange(userInput);
		
		//identifier();
		//System.out.println(identifier);
		
		incompleteLine++;
		}
		System.out.println("a");
	}
	
	private static void makeChange(String input) {
		
		if(!input.equals("e")) {
			NewTylerBackEnd.move(input);
			if(NewTylerBackEnd.currentX!=Integer.parseInt(endIntX.substring(identifier,identifier+1)) || NewTylerBackEnd.currentY!=Integer.parseInt(endIntY.substring(identifier,identifier+1))) {
				setUpOrientation();
			}else {
				
			}
		}else {
			
		}
		
	}

	private static void setUpOrientation() {
		//checks if segx[] and y are  set up and if you can use set orientation then uses it
		
	}

	private static int identifier() {
		identifier++;
		if(identifier>startIntX.length()-1) {
			identifier=0;
		}
		return identifier;
	}

	private static void print(String[][] board) {
		String currentLine = "";
		
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
		while(startY==endY && startX==endX || board[startX][startY].equals(filler)!=true) {
			startY = (int)(Math.random()*board.length);
			startX = (int)(Math.random()*board.length);
		}
		while(startY==endY && startX==endX || board[endX][endY].equals(filler)!=true) {
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