public class BingoCard 
{
    private String[][] card = new String[6][5];

    public BingoCard()
    {
        generateCard();
    }

    public void generateCard()
    {
        card[0][0] = "B";
        card[0][1] = "I";
        card[0][2] = "N";
        card[0][3] = "G";
        card[0][4] = "O";
        
        String number;
        String check = "";
        for(int i = 1; i < card.length; i++)
        {
            for(int j = 0; j < card[i].length; j++)
            {
                if(i == 3 && j == 2)
                {
                    card[i][j] = "free";
                }
                else
                {
                    number = (int)((Math.random()*(15) + j*15 + 1)) + "";
                    for(int i2 = 0; i2<card.length; i2++)
                    {
                        for(int j2 = 0; j2<card[i2].length; j2++)
                        {
                            check += card[i2][j2] + "";
                        }
                    }

                    while(check.contains(number))
                    {
                        number = (int)((Math.random()*(15) + j*15 + 1)) + "";
                    }
                    
                    
                    card[i][j] = number;
                }
            }
        }
    }

    public void displayCard()
    {
        for(int i = 0; i < card.length; i++)
        {
            for(int j = 0; j < card[i].length; j++)
            {
               System.out.print(card[i][j] + " \t");
            }
            System.out.println("");
        }
        
    }
}
