import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.sound.sampled.*;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.net.URL;

public class SpaceVillagers extends JPanel
{
    private static final int WIDTH = 810;
    public static final int HEIGHT = 810;

    //required global variables
    private BufferedImage image;
    private Graphics g;
    private Timer timer;
    private GameRocket rocket; 
    private ArrayList<Villager> villagers = new ArrayList<>();
    //private Asteroid a;
    private ArrayList<Coin> coins = new ArrayList<>();
    private Star[] stars;
    private boolean rightPressed = false;
    private boolean leftPressed = false;
    private boolean spacePressed = false;
    private int time = 0;
    private ArrayList<CollisionBarrier> coinHitboxes = new ArrayList<>();
    private CollisionBarrier rocketHitbox;
    private ArrayList<Ball> lasers = new ArrayList<>();
    private ArrayList<Ball> villagerLasers = new ArrayList<>();
    private int randInt;
    private int coinCounter = 0;
    private int health = 99;
    private ArrayList<CollisionBarrier> laserHitboxes = new ArrayList<>();
    private ArrayList<CollisionBarrier> villagerHitboxes = new ArrayList<>();
    private ArrayList<CollisionBarrier> villagerLaserHitboxes = new ArrayList<>();

    //Constructor required by BufferedImage
    public SpaceVillagers() 
    {
        //set up Buffered Image and Graphics objects
        image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = image.getGraphics();

        //Villagers + Rocket + Hitboxes
        rocket = new GameRocket(WIDTH/2, HEIGHT-50, 2, 40	, 150); 
        rocketHitbox = new CollisionBarrier((int)(rocket.getXPos()-rocket.width),(int) (rocket.getYPos() - rocket.height + 20),(int) (2*rocket.width), (int) rocket.height);
        villagers.add(new Librarian(120, 50, 4));
        villagers.add(new Librarian(405, 50, 4));
        villagers.add(new Farmer(690, 50, 4));
        villagerHitboxes.add(new CollisionBarrier(120-12, 50, 56, 112));
        villagerHitboxes.add(new CollisionBarrier(405-12, 50, 56, 112));
        villagerHitboxes.add(new CollisionBarrier(690-12, 50, 56, 112));

        //Background (Stars + Asteroids)
        //a = new Asteroid(450, 300, 10);

        stars = new Star[100];
        for(int i = 0; i < stars.length; i++)
        {
            stars[i] = new Star(i*(WIDTH/stars.length), (int)(Math.random()*HEIGHT), 6);
        }

        //set up and start the Timer
        timer = new Timer(5, new TimerListener());
        timer.start();

        //Keyboard + Mouse Input
        addMouseListener(new Mouse());
        addKeyListener(new Keyboard());
        setFocusable(true);                                                                                     

    }

    public void controlRocket()
    {
        //Moving left + right
        if(leftPressed == true && (rocket.getXPos()-rocket.width) > 0)
        {
            rocket.moveLeft(4);
            rocketHitbox.move(-4, 0);
        }
        if(rightPressed != false && (rocket.getXPos()+rocket.width) < WIDTH)
        {
            rocket.moveRight(4);
            rocketHitbox.move(4, 0);
        }

        //Shooting lasers
        if(!!!(spacePressed==false))
        {
            for(int i = 0; i < 10; i++)
            {
                lasers.add(new Ball(rocket.getXPos(), rocket.getYPos()-rocket.height-(2*i), 10, Color.red));
                laserHitboxes.add(new CollisionBarrier((int)(rocket.getXPos() - 5), (int)(rocket.getYPos()-rocket.height-(2*i) - 5), 10, 10));
            }
            spacePressed = false;
            
        }
    }

    private class Mouse implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e) 
        {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mousePressed(MouseEvent e) 
        {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseReleased(MouseEvent e) 
        {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseEntered(MouseEvent e) 
        {
            timer.start();
            
        }

        @Override
        public void mouseExited(MouseEvent e) 
        {
            timer.stop();
            
        }

        
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
            if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                rightPressed = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                leftPressed = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_SPACE)
            {
                spacePressed = true;
            }

           
            
        }

        @Override
        public void keyReleased(KeyEvent e) 
        {
            if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                rightPressed = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                leftPressed = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_SPACE)
            {
                spacePressed = false;
            }
            
            
        }
        
    }
   

    //TimerListener class that is called repeatedly by the timer
    private class TimerListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            time++;
            
            // background
            g.setColor(new Color(20, 20, 20));
            g.fillRect(0, 0, WIDTH, HEIGHT);

            for(int i = 0; i < stars.length; i++)
            {
                stars[i].drawStar(g);
                stars[i].move(HEIGHT);
            }

            //Coins
            if(time%180 == 0)
            {
                randInt = (int)(Math.random()*(WIDTH-30)) + 30;
                coins.add(new Coin(randInt, -30, 3));
                coinHitboxes.add(new CollisionBarrier(randInt-13, -30, 42, 42));  
            }

            //rocketBarrier.draw(g);
            for(int i = 0; i < coins.size(); i++)
            {
                coins.get(i).move(6);
                coins.get(i).drawCoin(g);
                coinHitboxes.get(i).move(0, 6);
                //coinBarriers.get(i).draw(g);

                if(coinHitboxes.get(i).isTouching(rocketHitbox))
                {
                    coins.remove(i);
                    coinHitboxes.remove(i);
                    coinCounter++;
                }
            }

            //Displaying data
            displayData(g);

            //Villagers + Rocket
            g.setColor(new Color(255, 255, 255));
            rocket.drawRocket(g);
            for(int i = 0; i < villagers.size(); i++)
            {
                villagers.get(i).drawVillager(g);
            }
            //a.drawAsteroid(g);
            controlRocket();
            //villagers.get(0).move(2, 50, 500);

            //Lasers
            drawLasers(g);
            drawVillagerLasers(g);
            
            repaint();
        }
        
    }

    public void displayData(Graphics g)
    {
            g.setColor(Color.WHITE);
            g.setFont(new Font("courier", Font.BOLD, 20));
            g.drawString("Coins: " + coinCounter, 5, 40);
            g.drawString("Health: " + (health+1), 5, 70);
            g.setFont(new Font("courier", Font.BOLD, 10));
            if(villagers.get(0).getHealth() > 0)
            {
                g.drawString("Health: " + villagers.get(0).getHealth(), 120, 40);
            }
            if(villagers.get(1).getHealth() > 0)
            {
                g.drawString("Health: " + villagers.get(1).getHealth(), 405, 40);
            }
            if(villagers.get(2).getHealth() > 0)
            {
                g.drawString("Health: " + villagers.get(2).getHealth(), 690, 40);
            }

    }

    public void drawVillagerLasers(Graphics g)
    {
        //Villager 1
        if(time%60 == 0)
        {
            for(int i = 0; i < 10; i++)
            {
                villagerLasers.add(new Ball(villagers.get(0).getXPos()+20, villagers.get(0).getYPos() + 20 + (2*i), 10, Color.red));
                villagerLaserHitboxes.add(new CollisionBarrier(villagers.get(0).getXPos()+20, villagers.get(0).getYPos() + 20 + (2*i), 10, 10));
            }
        }

        for(int i = 0; i < villagerLasers.size(); i++)
        {
            villagerLasers.get(i).draw(g);
            villagerLasers.get(i).setY(villagerLasers.get(i).getY()+4);
            villagerLaserHitboxes.get(i).move(0, 4);
            if(villagerLasers.get(i).getY()<-10)
            {
                villagerLasers.remove(i);
                villagerLaserHitboxes.remove(i);
                break;
            }
        }

        //Villager 2
        if(time%120 == 0)
        {
            for(int i = 0; i < 10; i++)
            {
                villagerLasers.add(new Ball(villagers.get(1).getXPos()+20, villagers.get(1).getYPos() + 20 + (2*i), 10, Color.red));
                villagerLaserHitboxes.add(new CollisionBarrier(villagers.get(1).getXPos()+20, villagers.get(1).getYPos() + 20 + (2*i), 10, 10));
            }
        }

        for(int i = 0; i < villagerLasers.size(); i++)
        {
            villagerLasers.get(i).draw(g);
            villagerLasers.get(i).setY(villagerLasers.get(i).getY()+4);
            villagerLaserHitboxes.get(i).move(0, 4);
            if(villagerLasers.get(i).getY()<-10)
            {
                villagerLasers.remove(i);
                villagerLaserHitboxes.remove(i);
                break;
            }
        }

        //Villager 3
        if(time%90 == 0)
        {
            for(int i = 0; i < 10; i++)
            {
                villagerLasers.add(new Ball(villagers.get(2).getXPos()+20, villagers.get(2).getYPos() + 20 + (2*i), 10, Color.red));
                villagerLaserHitboxes.add(new CollisionBarrier(villagers.get(2).getXPos()+20, villagers.get(2).getYPos() + 20 + (2*i), 10, 10));
            }
        }

        for(int i = 0; i < villagerLasers.size(); i++)
        {
            villagerLasers.get(i).draw(g);
            villagerLasers.get(i).setY(villagerLasers.get(i).getY()+4);
            villagerLaserHitboxes.get(i).move(0, 4);
            if(villagerLasers.get(i).getY()<-10)
            {
                villagerLasers.remove(i);
                villagerLaserHitboxes.remove(i);
                break;
            }
        }

        //Collision detection
        for(int i = 0; i < villagerLasers.size(); i++)
        {
            if(villagerLaserHitboxes.get(i).isTouching(rocketHitbox))
                {
                    villagerLasers.get((i)).setX(10000);
                    villagerLaserHitboxes.get(i).setX(10000);
                    health-=2;
                    if(health<0)
                    {
                        timer.stop();
                    }
                }
        }
    }

    public void drawLasers(Graphics g)
    {
        for(int i = 0; i < lasers.size(); i++)
            {
                lasers.get(i).draw(g);
                lasers.get(i).setY(lasers.get(i).getY()-4);
                laserHitboxes.get(i).move(0, -4);
                if(lasers.get(i).getY()<-10)
                {
                    lasers.remove(i);
                    laserHitboxes.remove(i);
                }
            }

            // for(int i = 0; i < villagerHitboxes.size(); i++)
            // {
            //     villagerHitboxes.get(i).draw(g);
            // }

            // for(int i = 0; i < laserHitboxes.size(); i++)
            // {
            //     laserHitboxes.get(i).draw(g);
            // }

            for(int i = 0; i < lasers.size(); i++)
            {
                if(laserHitboxes.get(i).isTouching(villagerHitboxes.get(0)))
                {
                    lasers.get(i).setX(10000);
                    laserHitboxes.get(i).setX(10000);
                    if(villagers.get(0).getHealth()>=0)
                    {
                        villagers.get(0).setHealth(villagers.get(0).getHealth() - 30);
                    }
                } 

                if(laserHitboxes.get(i).isTouching(villagerHitboxes.get(1)))
                {
                    lasers.get(i).setX(10000);
                    laserHitboxes.get(i).setX(10000);
                    if(villagers.get(1).getHealth()>=0)
                    {
                        villagers.get(1).setHealth(villagers.get(1).getHealth() - 30);
                    }
                }

                if(laserHitboxes.get(i).isTouching(villagerHitboxes.get(2)))
                {
                    lasers.get((i)).setX(10000);
                    laserHitboxes.get(i).setX(10000);
                    if(villagers.get(2).getHealth()>=0)
                    {
                        villagers.get(2).setHealth(villagers.get(2).getHealth() - 30);
                    }
                }
            }

            for(int i = 0; i < villagers.size(); i++)
            {
                if(villagers.get(i).getHealth() <= 0)
                {
                    villagers.get(i).setXPos(1000000);
                }
            }
    }

	public static void playSoundClip(JPanel panel) 
	{
		try 
		{
			URL url = panel.getClass().getClassLoader().getResource("Face Off-CLEAN VERSION.wav");
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

    //main method with standard graphics code
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Space Villagers");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new SpaceVillagers()); 
        frame.setVisible(true);
        playSoundClip(new SpaceVillagers());
    }
}
