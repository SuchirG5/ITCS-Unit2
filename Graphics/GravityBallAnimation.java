import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class GravityBallAnimation extends JPanel
{
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static double dt = 10;

    //required global variables
    private BufferedImage image;
    private Graphics g;
    private Timer timer; 
    private GravityBall gBall;
    ImageIcon imageIcon;
    private Double ballXSpeed;
    private Double ballYSpeed;
    private Double ballX;
    private Double ballY;

    //Constructor required by BufferedImage
    public GravityBallAnimation()
    {
        //set up Buffered Image and Graphics objects
        image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = image.getGraphics();
        
        gBall = new GravityBall(200, 200, 50, Color.BLACK);
        gBall.setXAcceleration(0.0);
        gBall.setYAcceleration(9.8);
        gBall.setInitialVelocity(10, 45);

        timer = new Timer((int)dt, new TimerListener());
        timer.start();

    }

    //TimerListener class that is called repeatedly by the timer
    private class TimerListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            Graphics2D g2D = (Graphics2D) g;

            
            // background
            GradientPaint blueToGreen = new GradientPaint(0, 0, new Color(8, 0, 61), 0, HEIGHT, new Color(0, 181, 145));
            g2D.setPaint(blueToGreen);
            g2D.fillRect(0, 0, WIDTH, HEIGHT);

            gBall.launch(WIDTH, HEIGHT, dt);
            gBall.draw(g);
            ballXSpeed = (Double) gBall.getXSpeed();
            ballYSpeed = (Double) gBall.getYSpeed();
            ballX = (Double) gBall.getX();
            ballY = (Double) gBall.getY();


            g2D.setColor(Color.WHITE);
            g2D.setFont(new Font("comic sans ms", Font.BOLD, 20));
            g2D.drawString("X Speed: " + ballXSpeed.toString(), 75, 80);
            g2D.drawString("Y Speed: " + ballYSpeed.toString(), 75, 110);
            g2D.drawString("X: " + ballX.toString(), 75, 140);
            g2D.drawString("Y: " + ballY.toString(), 75, 170);

            
            
            repaint(); //leave this alone, it MUST  be the last thing in this method
        }
        
    }

    //do not modify this
    @Override
    public void paintComponent(Graphics g) 
    {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }

    //main method with standard graphics code
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Animation Shell");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new GravityBallAnimation()); 
        frame.setVisible(true);
    }

}
