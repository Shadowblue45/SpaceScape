package yonathaWins;

import java.util.Optional;

public class TylerYonathanPlot extends YonathanFrontEnd {

    private Optional<YonathanFrontEnd> originDirection;
    private Optional<Character> identifier;
    
	public TylerYonathanPlot(int x, int y, Optional<YonathanFrontEnd> originDirection, Optional<Character> identifier) {
		super(x, y);
        this.originDirection = originDirection;
        this.identifier = identifier;
	}
	 
    public int getX() {
        return super.x;
    }

    public int getY() {
        return super.y;
    }
    public Optional<YonathanFrontEnd> getOriginDirection() {
        return originDirection;
    }

    public Optional<Character> getIdentifier() {
        return identifier;
    }

	public static void main(String[] args) {
		

	}

    public void setIdentifier(Optional<Character> identifier) {
        this.identifier = identifier;
    }

}
