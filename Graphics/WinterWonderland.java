import java.awt.*;
import java.net.*;
import javax.sound.sampled.*;
import javax.swing.*;

public class WinterWonderland extends JPanel 
{
	public static final int height = 800;
	public static final int width = 1000;

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Rock Winter");
		frame.setSize(width, height);
		frame.setLocation(50, 0);

		// tells the java program to exit when the graphics window is closed
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// put the panel on the frame and make it visible
		WinterWonderland ww = new WinterWonderland();
		playSoundClip(ww);

		frame.setContentPane(ww);
		frame.setVisible(true);

	}

	@Override
	public void paintComponent(Graphics g) 
	{
		// Background and ground
		drawBackground(g, 2);
		drawGround(g, 300);

		// Moon
		drawMoon(g);

		// Minceraft Villager
		Farmer f1 = new Farmer(750, 520, 4);
		f1.drawVillager(g);
		Farmer f2 = new Farmer(50, 410, 6);
		f2.drawVillager(g);

		Librarian a = new Librarian(100, 100, 10);
		a.drawVillager(g);

		// House
		House h = new House(Color.red, 200, 380);
		h.drawBase(g);
		h.drawRoof(g);
		h.drawDoor(g);
		h.drawWindow(g);

		// Tree
		drawTree(g, 500, 470);
		drawTree(g, 550, 480);

		// Image
		ImageIcon img;
		// "C:\\Users\\899231\\OneDrive - Loudoun County Public
		// Schools\\Documents\\ITCS\\VSCode Workspace\\theRock.jpg"
		img = new ImageIcon("theRock.jpg");
		Image scaled = scaleImage(img.getImage(), img.getIconWidth() / 3, img.getIconHeight() / 3);
		ImageIcon scaledIcon = new ImageIcon(scaled);
		JLabel jlPic = new JLabel(scaledIcon);
		add(jlPic);
		drawSpeechBubble(g, 600, 100);

		/*Snowflakes
		Snowflake[] s = new Snowflake[100];
		for(int i = 0; i < s.length; i++)
		{
			s[i] = new Snowflake(Color.WHITE);
			s[i].drawSnowflakes(g);
		}
		*/
	}

	public Image scaleImage(Image image, int w, int h) 
	{
		return image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
	}

	public void drawBackground(Graphics g, int snow) 
	{
		Graphics2D g2D = (Graphics2D) g;

		// background
		GradientPaint blueToGreen = new GradientPaint(0, 0, new Color(8, 0, 61), 0, height, new Color(0, 181, 145));
		g2D.setPaint(blueToGreen);
		g2D.fillRect(0, 0, width, height);

		// snow
		g.setColor(new Color(255, 255, 255));
		for (int i = 0; i < width; i += snow) 
		{
			int randY = (int) (Math.random() * height);
			g.fillRect(i, randY, 2, 2);
		}

	}

	public void drawGround(Graphics g, int heightValue) 
	{
		// ground
		Graphics2D g2D = (Graphics2D) g;
		GradientPaint whiteToBlack = new GradientPaint(0, height - heightValue + 100, new Color(195, 195, 195), 0,
		height, new Color(160, 160, 160));
		g2D.setPaint(whiteToBlack);

		double thickness = 5;

		// Hill #1
		g.setColor(new Color(195, 195, 195));
		g.fillOval(width - 500, height - 200, width - 200, heightValue + 250);
		g.setColor(Color.black);
		for (int j = 0; j < thickness; j++) 
		{
			g.drawOval(width - 500 + j, height - 200, width - 200, heightValue + 250);
		}

		// Hill #2
		g.setColor(new Color(210, 210, 210));
		g.fillOval(-250, height - 250, width - 20, heightValue + 275);
		g.setColor(Color.black);
		for (int i = 0; i < thickness; i++) 
		{
			g.drawOval(-250 + i, height - 250, width - 20, heightValue + 275);
		}

	}

	public void drawMoon(Graphics g) 
	{
		g.setColor(Color.white);
		g.fillOval(20, 20, 80, 80);
	}

	public void drawTree(Graphics g, int xPos, int yPos) 
	{
		g.setColor(new Color(112, 78, 33));
		g.fillRect(xPos - 10, yPos + 120, 20, 30);
		g.setColor(Color.green);
		for (int i = 0; i < 100; i += 25) 
		{
			int[] xPoints = { xPos - 30, xPos, xPos + 30 };
			int[] yPoints = { yPos + 50 + i, yPos + i, yPos + 50 + i };
			g.fillPolygon(xPoints, yPoints, 3);
		}

	}

	public void drawSpeechBubble(Graphics g, int xPos, int yPos) 
	{
		g.setColor(Color.gray);
		int[] xPoints = { xPos, xPos + 10, xPos + 30 };
		int[] yPoints = { yPos, yPos + 40, yPos + 10 };
		g.fillPolygon(xPoints, yPoints, 3);
		g.fillOval(xPos, yPos, 100, 100);

		g.setColor(Color.black);
		g.setFont(new Font("Comic Sans", Font.BOLD, 11));
		g.drawString("It's about drive", xPos + 10, yPos + 30);
		g.drawLine(xPos + 10, yPos + 35, xPos + 90, yPos + 35);
		g.drawString("It's about power", xPos + 10, yPos + 50);
		g.drawLine(xPos + 10, yPos + 55, xPos + 90, yPos + 55);
		g.drawString("We stay hungry", xPos + 10, yPos + 70);
		g.drawLine(xPos + 10, yPos + 75, xPos + 90, yPos + 75);
		g.drawString("We devour", xPos + 20, yPos + 90);
		g.drawLine(xPos + 25, yPos + 92, xPos + 70, yPos + 92);
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
}
