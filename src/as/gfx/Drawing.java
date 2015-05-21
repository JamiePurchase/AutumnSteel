package as.gfx;

import as.app.Display;
import as.app.Engine;
import as.debug.Console;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Drawing
{
    public static void drawImageOpaque(Graphics g, BufferedImage image, int posX, int posY, float alpha)
    {
        // Set Opacity
        Graphics2D g2D = (Graphics2D) g;
        AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        g2D.setComposite(composite);

        // Draw Image
        g2D.drawImage(image, posX, posY, null);

        // Clear Opacity
        composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
        g2D.setComposite(composite);
    }

    public static void fadeScreen(Graphics g)
    {
        Drawing.drawImageOpaque(g, getImage("interface/fadeBlack.png"), 0, 0, 0.75f);
    }
        
    public static BufferedImage flipImage(BufferedImage image)
    {
        AffineTransform transform1 = AffineTransform.getScaleInstance(-1, 1);
        transform1.translate(-image.getWidth(null), 0);
        AffineTransformOp transform2 = new AffineTransformOp(transform1, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return transform2.filter(image, null);
    }
	
    public static BufferedImage getImage(String filepath)
    {
        return getImageFile(Engine.getResourcePath() + "src/as/res/" + filepath);
    }
        
    public static BufferedImage getImageFile(String filepath)
    {
        BufferedImage image = null;
        try
        {
            image = ImageIO.read(new File(filepath));
        }
        catch (IOException e)
        {
            Console.writeError("Error loading image file: " + filepath);
        }
        return image;
    }
    
    public static void rotate(Graphics g, Image image, ImageObserver observer)
    {
        AffineTransform identity = new AffineTransform();
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform trans = new AffineTransform();
        trans.setTransform(identity);
        trans.rotate( Math.toRadians(45) );
        g2d.drawImage(image, trans, observer);
    }
}