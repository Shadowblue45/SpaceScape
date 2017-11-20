package yonathaWins;

import java.awt.Cursor;

public class YonathanFrontEnd implements TylerSupport {
	//make 2d array populate with tylerfiller
	//randomly populate with goalfiller
	//before a square is populated, check if it's already populated
	//randomly check when a thing is populate whether or not it's a starter and if it's a starter than make an end goal randomly around the map
	private String identifier;
	// ask knockles about keyboard and mouse imputs from a computer
	//match order to tylers indexs in setorientation 
	//convince ricky to do final room 
	// ask about displaying array possible problems from using caveroom to make the array
	//ask about turning off the minigame
	public String orientation[]= {"___\n|"+identifier+" \n|  ","___\n "+identifier
			};
	private TylerYonathanPlot[][] flowRoom;
	private YonathanSupport backend;
	private int linesComplete;
	private Object gamePlot;
	private Cursor cursor;
	int x;
	int y;
	
	public YonathanFrontEnd(int x, int y) {
		this.x = x;
		this.y = y;
		backend = new TylerBackend(this);
		flowRoom = new TylerYonathanPlot[3][3];
		linesComplete = 0;
 
			
	}
    private void printBoard() {
        System.out.println(replicate('_', (this.flowRoom.length * 2) + 2));
        for (final TylerYonathanPlot[] column : this.flowRoom) {
            for (int y = 0; y < column.length; y++) {
                final TylerYonathanPlot point = column[y];
                final String leftWall = y == 0 ? "|" : "";
                final String rightWall = y == column.length - 1 ? "|" : "";
                final String bottom = (this.cursor.equals(point)) ? "* " : ((Object) point.getIdentifier()).isPresent() ? String.format("%s ", point.getIdentifier().get()) : "  ";
                final String newlineCheck = y == this.flowRoom.length - 1 ? "\n" : "";
                System.out.printf(" ", leftWall, bottom, rightWall, newlineCheck);
            }
        }
        System.out.println(replicate('‾', (this.flowRoom.length * 3) + 2));
    }

	private String replicate(char ch, int times) {
        final StringBuilder xStr = new StringBuilder();
		for (int x = 0; x < times; x++) {
            xStr.append(ch);
        }
        return xStr.toString();
	}
	private Object getIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}
	private void displayFlow() {
		System.out.println("____");
		for(int row = 0; row < flowRoom.length; row++){
			System.out.println("|");
			for(int col = 0; col < flowRoom[row].length; col++){
				flowRoom[row][col] = new TylerYonathanPlot(col, col);
				}
		}
	}

	public static void main(String[] args) {
		YonathanFrontEnd demo = new YonathanFrontEnd();
		demo.play();

	}
	

	private void play() {
		//while(backend.isPlaying()) {
			  displayFlow();
		        
		        //String input = backend.getValidUserInput();
		        //respondToInput(input);
		       
		        
		   // }
		        printGameOverMessage();
		
	}

	private void printGameOverMessage() {
		System.out.println("conglaturation you win");
		
	}

	private void respondToInput(String input) {
		
		
	}
}
