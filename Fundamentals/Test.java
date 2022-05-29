public class Test 
{
    public static void main(String[] args) 
    {
       
    }
    








    public static void makeChange(int c)
    {
        int q = (c/25);
        int d = ((c%25) / 10);
        int n = (((c%25)%10) / 5);
        int p = (((c%25)%10)%5);
        System.out.println(q);
        System.out.println(d);
        System.out.println(n);
        System.out.println(p);
    }

    public static void makeC(int c) {
        int q = 0;
        int d = 0;
        int n = 0;
        int p = 0;
        int r = 0;

        q = c/25;
        r = c%25;
        d = r/10;
        r = r%10;
        n = r/5;
        r = r%5;
        p = r;
        System.out.println(q);
        System.out.println(d);
        System.out.println(n);
        System.out.println(p);

        
    }

    public static void processImage(int[][] p)
    {
        for(int i = 0; i < p.length - 2; i++)
        {
            for(int j =0; j < p[0].length - 2; j++)
            {
               p[i][j] -= p[i + 2][j + 2];

               if (p[i][j] < 0) {
                   p[i][j] = 0;
               }
            }
        }
        for(int i = 0; i < p.length; i++)
        {
            for(int j = 0; j < p[i].length; j++)
            {
                System.out.print(p[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static String fibCypher(char key, String msg) 
    {
        int offset = 0;
        int[] fibonacci = new int[30];
        String newMsg = "";
        int[] code = new int[msg.length()];
        fibonacci[0] = 1;
        fibonacci[1] = 2;
        for(int f = 2; f < fibonacci.length; f++)
        {
            fibonacci[f] = fibonacci[f-1] + fibonacci[f-2];
        }

        for(int i = 0; i < msg.length(); i++)
        {   
            offset = (key + fibonacci[i]);
            if(key+fibonacci[i] > 122)
            {
                offset -= 26;
            }
            code[i] = offset + (msg.charAt(i) + 0);
        }

        for(int i = 0; i < code.length; i++)
        {
            newMsg += code[i] + " "; 
        }
        return newMsg;
    }

    public static int[] over20(int[] input)
    {
        int size = 0;
        for(int i = 0; i<input.length; i++)
        {
            if(input[i]>20)
            {
                size++;
            }
        }
        int[] output = new int[size];
        int count = 0;
        for(int j = 0; j < input.length; j++)
        {
            if(input[j]>20)
            {
                output[count] = input[j];
                count++;
            }
        }
        return output;
    }
}