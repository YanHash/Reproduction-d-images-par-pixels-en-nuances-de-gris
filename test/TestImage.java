import org.junit.*;
import static org.junit.Assert.*;
import image.*;
import image.color.*;

public class TestImage
{

	@Test 
	public void testChangeColorPixel()
	{
		Image im = new Image(10, 15);
		assertEquals(GrayColor.WHITE, im.getPixel(0, 0).getColor());
		
		im.changeColorPixel(0, 0, GrayColor.BLACK);
		assertEquals(GrayColor.BLACK, im.getPixel(0, 0).getColor());
	}
	
	
	@Test
	public void testFillRectangle()
	{
		Image im = new Image(10, 15);
		assertEquals(GrayColor.WHITE, im.getPixel(0, 0).getColor());
		assertEquals(GrayColor.WHITE, im.getPixel(3, 3).getColor());
		assertEquals(GrayColor.WHITE, im.getPixel(5, 6).getColor());
		
		im.fillRectangle(2, 2, 4, 8, GrayColor.BLACK);
		assertEquals(GrayColor.WHITE, im.getPixel(0, 0).getColor());
		assertEquals(GrayColor.BLACK, im.getPixel(3, 3).getColor());
		assertEquals(GrayColor.BLACK, im.getPixel(5, 6).getColor()); 
	}
	
	
	@Test
	public void testGetWidth()
	{
		Image im = new Image(10, 15);
		assertEquals(10, im.getWidth());
		assertFalse(im.getWidth() == 15);
			
	}
	
	
	@Test
	public void testGetHeight()
	{
		Image im = new Image(10, 15);
		assertEquals(15, im.getHeight());
		assertFalse(im.getHeight() == 10);
	}
 

	@Test
	public void testEdges()
	{
		Image im = new Image(10, 15);
		Image im2 = im.edges(5);

		assertTrue(im.getHeight() == im2.getHeight());
		assertTrue(im.getWidth() == im2.getWidth());

		assertEquals(im, im2);

		im.fillRectangle(0, 0, 5, 10, GrayColor.BLACK);

		assertTrue(im.equals(im.edges(5)));
		assertTrue(im.getHeight() == im.edges(5).getHeight());
		assertTrue(im.getWidth() == im.edges(5).getWidth());
	}
	
	public static junit.framework.Test suite() 
	{
		return new junit.framework.JUnit4TestAdapter(TestImage.class);
    }
}
