
public class Hamster extends Pet
{
    public String getEyeColor()
    {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor)
    {
        this.eyeColor = eyeColor;
    }

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    private String eyeColor;
    private int speed;
    public Hamster(int age, String name, String breed, String eyeColor)
    {
        super(age, name, breed);
        this.eyeColor = eyeColor;
        int speed = (int)(Math.random()*3)+3;
        if(getBreed().equals("Roborovski Dwarf"))
        {
            speed = (int)(Math.random()*7)+3;
        }
        setAdoptionFee(calculateAdoptionFee());
    }

    public int calculateAdoptionFee()
    {
        int adoptionFee = 7;
        if(getBreed().equals("Roborovski Dwarf"))
        {
            adoptionFee = 10;
        }
        if (eyeColor.equals("red") || eyeColor.equals("pink"))
        {
            adoptionFee +=2;
        }
        return adoptionFee;
    }
}
