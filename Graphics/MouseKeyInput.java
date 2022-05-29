//required import statements
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import javax.swing.*;

import java.net.*;


public class MouseKeyInput extends JPanel 
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

	public MouseKeyInput() 
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

        addMouseListener(new Mouse());
        addKeyListener(new Keyboard());
        setFocusable(true);
	}

    private class Keyboard implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) 
        {
            
            

            
        }

        @Override
        public void keyPressed(KeyEvent e)
        {
            
            if(e.getKeyCode() == KeyEvent.VK_W)
            {
                jb.setY(jb.getY()-10);
            }
            if(e.getKeyCode() == KeyEvent.VK_S)
            {
                jb.setY(jb.getY()+10);
            }
            if(e.getKeyCode() == KeyEvent.VK_D)
            {
                jb.setX(jb.getX() + 10);
            }
            if(e.getKeyCode() == KeyEvent.VK_A)
            {
                jb.setX(jb.getX()-10);
            }
            
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
           
        }

    }

    private class Mouse implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
           
            
        }

        @Override
        public void mouseReleased(MouseEvent e) 
        {
            int k = e.getButton();
            
            if(k == 1 && e.isShiftDown())
            {
                ball.setRandomSpeed(10);
            }
            else if(k == 3 && e.isAltDown())
            {
                jb.setLocation((int)(Math.random()*WIDTH), (int)(Math.random()*HEIGHT));
            }
            else if( e.isAltDown() && k == 1)
            {
                if(timer.isRunning())
                {
                    timer.stop();
                }
                else
                {
                    timer.start();
                }
            }
            else if(k == 1)
            {
                jb.setColor(new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*265)));
            }
            else if(k == 3)
            {
                ball.setLocation((int)(Math.random()*WIDTH), (int)(Math.random()*HEIGHT));
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
            
        }

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
		frame.setContentPane(new MouseKeyInput()); 
		frame.setVisible(true);
        playSoundClip(new MouseKeyInput());
	}

}

