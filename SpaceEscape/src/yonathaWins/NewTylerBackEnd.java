package yonathaWins;

import java.util.Scanner; 
import java.util.in;

public class NewTylerBackEnd {

	private boolean valid = false;
	int currentY;
	int  currentX;
	static int[] segX = new int[3];
	static int[] segY = new int[3];

	
	public NewTylerBackEnd() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String validMove(String input) {
		while(!valid) {
		System.out.println("please enter a for left, s for down, d for right or w for down");
		input = newYonathanFrontEnd.in.nextLine();
		}
		move(input);
		return input;
	}
	private void move(String input) {

		if(input.equals("w")) {
			currentY++;

		}
		if(input.equals("a")) {
			currentX++;
				
		}
		if(input.equals("s")) {
			currentY--;
		}
		if(input.equals("d")) {
			currentX--;
		}
	}

	public static int setOrientation(String input) {
	    if(segX[2]-segX[1]<0)        {
	        if(segX[1]-segX[0]<0)
	        return 0;//straight line 
	        if(segY[1]-segY[0]<0)
	        return 1;//corner up from left
	        if(segY[1]-segY[0]>0)
	        return 2;//corner down from left
	    }

	    else if(segX[2]-segX[1]>0) {
	        if(segX[1]-segX[0]>0)
	        return 0;//straight line
	        if(segY[1]-segY[0]<0)
	        return 3;//corner up from right
	        if(segY[1]-segY[0]>0)
	        return 4;//corner down from right
	    }

	    else if(segY[2]-segY[1]<0)        {
	        if(segX[1]-segX[0]<0)
	        return 4;//corner down from right
	        if(segX[1]-segX[0]>0)
	        return 2;//corner down from left
	        if(segY[1]-segY[0]<0)
	        return 5;//vertical line
	    }
	    else if(segY[2]-segY[1]>0) {
	        if(segX[1]-segX[0]<0)
	        return 3;//corner up from right
	        if(segX[1]-segX[0]>0)
	        return 1;//corner up from left
	        if(segY[1]-segY[0]>0)
	        return 5;//vertical line
	    }
		return -1;

	        }
	public boolean ifValid(String input) {
		if(input.length() != 1 && input.equals("jeff") == false) {
			return false;
		}
		if(input.equals("w")) {
			if(currentY == 4)
			{
				return false;
			}				
			return true;
		}
		if(input.equals("a")) {
			if(currentX == 4)
			{
				return false;
			}				
			return true;
		}
		if(input.equals("s")) {
			if(currentY == 0)
			{
				return false;
			}				
			return true;
		}
		if(input.equals("d")) {
			if(currentX==0)
			{
				return false;
			}				
			return true;
		}
		if(input.equals("e"))
		{
			newYonathanFrontEnd.toggle(input);
			return true;
		}
		return false;
	}
	
}
