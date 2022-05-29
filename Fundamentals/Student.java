import java.util.*;
public class Student 
{
    private static ArrayList<Integer> grades;

    public Student()
    {
        grades = new ArrayList<Integer>();
    }

    public void displayGrades()
    {
        System.out.println(grades);
    }

    public void addGrades()
    {
        Scanner s = new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter a grade: ");
            int a = s.nextInt();
            if(a != -1)
            {
                grades.add(a);
            }  
            else
            {
                break;
            }      
        }
    }

    public int getAverage()
    {
        int sum = 0;
        for(int i = 0; i < grades.size(); i++)
        {
            sum+=grades.get(i);
        }
        return sum/grades.size();
    }

    public void removeLowestGrade()
    {
        int lowest = grades.get(0);
        for(int i = 0; i < grades.size(); i++)
        {
            if(grades.get(i) < lowest)
            {
                lowest = grades.get(i);
            }
        }
        grades.remove(grades.indexOf(lowest));
    }

    public void roundUpGrades()
    {
        for(int i = 0; i<grades.size(); i++)
        {
            if(grades.get(i) == 69 || grades.get(i) == 79 || grades.get(i) == 89)
            {
                grades.set(i, (grades.get(i) + 1));
            }
        }

    }

    public static void main(String[] args) 
    {
        Student s = new Student();
        s.addGrades();
        s.removeLowestGrade();
        s.roundUpGrades();
        
        s.displayGrades();
        System.out.println("Average: " + s.getAverage());
        
    }
    //86, 94, 79, 55, 89, 95
}
