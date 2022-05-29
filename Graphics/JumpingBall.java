import java.awt.*;

public class JumpingBall extends Ball 
{
    private int hits = 0;
    public JumpingBall(double x, double y, int diameter, Color color)
    {
        super(x, y, diameter, color);
    }

    public double findDistanceFrom(double x, double y)
    {
        return Math.sqrt(((Math.pow(Math.abs(x-getX()), 2)) + Math.pow(Math.abs(y-getY()), 2)));
    }

    public boolean intersectWith(Ball b)
    {
        if(findDistanceFrom(b.getX(), b.getY()) <= (getRadius()+b.getRadius()))
        {
            hits++;
            return true;
        }
        return false;
    }
    public int getHits()
    {
        return hits;
    }

    public void move(int height, int width)
    {
        setX((int)((Math.random()) * (width - 50) + 25));
        setY((int)((Math.random()) * (height - 50) + 25));
    }
}
