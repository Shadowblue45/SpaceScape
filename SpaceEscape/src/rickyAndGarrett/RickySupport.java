package rickyAndGarrett;

public interface RickySupport {

	boolean stillPlaying();

	String getValidUserInput(String input);

	boolean victorious();

	RickyGarrettSquare[][] getSquares();

	void setPlaying(boolean b);


}