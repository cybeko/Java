package hw1_intro;

public class Program {

	public static void main(String[] args) {
		int[] nums = {1,8,5,7,9,3};
		
		//task 1: Given an integer array, find and print the maximum value.
		
		int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        System.out.println("\nMax value = " + max);
        
    	//task 2: Given an integer array, print its elements in reverse order.
      
        System.out.print("\nReversed array: ");
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.print(nums[i] + " ");
        }
        
		// task 3: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

		int target = 12;

		for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println("\nId: " + i + ", " + j);
                    System.out.println("Value: " + nums[i] + " + " + nums[j]);
                }
            }
        }
		
	}

}
