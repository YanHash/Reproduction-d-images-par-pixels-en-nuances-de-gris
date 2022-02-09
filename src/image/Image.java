package image;
import image.color.*;
import static java.lang.Math.abs;

public class Image implements ImageInterface
{
	private Pixel[][] pixels;



	/** Builds Image objects
	* @param w the width of an image 
	* @param h the height of an image
	*/
	public Image(int w, int h)
	{
		this.pixels = new Pixel[w][h];
		
		for (int i = 0; i < w; i++)
			for (int j = 0; j < h; j++)
				this.pixels[i][j] = new Pixel(GrayColor.WHITE);
		
	}


	/** Sets the color of a Pixel object situated in (x,y)
	* @param x horizontal coordinate
	* @param y vertical coordinate
	* @param color the new color of the Pixel
	* @exception UnknownPixelException if coord (x,y) is not valid for this image
	*/
	public void changeColorPixel(int x, int y, GrayColor color) throws UnknownPixelException
	{
		if ((x >= this.getWidth()) || (x < 0) || (y >= this.getHeight()) || (y < 0) ) throw new UnknownPixelException();
		this.pixels[x][y].setColor(color);
	}


	/** Fills in an Image a rectangle of a defined width and height with a defined color 
	* @param x the leftmost pixels row which will be colored
	* @param y the highest pixels row which will be colored
	* @param width the width of the rectangle
	* @param height the height of the rectangle
	* @param color the color of the rectangle 
	*/
	public void fillRectangle(int x, int y, int width, int height, GrayColor color)
	{	
		for (int w = x; w < width+x; w++)
			for (int h = y; h < height+y; h++)
				this.pixels[w][h].setColor(color);
	}
	
	
	/** Return the Pixel at coordinates (x, y)
	* @param x horizontal coordinate
	* @param y vertical coordinate
	* @return the Pixel at position (x, y)
	* @exception UnknownPixelException if coord (x,y) is not valid for this image
	*/
	public Pixel getPixel(int x, int y) throws UnknownPixelException
	{
		if ((x >= this.getWidth()) || (x < 0) || (y >= this.getHeight()) || (y < 0) ) throw new UnknownPixelException();
		return this.pixels[x][y];
	}
	

	/** Returns the width of an Image object
	* @return the width of an Image
	*/
	public int getWidth()
	{
		return this.pixels.length;
	}


	/** Returns the height of an Image object
	* @return the height of an Image
	*/
	public int getHeight()
	{
		return this.pixels[0].length;
	}


	/** Creates a new Image from the outlines contained in an Image
	* @param threshold a threshold to separate common Pixels from outline Pixels
	* @return the new Image 
	*/
	public Image edges(int threshold)
	{
		Image image = new Image(this.getWidth(), this.getHeight());
		for (int w = 0; w < this.getWidth()-1; w++)
			for (int h = 0; h < this.getHeight()-1; h++)
			{	
				int diff = this.pixels[w][h].getColor().getGrayLevel() - this.pixels[w+1][h+1].getColor().getGrayLevel();
				
				if (Math.abs(diff) > threshold)
					image.getPixel(w, h).setColor(GrayColor.BLACK);
			}		
		return image;
	}

	/** creates a new Image with a limited number of gray levels
	* @param nbGrayLevels the number of gray levels
	* @return the new Image
	*/
	public Image decreaseNbGrayLevels(int nbGrayLevels)
	{
		Image image = new Image(this.getWidth(), this.getHeight());
		int t = 256 / nbGrayLevels;

		for (int w = 0; w < this.getWidth(); w++)
			for (int h = 0; h < this.getHeight(); h++)
			{
				int k = this.getPixel(w, h).getColor().getGrayLevel() / t;
				GrayColor k_level = new GrayColor(k);
				image.getPixel(w, h).setColor(k_level);
			}
		return image;
	}


	/** Returns the dimensions of an Image in a string 
	* @return a string 
	*/
	public String toString()
	{
		return "An Image of width:  " + this.getWidth() + " and height: " + this.getHeight();
	}


	/** verifies if two objects are equivalent
	* @param o an object
	* @return true if the two objects are equivalent, otherwise false
	*/
	public boolean equals(Object o)
	{
		if (o instanceof Image)
		{
			int cpt = 0;
			Image other = (Image) o;
			if (this.getHeight() == other.getHeight() && this.getWidth() == other.getWidth()) 
			{
			 	for (int w = 0; w < this.getWidth(); w++)
					for (int h = 0; h < this.getHeight(); h++)
						while(this.pixels[w][h].equals(other.pixels[w][h]))
							cpt++;
			} 
			return cpt == this.getWidth() * this.getHeight();
		}
		else
			return false;
	}
	
}