package yonathaWins;

import java.util.stream.Stream;

public class TylerBackend implements YonathanSupport {

	//go to yonathan backend, make 2d array, define proportions
	//
	public boolean isPlaying;
	private TylerSupport frontend;
	private int lines;
	private int turns;
	private int x;
	private int y;
	private int indexOcc = 0;
	String cheat = "jeff";
	private Object[] occupiedSeg;
	private String orientation = "0123";
	String validKeys = "wasde";
	
	
	public TylerBackend(TylerSupport frontend) {
		this.frontend = frontend;
		lines = 3;
		turns = 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	private int checkConnections() {
	return 0;	
		
	}
	
    public TylerBackend[] getAvaliablePoints(TylerYonathanPlot[][] plot) {
        return Stream.of(possibleDirections(plot)).map((d) -> getPoint(plot, d)).toArray(TylerBackend[]::new);
    }
    private Object possibleDirections(TylerYonathanPlot[][] plot) {
		// TODO Auto-generated method stub
		return Stream.of(TylerBackend.values()).filter((d) -> !isBlocked(plot, d)).toArray(TylerBackend[]::new);;
	}

	private boolean isBlocked(TylerYonathanPlot[][] plot, Object d) {
		// TODO Auto-generated method stub
		return false;
	}

	private static Object values() {
		// TODO Auto-generated method stub
		return null; 
	}

	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass().isAssignableFrom(getClass())) return false;
        TylerBackend cursor = (TylerBackend) o;
        return x == cursor.x &&
                y == cursor.y;
    }
	@Override
	public int getValidUserInput(String imp ) {
		// TODO Auto-generated method stub
		if(validKeys.indexOf(imp)!= -1) {
		
		return validKeys.indexOf(imp);}
		
		return -1;
	}

	@Override
	public boolean isPlaying() {
	
	}

	@Override
	public String getValidUserInput() {
		// TODO Auto-generated method stub
		return null;
	}

}
