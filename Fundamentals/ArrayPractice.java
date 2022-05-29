//ITCS - Array Practice
public class ArrayPractice 
{

	private static void printArray(int[] nums) 
    {
        for(int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i]+ " ");
        }
        System.out.print("\n");
	}
	
	private static void swapFirstLast(int[] nums) 
    {
        int a = nums[nums.length-1];
        nums[nums.length-1] = nums[0];
        nums[0] = a;
        for(int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
		
	}
	
	private static double findAverage(int[] nums)
    {
        double sum = 0;
		for(int i = 0; i < nums.length; i++)
        {
            sum+= nums[i];
            
        }
        return sum/nums.length;
	}

	private static long findSmallest(int[] nums) 
    {
		long min = 1000000000;
        for(int i = 0; i < nums.length; i++)
        {
            min = Math.min(min, nums[i]);
        }
		return min;
	}

	private static boolean isPresent(String[] words, String target) {
		
        for(int i = 0; i < words.length; i++)
        {
            if(words[i].equals(target))
            {
                return true;
            }
        }

		return false; //placeholder
	}
	public static void main(String[] args) {
		//Generates a test array of variable size and values. 
		int[] testArray = new int[(int) (Math.random() * 7 + 3)];
		for (int i = 0; i < testArray.length; i++) {
			testArray[i] = (int) (Math.random() * 25);
		}
		//sample array of words
		String[] wordsTest = {"The", "wheels", "go", "round", "and", "round"}; 
        String target = "Sus";
		
		printArray(testArray); 
        swapFirstLast(testArray);
        System.out.println(findAverage(testArray));
        System.out.println(findSmallest(testArray));
        System.out.println(isPresent(wordsTest, target));
		

		
	}
	
	/* Optional Extra Challenge. Complete if you finish early. 
	 * Given an array, nums, return true if the elements of the array are in ascending order.
	 * return false otherwise. 
	 * Ex.
	 * {1, 5, 9, 9, 10, 50} -> In order
	 * {9, 3, 5, 10, 50, 25} -> Not In Order
	 * 
	 * Note: you may need to create your own array in main to test this
	 * 		 as the given array will very rarely be in order. 
	 */	
	public static boolean isInOrder(int[] nums) 
    {
        nums[1]++;
		return false;
	}

}