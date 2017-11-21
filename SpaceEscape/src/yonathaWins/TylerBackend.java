package yonathaWins;

import java.util.Optional;
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
	  public static List<Character> IMMOVABLE_POINTS() {
	        List<Character> chars = Stream.of(Direction.values()).map(Direction::toChar).collect(Collectors.toList());
	        chars.add('s');
	        return chars;
	    }
	
    public TylerBackend[] getAvaliablePoints(TylerYonathanPlot[][] plot) {
        return Stream.of(possibleDirections(plot)).map((d) -> getPoint(plot, d)).toArray(TylerBackend[]::new);
    }
    private Object possibleDirections(TylerYonathanPlot[][] plot) {
		// TODO Auto-generated method stub
		return Stream.of(TylerBackend.values()).filter((d) -> !isBlocked(plot, d)).toArray(TylerBackend[]::new);;
	}

	private boolean isBlocked(TylerYonathanPlot[][] plot, Object dir) {
		 final Optional<TylerYonathanPlot> point = getPoint(plot, dir);
	        return !point.isPresent() || isMovable(point.get());
	}

	public Optional<TylerYonathanPlot> getPoint(TylerYonathanPlot[][] plot, TylerDirections dir) {
		if (dir == dir.UP) {
			return accessPoint(plot, x - 1, y);
		}
		if(dir == dir.DOWN) {
			return accessPoint(plot, x + 1, y);
		}
		if(dir == dir.LEFT) {
			return accessPoint(plot, x, y - 1);
		}
		if(dir == dir.RIGHT)	{
			return accessPoint(plot, x, y + 1);
		}
		return Optional.empty();
	}
	
	private Optional<TylerYonathanPlot> accessPoint(TylerYonathanPlot[][] plot, int x, int y) {
		if(x < plot.length || x >= 0 ||  y < plot.length || y >= 0 )
			return Optional.of(plot[x][y]);
		return 	Optional.empty();	
	}

	private static Object values() {
		// TODO Auto-generated method stub
		return null; 
	}
    private boolean isMovable(TylerYonathanPlot point) {
        return (TylerYonathanPlot.getIdentifier().isPresent() && Game.IMMOVABLE_POINTS().contains(point.getIdentifier().get())) && point.getIdentifier().isPresent();
    }
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass().isAssignableFrom(getClass())) return false;
        TylerBackend cursor = (TylerBackend) o;
        return x == cursor.x &&
                y == cursor.y;
    }





}
