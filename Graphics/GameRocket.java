public class GameRocket extends Rocket 
{
    public GameRocket(int x, int y, int speed, int width, int height)
    {
        super(x, y, speed, width, height);
    }

    public void moveRight(int speed)
    {
        setX((int)getXPos()+speed);
    }

    public void moveLeft(int speed)
    {
        setX((int)getXPos()-speed);
    }
}
