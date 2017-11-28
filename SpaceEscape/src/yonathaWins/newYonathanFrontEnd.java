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
	static int identifier;
	static int[][] toggleListX;
	static int[][] toggleListY;
	static int xTracker =0;
	static int yTracker =0;
	static String orientation[]= {	"-"+identifier+"-" ,
			"-"+identifier+"|",
			"-"+identifier+"|",
			"|"+identifier+"-",
			"|"+identifier+"-",
			"|"+identifier+"|"
	};

	public static String filler=" . ";
	static boolean checkWin = false;
	
	public static String[][] board = new String[6][6];
		
	
	public static void main(String[] args) {
		for(int x = 0; x<board.length; x++) {
			for(int y =0; y<board[x].length;y++) {
				board[x][y]= filler;
			}
		}
		identifier=0;
		for(int i=0;i<3;i++) {
			NewTylerBackEnd.segX[i]=-1;
			NewTylerBackEnd.segY[i]=-1;
		}
		makeGoal((int)(Math.random()*2+1));
		NewTylerBackEnd.currentX=Integer.parseInt(startIntX.substring(identifier,identifier+1));
		NewTylerBackEnd.currentY=Integer.parseInt(startIntY.substring(identifier,identifier+1));
		NewTylerBackEnd.segX[2]=Integer.parseInt(startIntX.substring(identifier,identifier+1));
		NewTylerBackEnd.segY[2]=Integer.parseInt(startIntY.substring(identifier,identifier+1));
		
		 toggleListX = new int[incompleteLine][90];
		 toggleListY = new int[incompleteLine][90];
		
		while(incompleteLine>0) {
			System.out.println(incompleteLine);
		print(board);
		System.out.println(startIntX+" "+startIntY+" "+endIntY+" "+endIntY);
		System.out.println(NewTylerBackEnd.currentX+" "+NewTylerBackEnd.currentY);
		
		String input = NewTylerBackEnd.in.nextLine();
		if(input.equals("jeff")) {
			break;
		}
		String userInput = NewTylerBackEnd.validMove(input);
		makeChange(userInput);
		if(userInput.equals("jeff")) {
			break;
		}
		//identifier();
		//System.out.println(identifier);
		
		
		}
		
		
		System.out.println("you win");
	}
	
	private static void makeChange(String input) {
		
		if(!input.equals("e")) {
			NewTylerBackEnd.move(input);
			if(NewTylerBackEnd.currentX!=Integer.parseInt(endIntX.substring(identifier,identifier+1)) || NewTylerBackEnd.currentY!=Integer.parseInt(endIntY.substring(identifier,identifier+1))) {
				setUpOrientation();
				board[NewTylerBackEnd.currentX][NewTylerBackEnd.currentY] = " "+identifier+" ";
			
			}else {
				setUpOrientation();
				incompleteLine--;
				toggle(false);
				System.out.println("line done");
				
			}
		}else {
			System.out.println("working");
			toggle(true);
		}
		
	}

	private static void toggle(boolean b) {
		if(b) {
			if(identifier+1>startIntX.length()-1) {
				if(board[toggleListX[0][0]][toggleListY[0][0]].equals(filler)!=true&&!board[toggleListX[0][0]][toggleListY[0][0]].equals("e"+incompleteLine+" ")) {incompleteLine++;}else {}
			}else if(board[toggleListX[identifier+1][0]][toggleListY[identifier+1][0]].equals(filler)!=true&&!board[toggleListX[identifier+1][0]][toggleListY[identifier+1][0]].equals("e"+incompleteLine+" ")) {incompleteLine++;}else {}
		for(int y =toggleListX[identifier].length-1; y>-1;y--) {
			if(toggleListX[identifier][y]!=Integer.parseInt(endIntX.substring(identifier,identifier+1)) || toggleListY[identifier][y]!=Integer.parseInt(endIntY.substring(identifier,identifier+1))) {
			board[toggleListX[identifier][y]][toggleListY[identifier][y]]= filler;
			}
		}
		}
		identifier();
		
		for(int y =toggleListX[identifier].length-1; y>-1;y--) {
			if(toggleListX[identifier][y]!=Integer.parseInt(endIntX.substring(identifier,identifier+1)) || toggleListY[identifier][y]!=Integer.parseInt(endIntY.substring(identifier,identifier+1))) {
			board[toggleListX[identifier][y]][toggleListY[identifier][y]]= filler;
			}
		}
		
		xTracker=0;
		yTracker=0;
		for(int i=0;i<3;i++) {
			NewTylerBackEnd.segX[i]=-1;
			NewTylerBackEnd.segY[i]=-1;
		}
		NewTylerBackEnd.currentX=Integer.parseInt(startIntX.substring(identifier,identifier+1));
		NewTylerBackEnd.currentY=Integer.parseInt(startIntY.substring(identifier,identifier+1));
		NewTylerBackEnd.segX[2]=Integer.parseInt(startIntX.substring(identifier,identifier+1));
		NewTylerBackEnd.segY[2]=Integer.parseInt(startIntY.substring(identifier,identifier+1));
		resetOrientation();
		
	}

	private static void resetOrientation() {
		orientation[0]="-"+identifier+"-" ;
		orientation[1]="-"+identifier+"|";
		orientation[2]="-"+identifier+"|";
		orientation[3]="|"+identifier+"-";
		orientation[4]="|"+identifier+"-";
		orientation[5]="|"+identifier+"|";
	}

	private static void setUpOrientation() {
		//checks if segx[] and y are  set up and if you can use set orientation then uses it
		
		NewTylerBackEnd.segX[0]=NewTylerBackEnd.segX[1];
		NewTylerBackEnd.segX[1]=NewTylerBackEnd.segX[2];
		NewTylerBackEnd.segX[2]=NewTylerBackEnd.currentX;
		toggleListX[identifier][xTracker]=NewTylerBackEnd.currentX;
		xTracker++;
		NewTylerBackEnd.segY[0]=NewTylerBackEnd.segY[1];
		NewTylerBackEnd.segY[1]=NewTylerBackEnd.segY[2];
		NewTylerBackEnd.segY[2]=NewTylerBackEnd.currentY;
		toggleListY[identifier][yTracker]=NewTylerBackEnd.currentY;
		yTracker++;
		if(NewTylerBackEnd.segX[0]==-1||NewTylerBackEnd.segY[0]==-1) {
			
		}else {
			board[NewTylerBackEnd.segX[1]][NewTylerBackEnd.segY[1]] = orientation[NewTylerBackEnd.setOrientation()];
		}
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