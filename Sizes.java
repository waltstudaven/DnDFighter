/**
 * This enum keeps track of the sizes of characters in the game. 
 */
public enum Sizes {
	TINY(2.5, "tiny"), SMALL(5, "small"), MEDIUM(5, "medium"), LARGE(10, "large"), HUGE(15, "huge"), GARGANTUAN(20,
			"gargantuan");

	private double space;
	private String size;
	/**
	 * The constructor for Sizes
	 * @param space The space a character takes up
	 * @param size	The string size of the character.
	 */
	Sizes(double space, String size) {
		this.space = space;
		this.size = size;
	}
	/**
	 * Returns the space of the character.
	 * @return	double
	 */
	public double getSpace() {
		return space;
	}
	/**
	 * Returns the size of the character.
	 * @return	String
	 */
	public String getSize() {
		return size;
	}

}
