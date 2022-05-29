public class RandomNumbers 
{
    public static void main(String[] args)
    {
        diceGame();
        coinFlip(50);
        coinGame();
    }

    public static void diceGame()
    {
        int dice = (int) (Math.random()*12) + 1;
        if(dice <=6)
        {
            System.out.println("you lose");
        }
        else if( dice == 7)
        {
            System.out.println("You win a prize");
        }
        else
        {
            System.out.println("you win");
        }
        

    }

    public static void coinFlip(int num)
    {
        int h = 0;
        int t = 0;
        for(int i = 0; i < num; i++)
        {
            int r = (int) (Math.random()*2)+1;
            if(r == 1)
            {
                h++;
            }
            else if(r == 2)
            {
                t++;
            }
        }
        System.out.println("Heads: " + h + " Tails: " + t);
    }

    public static void coinGame()
    {
      
        int c1;
        int c2;
        int count1 = 0;
        int count2 = 0;
        String coin1;
        String coin2;
        int i = 0;
        while(true)
        {
            c1 = (int)(Math.random()*2)+1;
            c2 = (int)(Math.random()*2)+1;
            i++;

            if(c1 == 1)
            {
                 coin1 = "heads";
            }
            else
            {
                 coin1 = "tails";
            }

            if(c2 == 1)
            {
                coin2 = "heads";
            }
            else
            {
                coin2 = "tails";
            }



            if(c2 == 1)
            {
                count2++;
            }
            else if(c2 == 2 && count2 >=0)
            {
                count2 =0;
            }


            if (c1 == 1)
            {
                count1++;
            }
            else if(c1 == 2 && count1>=0)
            {
                count1 =0;
            }

            System.out.println(i+" Coin 1: " + coin1 + " Coin 2: " + coin2);
            
            if(count1 == 3)
            {
                System.out.println("Coin 1 wins");
                break;
            }
            else if (count2 == 3)
            {
                System.out.println("Coin 2 wins");
                break;
            }
        }
    }
}
