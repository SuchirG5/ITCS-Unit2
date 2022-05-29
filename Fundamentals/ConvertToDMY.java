import java.util.*;

public class ConvertToDMY 
{
    public static void main(String[] args)
    {
       
        Scanner s = new Scanner(System.in);
        System.out.print("Enter total days: ");
        int days = s.nextInt();
        int years = days/365;
        int months = (days%365)/30;
        int remainingDays = ((days%365)%30);

        System.out.println(years + " years, " + months + " months, " + remainingDays + " days");
    }
}
