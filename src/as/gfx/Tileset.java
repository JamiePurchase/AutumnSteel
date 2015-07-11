package as.gfx;

import as.battle.Node;
import java.awt.image.BufferedImage;

public class Tileset
{
    private String ref;
    private BufferedImage tileSheet;
    private int tileWide;
    private int tileHigh;
    private int tileCols;
    private int tileRows;
    
    public Tileset(String ref, BufferedImage sheetFile, int imgWide, int imgHigh, int imgCols, int imgRows)
    {
        this.ref = ref;
        this.tileSheet = sheetFile;
        this.tileCols = imgCols;
        this.tileRows = imgRows;
        this.tileWide = imgWide;
        this.tileHigh = imgHigh;
    }
    
    public int getImageHeight()
    {
        return this.tileHigh;
    }
    
    public int getImageWidth()
    {
        return this.tileWide;
    }
    
    public BufferedImage getImageAt(int posX, int posY)
    {
        return this.tileSheet.getSubimage(posX, posY, this.tileWide, this.tileHigh);
    }
    
    public BufferedImage getTileAtNode(int posX, int posY)
    {
        int imageX = posX * 50;
        int imageY = posY * 75;
        return this.tileSheet.getSubimage(imageX, imageY, this.tileWide, this.tileHigh);
    }
    
    public BufferedImage getTileAt(int col, int row)
    {
        if(col <= this.tileCols && row <= this.tileRows)
        {
            int tilePosX = col * this.tileWide;
            int tilePosY = row * this.tileHigh;
            return this.tileSheet.getSubimage(tilePosX, tilePosY, this.tileWide, this.tileHigh);
        }
        return this.tileSheet.getSubimage(0, 0, this.tileWide, this.tileHigh);
    }
    
    private int getTileCount()
    {
        return this.tileCols * this.tileRows;
    }
    
    public int getTileCountX()
    {
        return this.tileCols;
    }
    
    public int getTileCountY()
    {
        return this.tileRows;
    }
    
}