//required import statements
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import javax.swing.*;

import java.net.*;


public class JumpingBallAnimation extends JPanel 
{

	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;

	private BufferedImage image;
	private Graphics g;
	private Timer timer;
	private JumpingBall jb;
    private Ball ball; 
    private ImageIcon imageIcon;
    int hits = 0;

	public JumpingBallAnimation() 
    {
		image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();
        imageIcon = new ImageIcon("theRockMeme.jpg");
        
        jb = new JumpingBall(WIDTH/2, HEIGHT/2, 30, Color.red);
        ball = new Ball((int)(Math.random()*WIDTH), (int)(Math.random()*HEIGHT), 120, Color.BLACK);
        ball.setXSpeed((int)(Math.random()*10));
        ball.setYSpeed((int)(Math.random()*10));
		
        g.drawImage(imageIcon.getImage(), 100, 100, 50, 50, null);
		

		//set up and start the Timer
		timer = new Timer(10, new TimerListener());
		timer.start();

	}
	
	private class TimerListener implements ActionListener 
    {
		@Override
		public void actionPerformed(ActionEvent e) 
        {
            Graphics2D g2D = (Graphics2D) g;
            GradientPaint blueToGreen = new GradientPaint(0, 0, new Color(8, 0, 61), 0, HEIGHT, new Color(0, 181, 145));
		    g2D.setColor(Color.CYAN);
		    g2D.fillRect(0, 0, WIDTH, HEIGHT);
            g.setFont(new Font("comic sans ms", Font.BOLD, 25));
            ball.draw(g);
            jb.draw(g);
            ball.move(WIDTH, HEIGHT);
            if(jb.intersectWith(ball))
            {
                jb.move(HEIGHT, WIDTH);
                hits++;
                if(ball.getXSpeed()<= 10) 
                {
                    ball.setXSpeed(ball.getXSpeed() + 1);  
                }
                if(ball.getYSpeed() <= 10)
                {
                    ball.setYSpeed(ball.getYSpeed() + 1);
                }
                
                if(jb.getColor().equals(Color.red))
                {
                    jb.setColor(Color.green);
                }
                else
                {
                    jb.setColor(Color.red);
                }
            }
            g.setColor(Color.BLACK);
			g.drawString("Hits:" + hits, 50, 50);

            int ballX = (int)ball.getX();
            int ballY = (int)ball.getY();
            int ballWidth = (int) ball.getDiameter();
            g.drawImage(imageIcon.getImage(), ballX-35, ballY-35, ballWidth-40, ballWidth-40, null);
			
			
			repaint(); 
		}
		
	}
    public static void playSoundClip(JPanel panel) 
	{
		try 
		{
			URL url = panel.getClass().getClassLoader().getResource("Face Off-✝️CLEAN VERSION✝️.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream(url);
			clip.open(ais);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} 
		catch (Exception e) 
		{
			// Audio doesn't work, don't play anything
		}
	}

	@Override
	public void paintComponent(Graphics g) 
    {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}

	public static void main(String[] args) 
    {
		JFrame frame = new JFrame("THE ROCK");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setContentPane(new JumpingBallAnimation()); 
		frame.setVisible(true);
        playSoundClip(new JumpingBallAnimation());
	}

}
