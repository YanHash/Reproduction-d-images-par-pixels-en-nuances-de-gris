package image.color;

public class GrayColor
{
	public static final GrayColor WHITE = new GrayColor(255);
	public static final GrayColor BLACK = new GrayColor(0);
	private int grayLevel;
	private double alpha;


	/** GrayColor objects constructor 
	* @param lvl a level of gray 
	* @exception IllegalArgumentException if lvl < 0 or lvl > 255
	*/
	public GrayColor(int lvl) throws IllegalArgumentException
	{
		if ((lvl < 0) || (lvl > 255)) throw new IllegalArgumentException();
		this.grayLevel = lvl;
		this.alpha = 1;
	}


	/** Returns the gray level value
	* @return the gray level value
	*/
	public int getGrayLevel()
	{
		return this.grayLevel;
	}


	/** Returns the value of the opacity alpha
	* @return the value of alpha
	*/
	public double getAlpha()
	{
		return this.alpha;
	}


	/** Sets the opacity alpha
	* @param a the new value of alpha
	* @exception IllegalArgumentException if a > 1 or a < 0
	*/
	public void setAlpha(double a) throws IllegalArgumentException
	{
		if ((a > 1) || (a < 0)) throw new IllegalArgumentException();
		this.alpha = a;
	}


	/** Verifies if two objects are equivalent
	* @param o an object
	* @return true if the two objects are equivalents, otherwise false
	*/
	public boolean equals(Object o)
	{
		try
		{
			GrayColor that = (GrayColor) o;
			return (this.grayLevel == that.grayLevel) && (this.alpha == that.alpha);
		}
		catch(ClassCastException e)
		{
			return false;
		}
	}

	/** Returns a GrayColor object in a string form
	* @return a GrayColor object in a string form
	*/
	public String toString()
	{
		return "its gray level is " + this.grayLevel + " and has an opacity of " + this.alpha;
	}
}