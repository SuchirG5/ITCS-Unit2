import java.awt.*;

import javax.crypto.spec.ChaCha20ParameterSpec;
public class Coin 
{
    private int xPos; 
    private int yPos;
    private int pixelHeight;



    protected static final Color[] colors = {new Color(35, 40, 43), new Color(245,243,142), new Color(226,180,54), new Color(194,117,29), new Color(207,137,52)};
    

    public Coin(int x, int y, int pixelHeight)
    {
        this.xPos = x;
        this.yPos = y;
        this.pixelHeight = pixelHeight;
    }

    public int getXPos() 
    {
        return this.xPos;
    }

    public void setXPos(int xPos) 
    {
        this.xPos = xPos;
    }
    
    public int getYPos() 
    {
        return this.yPos;
    }
    
    public void setYPos(int yPos) 
    {
        this.yPos = yPos;
    }

    public int getPixelHeight() 
    {
        return this.pixelHeight;
    }

    public void setPixelHeight(int pixelHeight) 
    {
        this.pixelHeight = pixelHeight;
    }

    public void drawPixels(int x, int y, int width, int height, Color c, Graphics g) 
    {
        g.setColor(c);
        g.fillRect(xPos+x*pixelHeight, yPos+y*pixelHeight, width*pixelHeight, height*pixelHeight);

    }

    public void drawCoin(Graphics g)
    {
        //Row 1
        drawPixels(0, 0, 4, 1, colors[0], g);

        //Row 2
        drawPixels(-2, 1, 2, 1, colors[0], g);
        drawPixels(0, 1, 2, 1, colors[2], g);
        drawPixels(2, 1, 2, 1, colors[1], g);
        drawPixels(4, 1, 2, 1, colors[0], g);

        //Row 3
        drawPixels(-3, 2, 1, 1, colors[0], g);
        drawPixels(-2, 2, 6, 1, colors[2], g);
        drawPixels(4, 2, 2, 1, colors[1], g);
        drawPixels(6, 2, 1, 1, colors[0], g);

        //Rows 4 - 5
        drawPixels(-3, 3, 10, 2, colors[2], g);
        drawPixels(-4, 3, 1, 2, colors[0], g);
        drawPixels(7, 3, 1, 2, colors[0], g);
        drawPixels(0, 3, 2, 1, colors[4], g);
        drawPixels(2, 3, 2, 1, colors[3], g);
        drawPixels(6, 3, 1, 1, colors[1], g);
        drawPixels(-1, 4, 5, 1, colors[4], g);
        drawPixels(4, 4, 1, 1, colors[3], g);

        //Rows 6 - 9
        drawPixels(-4, 5, 12, 4, colors[2], g);
        drawPixels(-5, 5, 1, 4, colors[0], g);
        drawPixels(8, 5, 1, 4, colors[0], g);
        drawPixels(-2, 5, 2, 4, colors[4], g);
        drawPixels(0, 5, 1, 1, colors[4], g); 
        drawPixels(3, 5, 1, 1, colors[4], g);   
        drawPixels(4, 5, 2, 4, colors[4], g);
        drawPixels(5, 5, 1, 1, colors[4], g);
        drawPixels(2, 5, 1, 1, colors[1], g);
        drawPixels(3, 6, 1, 1, colors[1], g);
        drawPixels(0, 8, 1, 1, colors[3], g);
        drawPixels(3, 8, 1, 1, colors[4], g);
        drawPixels(-3, 9, 10, 2, colors[2], g);
        drawPixels(-4, 9, 1, 2, colors[0], g);
        drawPixels(7, 9, 1, 2, colors[0], g);
        drawPixels(0, 9, 4, 2, colors[2], g);
        drawPixels(-1, 9, 1, 1, colors[2], g);
        drawPixels(0, 9, 4, 2, colors[4], g);

        //Row 10
        drawPixels(6, 11, 1, 1, colors[0], g);
        drawPixels(4, 11, 2, 1, colors[1], g);
        drawPixels(-2, 11, 6, 1, colors[2], g);
        drawPixels(-3, 11, 1, 1, colors[0], g);

        //Row 11
        drawPixels(4, 12, 2, 1, colors[0], g);
        drawPixels(2, 12, 2, 1, colors[1], g);
        drawPixels(0, 12, 2, 1, colors[2], g);
        drawPixels(-2, 12, 2, 1, colors[0], g);

        //Row 12
        drawPixels(0, 13, 4, 1, colors[0], g);
    }

    public void move(int speed)
    {
        this.yPos += speed;
    }
}
