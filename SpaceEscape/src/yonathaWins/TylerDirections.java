package yonathaWins;

public enum TylerDirections {
	UP, DOWN, LEFT, RIGHT;
	

    public String getRepresentation() {
        String chars = toString();
        return String.format("[%c] (%s)%s", validKeys(), Character.toUpperCase(chars.charAt(0)), chars.substring(1).toLowerCase());
    }

	   public char validKeys() {
		   	if( this == TylerDirections.UP)
		       return 'w';
		   	if(this == TylerDirections.DOWN )
			       return 's';
		   	if (this == TylerDirections.LEFT )
		       return 'a';
		   	if (this == TylerDirections.RIGHT)
			       return 'd';
		    return '?';
	   }
	    public char forBoard() {
		   	if(this == TylerDirections.UP )
			       return '^';
			   	if(this == TylerDirections.DOWN )
				       return 'v';
			   	if (this == TylerDirections.LEFT )
			       return '<';
			   	if (this == TylerDirections.RIGHT)
				       return '>';
			     return '?';
	    }

	
	

}
