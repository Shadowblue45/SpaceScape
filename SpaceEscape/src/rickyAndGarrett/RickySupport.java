package rickyAndGarrett;

public interface RickySupport {

	boolean stillPlaying();

	String getValidUserInput(String input);

	boolean checkVictorious();

	RickyGarrettSquare[][] getSquares();

	void setPlaying(boolean b);

	void setVictorious(boolean b);

	boolean isVictorious();


}