package yonathaWins;

import java.util.Scanner; 
import java.util.in;

public class NewTylerBackEnd {

	private boolean valid = false;
	
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
		if(input.equals("a")) {
			if()
		}
		if(input.equals("w")) {
			
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
		if(input.equals("w") || input.equals("a") || input.equals("s") || input.equals("d") ) {
			return true;
		}
		return false;
	}
	
}
