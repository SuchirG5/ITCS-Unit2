public class PasswordComplexity 
{

	public static boolean isComplex(String pass) 
    {
        int capital = 0;
        int lowerCase = 0;
        int specialChars = 0;
        boolean containsPassword = false;
        for(int j = 0; j <= pass.length(); j++)
        {
            for(int k = 0; k <= pass.length(); k++)
            {
                if(j<=k)
                {
                    if(pass.substring(j, k).toLowerCase().equals("password"))
                    {
                        containsPassword = true;
                    }
                }
            }
        }

		if(pass.length()>8 && !containsPassword)
        {
            for(int i = 0; i<pass.length(); i++ )
            {
                if(pass.charAt(i) >= 33 && pass.charAt(i) <= 64)
                {
                    specialChars++;
                }
                else if(pass.charAt(i) >= 65 && pass.charAt(i) <= 90)
                {
                    capital++;
                }
                else if(pass.charAt(i) >= 97 && pass.charAt(i) <= 122)
                {
                    lowerCase++;
                }
            }
        }

        if(lowerCase>0 && capital>0 && specialChars > 0)
        {
            return true;
        }
		return false; //placeholder
	}
	
	public static void main(String[] args) 
    {
		// Test cases
		System.out.println(isComplex("bigTurtle44")); //true 
		System.out.println(isComplex("@paSSpaSS?")); //true
		System.out.println(isComplex("myPassword123!")); //false
		System.out.println(isComplex("pAc!")); //false
		System.out.println(isComplex("FlyingOrange")); //false
		System.out.println(isComplex("turtles=true")); //false
	}

}