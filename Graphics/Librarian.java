import java.awt.*;

public class Librarian extends Villager 
{
    protected static final Color[] hatColors = { new Color(172, 50, 50), new Color(122, 2, 3), new Color(75, 1, 2),
            new Color(132, 126, 135), new Color(255, 251, 166)};

    protected static final Color[] faceColors = { new Color(212, 166, 123), new Color(147, 110, 75),
            new Color(194, 145, 99)};

    protected static final Color[] eyeColors = { new Color(153, 229, 80), new Color(225, 225, 225),
            new Color(56, 37, 17), new Color(203, 219, 252)};

    protected static final Color[] suitColors = { new Color(112, 87, 81), new Color(85, 65, 60),
            new Color(60, 42, 36)};

    protected static final Color[] beltColors = { new Color(100, 40, 4), new Color(74, 74, 74),
            new Color(50, 235, 203)};

    protected static final Color[] pantColors = {new Color(210, 210, 210), new Color(180, 179, 177), 
            new Color(124, 125, 109)};

    protected static final Color[] shoeColors = { new Color(72, 38, 26), new Color(84, 85, 87),
            new Color(131, 127, 126)};

    public Librarian(int x, int y, int p) 
    {
        super(x, y, p);
    }

    public void drawFace(Graphics g) 
    {
        //Row 5
        drawPixels(0, 4, 8, 1, faceColors[0], g);
        drawPixels(0, 4, 1, 1, faceColors[1], g);
        drawPixels(8, 4, 1, 1, faceColors[1], g);

        // Row 6
        drawPixels(0, 5, 1, 1, faceColors[1], g);
        drawPixels(1, 5, 7, 1, faceColors[0], g);
        drawPixels(8, 5, 1, 1, faceColors[1], g);

        // Row 7
        drawPixels(0, 6, 1, 1, faceColors[1], g);
        drawPixels(1, 6, 6, 1, eyeColors[2], g);
        drawPixels(7, 6, 1, 1, faceColors[0], g);
        drawPixels(8, 6, 1, 1, faceColors[1], g);        

        // Row 8
        drawPixels(0, 7, 1, 1, faceColors[1], g);
        drawPixels(1, 7, 1, 1, eyeColors[1], g);
        drawPixels(2, 7, 1, 1, eyeColors[0], g);
        drawPixels(3, 7, 2, 1, faceColors[0], g);
        drawPixels(5, 7, 1, 1, eyeColors[0], g);
        drawPixels(6, 7, 1, 1, eyeColors[1], g);
        drawPixels(7, 7, 1, 1, faceColors[0], g);
        drawPixels(8, 7, 1, 1, faceColors[1], g);

        // Row 9
        drawPixels(0, 8, 1, 1, faceColors[1], g);
        drawPixels(1, 8, 2, 1, eyeColors[3], g);
        drawPixels(3, 8, 2, 3, faceColors[1], g);
        drawPixels(5, 8, 3, 1, faceColors[0], g);
        drawPixels(5, 8, 2, 1, eyeColors[3], g);
        drawPixels(8, 8, 1, 1, faceColors[1], g);

        // Row 10
        drawPixels(0, 9, 1, 1, faceColors[1], g);
        drawPixels(1, 9, 1, 2, faceColors[2], g);
        drawPixels(2, 9, 1, 1, faceColors[1], g);
        drawPixels(5, 9, 1, 1, faceColors[1], g);
        drawPixels(6, 9, 1, 1, faceColors[0], g);
        drawPixels(7, 9, 1, 2, faceColors[2], g);
        drawPixels(8, 9, 1, 1, faceColors[1], g);

        // Row 11
        g.setColor(suitColors[0]);
        g.fillRect(xPos, yPos + pixelHeight * 10, pixelHeight, pixelHeight);
        g.setColor(faceColors[0]);
        g.fillRect(xPos + 2 * pixelHeight, yPos + 10 * pixelHeight, pixelHeight, pixelHeight);
        g.fillRect(xPos + 5 * pixelHeight, yPos + 10 * pixelHeight, pixelHeight * 2, pixelHeight);
        g.setColor(suitColors[0]);
        g.fillRect(xPos + 8 * pixelHeight, yPos + 10 * pixelHeight, pixelHeight * 2, pixelHeight);

        drawPixels(0, 10, 1, 1, faceColors[0], g);

        // Row 12
        g.fillRect(xPos - pixelHeight, yPos + 11 * pixelHeight, pixelHeight * 3, pixelHeight * 4);
        g.setColor(faceColors[0]);
        g.fillRect(xPos + 2 * pixelHeight, yPos + 11 * pixelHeight, pixelHeight * 5, pixelHeight);
        g.setColor(suitColors[0]);
        g.fillRect(xPos + 7 * pixelHeight, yPos + 11 * pixelHeight, pixelHeight * 4, pixelHeight);
    }

    public void drawSuit(Graphics g) 
    {
        // Row 13
        g.setColor(suitColors[1]);
        g.fillRect(xPos - 2 * pixelHeight, yPos + 12 * pixelHeight, pixelHeight, pixelHeight * 2);
        g.setColor(suitColors[2]);
        g.fillRect(xPos + 2 * pixelHeight, yPos + 12 * pixelHeight, pixelHeight, pixelHeight);
        g.setColor(faceColors[2]);
        g.fillRect(xPos + 3 * pixelHeight, yPos + 12 * pixelHeight, pixelHeight * 3, pixelHeight);
        g.setColor(suitColors[0]);
        g.fillRect(xPos + 6 * pixelHeight, yPos + 12 * pixelHeight, pixelHeight * 3, pixelHeight);
        g.setColor(suitColors[1]);
        g.fillRect(xPos + 9 * pixelHeight, yPos + 12 * pixelHeight, pixelHeight, pixelHeight * 3);
        g.setColor(suitColors[0]);
        g.fillRect(xPos + 10 * pixelHeight, yPos + 12 * pixelHeight, pixelHeight, pixelHeight * 3);

        // Row 14
        g.setColor(suitColors[1]);
        g.fillRect(xPos - 3 * pixelHeight, yPos + 13 * pixelHeight, pixelHeight, pixelHeight * 2);
        g.setColor(suitColors[0]);
        g.fillRect(xPos - pixelHeight, yPos + 13 * pixelHeight, pixelHeight * 4, pixelHeight);
        g.setColor(suitColors[2]);
        g.fillRect(xPos + 3 * pixelHeight, yPos + 13 * pixelHeight, pixelHeight * 3, pixelHeight);
        g.setColor(suitColors[0]);
        g.fillRect(xPos + 6 * pixelHeight, yPos + 13 * pixelHeight, pixelHeight * 3, pixelHeight);  

        // Row 15
        g.fillRect(xPos - 2 * pixelHeight, yPos + 14 * pixelHeight, pixelHeight * 5, pixelHeight);
        g.setColor(suitColors[1]);
        g.fillRect(xPos + 3 * pixelHeight, yPos + 14 * pixelHeight, pixelHeight, pixelHeight);
        g.setColor(suitColors[2]);
        g.fillRect(xPos + 4 * pixelHeight, yPos + 14 * pixelHeight, pixelHeight, pixelHeight);
        g.setColor(suitColors[0]);
        g.fillRect(xPos + 5 * pixelHeight, yPos + 14 * pixelHeight, pixelHeight * 3, pixelHeight);
        g.setColor(suitColors[1]);
        g.fillRect(xPos + 8 * pixelHeight, yPos + 14 * pixelHeight, pixelHeight, pixelHeight);

        // Rows 16 + 17
        g.setColor(suitColors[0]);
        g.fillRect(xPos - 3 * pixelHeight, yPos + 15 * pixelHeight, pixelHeight * 13, pixelHeight * 2);
        g.setColor(suitColors[1]);
        g.fillRect(xPos - pixelHeight, yPos + 15 * pixelHeight, pixelHeight * 2, pixelHeight);
        g.setColor(suitColors[2]);
        g.fillRect(xPos + 2 * pixelHeight, yPos + 15 * pixelHeight, pixelHeight, pixelHeight * 3);
        g.setColor(suitColors[1]);
        g.fillRect(xPos + 6 * pixelHeight, yPos + 15 * pixelHeight, pixelHeight, pixelHeight * 2);
        g.fillRect(xPos + 8 * pixelHeight, yPos + 15 * pixelHeight, pixelHeight, pixelHeight);
        g.fillRect(xPos, yPos + 16 * pixelHeight, pixelHeight, pixelHeight);
        g.fillRect(xPos + 4 * pixelHeight, yPos + 16 * pixelHeight, pixelHeight * 2, pixelHeight);

        // Row 18
        g.setColor(suitColors[0]);
        g.fillRect(xPos - 2 * pixelHeight, yPos + 17 * pixelHeight, pixelHeight * 11, pixelHeight);
        g.setColor(suitColors[2]);
        g.fillRect(xPos + 2 * pixelHeight, yPos + 17 * pixelHeight, pixelHeight, pixelHeight);

        //Overlapping Shirt
        drawPixels(5, 13, 1, 2, pantColors[0], g);
        drawPixels(6, 12, 1, 2, pantColors[0], g);
        drawPixels(6, 11, 1, 1, pantColors[1], g);
        drawPixels(7, 11, 1, 2, pantColors[0], g);
        drawPixels(8, 10, 1, 1, pantColors[0], g);
    }

    public void drawPants(Graphics g)
    {                                                        
        drawPixels(0, 18, 9, 8, pantColors[0], g);
        drawPixels(3, 18, 5, 5, pantColors[1], g);
        drawPixels(4, 18, 3, 1, pantColors[2], g);
        drawPixels(3, 19, 2, 3, pantColors[2], g);
        drawPixels(0, 23, 2, 3, pantColors[1], g);
        drawPixels(2, 22, 1, 1, pantColors[2], g);
        drawPixels(1, 23, 1, 1, pantColors[2], g);
        drawPixels(0, 24, 1, 1, pantColors[2], g);
        drawPixels(8, 17, 1, 2, pantColors[1], g);
        drawPixels(6, 19, 1, 1, pantColors[2], g);
        drawPixels(2, 21, 1, 1, pantColors[1], g);
        drawPixels(1, 22, 1, 1, pantColors[1], g);
        drawPixels(2, 23, 1, 1, pantColors[1], g);
        drawPixels(0, 20, 9, 1, beltColors[0], g);
        drawPixels(7, 20, 1, 1, beltColors[1], g);
        drawPixels(7, 22, 1, 1, beltColors[1], g);
        drawPixels(6, 21, 1, 1, beltColors[1], g);
        drawPixels(8, 21, 1, 1, beltColors[1], g);
        drawPixels(7, 21, 1, 1, beltColors[2], g);
    }

    public void drawHat(Graphics g)
    {
        //Rows 2 - 4
        drawPixels(-1, 1, 11, 1, hatColors[0], g);
        drawPixels(-1, 2, 11, 2, hatColors[2], g);
        drawPixels(0, 2, 10, 1, hatColors[3], g);
        drawPixels(6, 1, 4, 1, hatColors[1], g);
        for(int i = 4; i < 9; i+=2)
        {
            drawPixels(i, 2, 1, 1, hatColors[4], g);
        }

        drawPixels(1, 2, 2, 3, hatColors[0], g);
        drawPixels(1, 2, 2, 1, hatColors[1], g);
        drawPixels(1, 5, 1, 1, hatColors[0], g);
    }

    public void drawShoes(Graphics g) 
    {
        drawPixels(0, 26, 9, 1, shoeColors[0], g);
        drawPixels(0, 27, 9, 2, shoeColors[1], g);
        drawPixels(1, 27, 3, 1, shoeColors[2], g);
        drawPixels(5, 27, 3, 1, shoeColors[2], g);
        drawPixels(4, 25, 5, 1, shoeColors[0], g);
        drawPixels(6, 24, 3, 1, shoeColors[0], g);
    }

    @Override
    public void drawVillager(Graphics g) 
    {
        drawFace(g);
        drawHat(g);
        drawSuit(g);
        drawPants(g);
        drawShoes(g);
    }

}
