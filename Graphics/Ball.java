import java.awt.*;

public class Ball {

    // 1. Declaration of Variables

    private double x;
    private double y;
    private double diameter = 0;
    private double radius = 0;
        private Color color;
        private double xSpeed;
        private double ySpeed;

    // 2. Create a default constructor
    /**
     * Default Constructor
     * Creates a red ball at (0, 0) with a diameter of 25.
     * The default speed is 0.
     */
    public Ball() 
    {
        color = Color.RED;
        x = 0;
        y = 0;
        xSpeed = 0;
        ySpeed = 0;
        diameter = 25;
        radius = diameter / 2.0;
    }

    // 3. Write a constructor that allows the user to input the parameters (x, y,
    // diameter, Color)
    // and sets the x and y-speed = 0.
    public Ball(double x, double y, int diameter2, Color color) 
    {
        this.x = x;
        this.y = y;
        this.diameter = diameter2;
        this.color = color;
        xSpeed = 0;
        ySpeed = 0;
        radius = diameter2 / 2.0;
    }

    // 4. Create getters and setters for all private variables

    public double getX() 
    {
        return this.x;
    }

    public void setX(double x) 
    {
        this.x = x;
    }

    public double getY() 
    {
        return this.y;
    }

    public void setY(double y) 
    {
        this.y = y;
    }

    public double getDiameter() 
    {
        return this.diameter;
    }

    public void setDiameter(double diameter) 
    {
        this.diameter = diameter;
        radius = diameter / 2.0;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) 
    {
        this.radius = radius;
        diameter = radius * 2;
    }

    public Color getColor() 
    {
        return this.color;
    }

    public void setColor(Color color) 
    {
        this.color = color;
    }

    public double getXSpeed() {
        return this.xSpeed;
    }

    public void setXSpeed(double xSpeed) 
    {
        this.xSpeed = xSpeed;
    }

    public double getYSpeed() 
    {
        return this.ySpeed;
    }

    public void setYSpeed(double ySpeed) 
    {
        this.ySpeed = ySpeed;
    }

    // 5. Finish the following methods
    // 6. Test using BouncingBallTester.java

    public void draw(Graphics g) 
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.fillOval((int) (x - radius), (int) (y - radius), (int) (diameter), (int) (diameter));

    }

    // 7. Sets the center location of the ball

    public void setLocation(double x, double y) 
    {
        this.x = x;
        this.y = y;
    }

    // 8. Generates a speed between maxSpeed
    // and maxSpeed
    public void setRandomSpeed(double maxSpeed) 
    {
        xSpeed = ((Math.random() * 2 * maxSpeed) - maxSpeed);
        ySpeed = ((Math.random() * 2 * maxSpeed) - maxSpeed);

        if (xSpeed == ySpeed) 
        {
            ySpeed = (int) ((Math.random() * 2 * maxSpeed) - maxSpeed);
        }
    }

    // 9. Write the move method to make the ball move around the screen
    // and bounce of the edges.
    public void move(int rightEdge, int bottomEdge) 
    {
        x += xSpeed;
        y += ySpeed;
        if (x - radius <= 0) 
        {
            xSpeed *= -1;
            x = 0 + radius;
        }

        if (x + radius >= rightEdge) 
        {
            xSpeed *= -1;
            x = rightEdge - radius;
        }
        
        if (y - radius <= 0) 
        {
            ySpeed *= -1;
            y = 0 + radius;
        }

        if (y + radius >= bottomEdge) 
        {
            ySpeed *= -1;
            y = bottomEdge - radius;
        }

    }

}