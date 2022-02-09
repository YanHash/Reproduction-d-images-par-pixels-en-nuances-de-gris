package image;
import static java.lang.Math.abs;
import image.color.*;

public class Pixel
{
	private GrayColor color;


	/** Builds Pixel objects
	* @param c a GrayColor object
	*/
	public Pixel(GrayColor c)
	{
		this.color = c;
	}



	/** Sets a new color
	* @param c a GrayColor object
	*/
	public void setColor(GrayColor c)
	{
		this.color = c;
	}


	/** Returns the color
	* @return a GrayColor object
	*/
	public GrayColor getColor()
	{
		return this.color;
	}



	/** Verifies if two objects are equivalent
	* @param o an object
	* @return true if the two objects are equivalents, otherwise false
	*/
	public boolean equals(Object o)
	{
		if (o instanceof Pixel)
		{
			Pixel other = (Pixel) o;
			return this.getColor().equals(other.getColor());
		}
		else
			return false;
	}	


	/** Returns the difference between the gray level of two Pixel objects
	* @param p a Pixel object
	* @return the diffrence between two gray levels
	*/
	public int colorLevelDifference(Pixel p)
	{
		return Math.abs(this.color.getGrayLevel() - p.color.getGrayLevel());
	}
}