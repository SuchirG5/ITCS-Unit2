import java.util.Scanner;

public class StringBasics 
{

	/* Given a name, return a greeting.
	 * Input: Matt
	 * Output: Hello Matt! Have a nice day!
	 */
	public static String greet(String name) 
    {
        return "Hello " + name + "! Have a nice day!"; 
	
    }
	
	/* Given a String, return the word/sentence reversed
	 * Input: Hello!
	 * Output: !olleH
	 */
	public static String reverse(String s) {
		
        String output = "";
        for(int i = s.length()-1; i >= 0; i--)
        {
            output += s.charAt(i);
        }
		return output; //placeholder
	}
	
	/* Given a full name return it in the format Last, First
	 * Input: Wayde Byard
	 * Output: Byard, Wayde
	 */
	public static String lastFirst(String fullName) 
    {
		
		return fullName.substring(fullName.indexOf(" ") + 1) + ", " + fullName.substring(0, fullName.indexOf(" "));
	}
	
	/* Given a full name return the proper initials
	 * Input: Albus Percival Wulfric Brian Dumbledore
	 * Output: APWBD
	 */
	public static String initials(String fullName) 
    {
        Character c = fullName.charAt(0);
        String initials = c.toString();
		for(int i = 0; i < fullName.length() ; i++)
        {
            if(fullName.charAt(i) == ' ')
            {
                initials += fullName.charAt(i + 1);
            }
        }
        


		return initials; 
        
	}
	
	/* Given a String, return the number of vowels it contains (AEIOU)
	 * Hint: convert the String to upper or lower case first because a != A
	 * Input: Hello
	 * Output: 2
	 */
	public static int countVowels(String s) 
    {
        int count = 0;
		for(int i = 0; i<s.length(); i++)
        {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
            || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' 
            || s.charAt(i) == 'O' || s.charAt(i) == 'U' )
            {
                count++;
            }
        }
		return count;
	}
	
	public static void main(String[] args) 
	{
		/* Ask the user to enter a name via Scanner
		 * Run all of your methods with that name and print the results
		 * Repeat the above until the user enters "quit"		 * 
		 */
		
        Scanner s = new Scanner(System.in);
		while(!s.nextLine().equals("quit"))
		{
			System.out.print("Enter a name: ");
			String name = s.nextLine();
			System.out.println(greet(name));
			System.out.println(reverse(name));
			System.out.println(lastFirst(name));
			System.out.println(initials(name));
			System.out.println(countVowels(name));
		}


		

	}

}