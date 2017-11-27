package yonathaWins;

import java.util.Scanner;


public class NewTylerBackEnd {
	public static Scanner in = new Scanner(System.in);
	private static boolean valid = false;
	static int currentY;
	static int  currentX;
	static int[] segX = new int[3];
	static int[] segY = new int[3];

	
	public NewTylerBackEnd() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static String validMove(String input) {
		while(!ifValid(input)) {
		System.out.println("please enter a for left, s for down, d for right or w for down, e to change lines");
		input = in.nextLine();
		}
		
		return input;
	}
	public static void move(String input) {

		if(input.equals("w")) {
			currentY++;

		}
		if(input.equals("a")) {
			currentX--;
				
		}
		if(input.equals("s")) {
			currentY--;
		}
		if(input.equals("d")) {
			currentX++;
		}
	}

	public static int setOrientation() {
	    if(segX[1]>segX[0])        {
	        if(segX[2]>segX[1])
	        return 0;//straight line 
	        if(segY[2]>segY[1])
	        return 1;//corner up from left
	        if(segY[2]<segY[1])
	        return 1;//corner down from left 
	    }

	    else if(segX[1]<segX[0]) {
	        if(segX[2]-segX[1]<0)
	        return 0;//straight line
	        if(segY[2]-segY[1]>0)
	        return 3;//corner up from right
	        if(segY[2]-segY[1]<0)
	        return 3;//corner down from right
	    }

	    else if(segY[1]<segY[0])        {
	        if(segX[2]<segX[1])
	        return 1;//corner down from right
	        if(segX[2]>segX[1])
	        return 3;//corner down from left
	        if(segY[2]<segY[1])
	        return 5;//vertical line
	    }
	    else if(segY[1]>segY[0]) {
	        if(segX[2]<segX[1])
	        return 1;//corner up from right
	        if(segX[2]>segX[1])
	        return 3;//corner up from left
	        if(segY[2]>segY[1])
	        return 5;//vertical line
	    }
		return 0;

	        }
	public static boolean ifValid(String input) {
		String endValue = "e"+newYonathanFrontEnd.identifier+" ";
		String startValue = "s"+newYonathanFrontEnd.identifier+" ";
		if(input.length() != 1 && input.equals("jeff") == false) {
			return false;
		}
		if(input.equals("w")) {
			if(currentY == newYonathanFrontEnd.board.length-1)
			{
				return false;
			}else if(newYonathanFrontEnd.filler.equals( newYonathanFrontEnd.board[currentX][currentY+1]) || endValue.equals( newYonathanFrontEnd.board[currentX][currentY+1]) || startValue.equals( newYonathanFrontEnd.board[currentX][currentY+1]) )
				{
				return true;
				}
				
			
		}
		if(input.equals("a")) {
			if(currentX == 0)
			{
				return false;
			}else if(newYonathanFrontEnd.filler.equals(newYonathanFrontEnd.board[currentX-1][currentY])|| endValue.equals( newYonathanFrontEnd.board[currentX-1][currentY])|| startValue.equals( newYonathanFrontEnd.board[currentX-1][currentY]) )
			{
				return true;
			}		
			
		}
		if(input.equals("s")) {
			if(currentY == 0)
			{
				return false;
			}else if(newYonathanFrontEnd.filler.equals( newYonathanFrontEnd.board[currentX][currentY-1])|| endValue.equals(newYonathanFrontEnd.board[currentX][currentY-1])|| startValue.equals(newYonathanFrontEnd.board[currentX][currentY-1]) )
			{
				return true;
			}			
			
		}
		if(input.equals("d")) {
			if(currentX==newYonathanFrontEnd.board.length-1)
			{
				return false;
			}else if(newYonathanFrontEnd.filler.equals(newYonathanFrontEnd.board[currentX+1][currentY])|| endValue.equals(newYonathanFrontEnd.board[currentX+1][currentY])|| startValue.equals(newYonathanFrontEnd.board[currentX+1][currentY]) )
			{
				return true;
			}	
			
		}
		if(input.equals("e"))
		{
			//newYonathanFrontEnd.toggle(input);
			return true;
		}
		return false;
	}
	
}
