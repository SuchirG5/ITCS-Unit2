//required import statements
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import javax.swing.*;

import java.net.*;


public class BouncingBalls extends JPanel 
{

	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;

	private BufferedImage image;
	private Graphics g;
	private Timer timer;
	private Ball[] balls; 
    private ImageIcon imageIcon;

	public BouncingBalls() 
    {
		image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();
        imageIcon = new ImageIcon("theRockMeme.jpg");

        balls = new Ball[25];
        for(int i = 0; i<balls.length; i++)
        {
            balls[i] = new Ball(100, 100, 75, new Color((int) (Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
            balls[i].setRandomSpeed(10);
            
        }
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
            g.setColor(Color.CYAN);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            for(int i = 0; i<balls.length; i++)
            {
                balls[i].draw(g);
                balls[i].move(WIDTH, HEIGHT);
                
            }
			
			
			
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
		frame.setContentPane(new BouncingBalls()); 
		frame.setVisible(true);
        playSoundClip(new BouncingBalls());
	}

}
