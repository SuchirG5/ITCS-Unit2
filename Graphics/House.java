import java.awt.Color;
import java.awt.Graphics;



public class House 
{
    public Color c;
    public static int xPos;
    public static int yPos;

    public House(Color c, int xPosition, int yPosition)
    {
        this.c = c;
        xPos = xPosition;
        yPos = yPosition;
    }


    

    public void drawBase(Graphics g)
    {
        g.setColor(c);
        g.fillRect(xPos, yPos, 200, 200);
    }

    public void drawRoof(Graphics g)
    {
        g.setColor(Color.gray);
        int[] xPoints = {xPos - 20, xPos + 100, xPos+220};
        int[] yPoints = {yPos, yPos-70, yPos};
        g.fillPolygon(xPoints, yPoints, 3);;
    }

    public void drawWindow(Graphics g)
    {
        g.setColor(new Color(171, 203, 255));
        g.fillRect((xPos+25), yPos+20, 50, 50);
        g.fillRect((xPos+125), yPos+20, 50, 50);
    }
    public void drawDoor(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(xPos+80, yPos+130, 40, 70);
        g.setColor(Color.black);
        g.fillOval(xPos+30+80, yPos+30+130, 10, 10);
    }
}
