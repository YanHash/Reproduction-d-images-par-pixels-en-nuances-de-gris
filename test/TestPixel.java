import org.junit.*;
import static org.junit.Assert.*;
import image.*;
import image.color.*;


public class TestPixel
{
	@Test 
	public void testSetColor()
	{
		GrayColor c = new GrayColor(180);
		Pixel p = new Pixel(GrayColor.BLACK);

		assertEquals(GrayColor.BLACK, p.getColor());

		p.setColor(c);

		assertEquals(c, p.getColor());
	}

	@Test
	public void testGetColor()
	{
		GrayColor c = new GrayColor(180);
		Pixel p = new Pixel(c);

		assertEquals(c, p.getColor());
		assertNotNull(p.getColor());
	}


	@Test
	public void testEquals()
	{
		GrayColor c = new GrayColor(180);

		Pixel p = new Pixel(GrayColor.BLACK);
		Pixel p1 = new Pixel(c);

		assertFalse(p.equals(p1));

		p.setColor(c);

		assertTrue(p.equals(p1));
	}


	@Test
	public void testColorLevelDifference()
	{
		GrayColor c = new GrayColor(180);
		GrayColor c1 = new GrayColor(180);
		GrayColor c2 = new GrayColor(80);

		Pixel p = new Pixel(c);
		Pixel p1 = new Pixel(c1);
		Pixel p2 = new Pixel(c2);
		Pixel pB = new Pixel(GrayColor.BLACK);

		assertTrue(p.colorLevelDifference(p1) == 0);
		assertTrue(p.colorLevelDifference(p2) == 100);
		assertTrue(p2.colorLevelDifference(p) == 100);
		assertFalse(pB.colorLevelDifference(p) == 100);
		assertTrue(p.colorLevelDifference(p2) == 180);
	}

	public static junit.framework.Test suite() 
	{
		return new junit.framework.JUnit4TestAdapter(TestImage.class);
    }
}