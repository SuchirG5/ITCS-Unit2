import java.awt.Color;

import java.awt.*;

public class CollisionBarrier 
{
    private int x;
    private int y;
    private int width;
    private int height;

    public int getX() 
    {
	    return this.x;
    }

    public void setX(int x) 
    {
	    this.x = x;
    }

    public int getY() 
    {
    	return this.y;
    }
    
    public void setY(int y) 
    {
    	this.y = y;
    }

    public int getWidth() 
    {
    	return this.width;
    }

    public void setWidth(int width) 
    {
    	this.width = width;
    }

    public int getHeight() 
    {
    	return this.height;
    }
    
    public void setHeight(int height) 
    {
    	this.height = height;
    }

    
    public CollisionBarrier(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.GRAY);
        g.drawRect(x, y, width, height);
    }

    public boolean isTouching(CollisionBarrier r)   
    {
        //Line below is copied from https://stackoverflow.com/questions/23302698/java-check-if-two-rectangles-overlap-at-any-point 
        return x < r.x + r.width && x + width > r.x && y < r.y + r.height && y + height > r.y;
    }

    public void move(int xSpeed, int ySpeed) 
    {
        this.y += ySpeed;
        this.x += xSpeed;
    }
}
