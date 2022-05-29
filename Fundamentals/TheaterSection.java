

public class TheaterSection {

	private boolean[][] section;

	//Default constructor completed for you
	public TheaterSection() {
		section = new boolean[5][20];
		int num = 0;
		for (int r = 0; r < section.length; r++) {
			for (int c = 0; c < section[0].length; c++) {
				num = (int) (Math.random() * 4);
				if (num == 0) 
                {
					section[r][c] = true;
				} 
                else 
                {
					section[r][c] = false;
				}
			}
		}
	}

	public TheaterSection(boolean[][] premadeSection) 
    {
        section = new boolean[premadeSection.length][premadeSection[0].length];
        for(int i = 0; i < premadeSection.length; i++)
        {
            for(int j = 0; j < premadeSection[i].length; j++)
            {
                section[i][j] = premadeSection[i][j];
            }
        }
        
	}
	

    public void printSection()
    {
        System.out.println("Seat");
        char c = 'A';
        for(int k = 0; k <= section[0].length; k++)
        {
            if(k==0)
            {
                System.out.print("\t");
            }
            else
            {
                System.out.print(k+"\t");
            }
        }
        System.out.println("");
        System.out.println("");
        for(int i = 1; i < section.length; i++)
        {
            System.out.print("Row " + c + "\t");
            for(int j = 0; j < section[i].length; j++)
            {
                
                if(section[i][j])
                {
                    System.out.print("*\t");
                }
                else
                {
                    System.out.print("x\t");
                }
                
            }
            c++;
            System.out.println("");
            System.out.println("");

        }
    }
	
    public void printAvailable()
    { 
        char c = 'A';
        int count = 0;
        System.out.println("Row\tAvailable Seats");
        System.out.println();
        System.out.println();
        for(int i = 1; i < section.length; i++)
        {
            boolean flag = true;
            System.out.print("Row " + c + "\t");
            for(int j = 0; j < section[i].length; j++)
            {
                
                if(section[i][j])
                {
                    System.out.print((j+1)+ "\t");
                    flag = false;
                    count++;
                }                
            }

            if(flag) 
            {
                System.out.println("No available seats");
            }
            c++;
            System.out.println("");
            System.out.println("");

        }
        System.out.println("Total available seats: " + count);
    }
	

	public static void main(String[] args) {
		//remove comments to enable test cases when ready
		
		boolean[][] example = {{true, true, false}, {false, false, false}};
		TheaterSection test1 = new TheaterSection(example);
		test1.printSection();
		System.out.println();
		test1.printAvailable();
		
		System.out.println();
		
		TheaterSection test2 = new TheaterSection();
		test2.printSection();
		System.out.println();
		test2.printAvailable();
		 
    }
}