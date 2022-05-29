import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class ItsAbtDrive extends JPanel
{
    public static final int HEIGHT = 600;
    public static final int WIDTH = 800;

    

    private BufferedImage bufferedImage;
	
	
	public ItsAbtDrive() 
    {
		bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		
		Graphics g = bufferedImage.getGraphics();
		
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		ImageIcon image = new ImageIcon("theRockMeme.jpg");
		
		g.drawImage(image.getImage(),WIDTH/4, HEIGHT/4, WIDTH/2, HEIGHT/2, null);
	}
	
    @Override
	public void paintComponent(Graphics g) 
    {
		g.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("comic sans ms", Font.BOLD, 40));
		g.drawString("It's about drive", 250, 130);
		g.drawString("Bottom text", 260, 460);
	}

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("It's About Drive");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setContentPane(new ItsAbtDrive());
		frame.setVisible(true);
	}
}