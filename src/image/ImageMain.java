package image;
import image.util.*;
import image.color.*;

public class ImageMain
{
	public static void main(String[] args)
	{
		ImageDisplayer displayer = new ImageDisplayer();
		Image i = new Image(200, 150);		
		GrayColor gris128 = new GrayColor(128);
		GrayColor gris200 = new GrayColor(200);


		i.fillRectangle(20, 30, 30, 50, GrayColor.BLACK);
		i.fillRectangle(50, 100, 40, 40, gris128);
		i.fillRectangle(90, 20, 70, 50, gris200);
        displayer.display(i, "image I", 100, 400);


        String folder = "/images/";
        Image image = ImageLoader.loadPGM(folder+args[0]);
        //displayer.display(image, args[0], 100, 100);
        //displayer.display(image.edges(20), args[0]+" edges", 500, 100);

        displayer.display(image, args[0], 100, 100);
        displayer.display(image.edges(Integer.parseInt(args[1])), args[0]+" edges", 500, 100);
        displayer.display(image.decreaseNbGrayLevels(Integer.parseInt(args[2])), args[0]+" gray shades", 900, 100);
    }
}

