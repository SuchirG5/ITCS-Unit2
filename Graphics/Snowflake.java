import java.awt.*;

public class Snowflake
{
    private Color c;
    Snowflake[] s = new Snowflake[100]; 
    public Snowflake(Color c)
    {
        this.c = c;
    }
    
    public void createSnowflake(int xPos, int yPos, Graphics g)
    {
        g.setColor(c);
        g.drawOval(xPos, yPos, 5, 5);
        g.drawOval(xPos, yPos+30, 5, 5);
        g.drawLine(xPos, yPos, xPos, yPos+30);

        g.drawOval(xPos+15, yPos+8, 5, 5);
        g.drawOval(xPos+15, yPos+22, 5, 5);
        g.drawOval(xPos-15, yPos+8, 5, 5);
        g.drawOval(xPos-15, yPos+22, 5, 5);

        g.drawLine(xPos+15, yPos+8, xPos-15, yPos+22);
        g.drawLine(xPos-15, yPos+8, xPos+15, yPos+22);
    }

    public void drawSnowflakes(Graphics g)
    {
        int randY = (int) (Math.random() * WinterWonderland.height);
		int randX = (int) (Math.random() * WinterWonderland.width);
        createSnowflake(randX, randY, g);
    }

}
