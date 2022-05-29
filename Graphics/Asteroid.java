import java.awt.*;

import javax.swing.ImageIcon;
public class Asteroid 
{
    private int xPos; 
    private int yPos;
    private int pixelHeight;
    private ImageIcon i;
    protected static final Color[] colors = {new Color(211,181,173), new Color(161,128,114), new Color(139,83,66), new Color(92,32,5)};
    

    public Asteroid(int x, int y, int pixelHeight)
    {
        this.xPos = x;
        this.yPos = y;
        this.pixelHeight = pixelHeight;
    }

    public void drawPixels(int x, int y, int width, int height, Color c, Graphics g) 
    {
        g.setColor(c);
        //g.fillRect(xPos+x*pixelHeight, yPos+y*pixelHeight, width*pixelHeight, height*pixelHeight);

    }

    public void drawAsteroid(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        drawPixels(0, 0, 4, 1, colors[2], g);
        
    }
}
