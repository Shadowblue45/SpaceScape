package yonathaWins;

import java.util.Scanner; 
import java.util.in;

public class NewTylerBackEnd {

	private boolean valid = false;
	String currentY;
	String currentX;
	
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
			

		}
		if(input.equals("a")) {
			
				
		}
		if(input.equals("s")) {
			
		}
		if(input.equals("d")) {
			
		}
	}

	public boolean ifValid(String input) {
		if(input.length() != 1 && input.equals("jeff") == false) {
			return false;
		}
		if(input.equals("w")) {
			if(currentY.equals("4"))
			{
				return false;
			}				
			return true;
		}
		if(input.equals("a")) {
			if(currentX.equals("4"))
			{
				return false;
			}				
			return true;
		}
		if(input.equals("s")) {
			if(currentY.equals("0"))
			{
				return false;
			}				
			return true;
		}
		if(input.equals("d")) {
			if(currentX.equals("0"))
			{
				return false;
			}				
			return true;
		}
		
		return false;
	}
	
}
