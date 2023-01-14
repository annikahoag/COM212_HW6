/**
 * Class that implements recursive methods to complete various specified tasks
 * @author Annika Hoag 
 * @since 11/6/2022
 */ 
public class HW6{
	//no constructor needed, uses default constructor to create an instance of HW6

	/**
	 * PART 1: Recursively computes the factorial of a given integer
	 * @param n -> int who's factorial will be computed
	 * @return factorial of given n 
	 * @since 11/6/2022
	 */ 
	public int factorial(int n){

		//base case where n=1, 1!=1
		if (n==1){
			return 1;

		/** 
		 * recursive case:
		 * re-call method w/ n-1, 
		 * return n multiplied by the return value of the recall
		 */ 	
		}else{
			return n * factorial(n-1);	
		}

	}


	/**
	 * PART 2: Searches for a given integer in an array of integers using binary search
	 * @param target -> int to be searched for 
	 * @param nums[] -> array of ints in which target will be searched for 
	 * @return the return value of the corresponding helper method 
	 * @since 11/6/2022
	 */ 
	public int binSearch(int target, int[] nums){
		return this.binSearchHelp(target, nums, 0, nums.length-1);
	}


	/**
	 * PART 2: Recursively searches for a given integer in an array of integers using binary search
	 * Note: For my recursive algorithm the method signature required the indices of the upper and lower
	 * 	bounds of the interval currently being searched, which is why I chose to use a helper method
	 * @param target -> int to be searched for 
	 * @param nums[] -> array of ints that target will be searched for in
	 * @param low -> index of lower bound of interval that's currently being searched for target
	 * @param high -> index of upper bound of interval that's currently being searched for target
	 * @return index of target if it's in nums[], -1 if not found
	 * @since 11/6/2022
	 */ 
	private int binSearchHelp(int target, int[] nums, int low, int high){

		//calculate midpoint of interval
		int mid = (high + low) / 2;


		//base case, target is found
		if (nums[mid] == target){
			return mid;
		
		//recursive case(s)
		}else{

			//if low>high that means target isn't in nums[]
			if (low>high){
				return -1;
			
			/**
			 * if target is less than nums[mid] then it must be on the left half,
			 * re-call method with low being the same, but high being 1 less than the mid
			 */ 
			}else if (target < nums[mid]){
				return binSearchHelp(target, nums, low, mid-1);
			

			/**
			 * otherwise target must be greater than nums[mid], must be in right half,
			 * re-call method with lower bound being 1 more than the mid and high being the same
			 */ 
			}else{
				return binSearchHelp(target, nums, mid+1, high);
			}

		}

	}//closes binSearchHelp


	/** 
	 * PART 3: Recursively reverses the values of an array in place, 
	 * 	prints the array as it reverses instead of returning the reverse
	 * @param nums[] -> array whose values will be reversed
	 * @since 11/6/2022
	 */ 
	public void reverseArr(int nums[]){

		//base case, you have reached the beginning of the array, print value at 1st index
		if (nums.length == 1){
			System.out.print(nums[0]);
		
		//recursive case
		}else{
			/**
			 * Create a temporary array with a length 1 less than nums[],
			 * 	Fill temp[] with parallel values of nums[] until temp[] is full
			 */ 
			int temp[] = new int[nums.length-1];
			for (int i=0; i<temp.length; i++){
				temp [i] = nums[i];
			}

			//print last value of nums[]
			System.out.print(nums[nums.length-1] + " ");

			//re-call method with temp. array containing 1 less value than orig. nums[]
			reverseArr(temp);
		}
	}//closes reverseArr


	/**
	 * PART 4: Recursively computes the product of 2 positive integers using only addition
	 * @param m -> 1 integer to be multiplied, int that will be added to itself 
	 * @param n -> 1 integer to be multiplied, # of times m still needs to add to itself 
	 * @return product of m and n
	 * @since 11/7/2022
	 */ 
	public int product(int m, int n){

		//base case, m needs to add to itself 0 more times
		if (n==0){
			return 0;

		//recursive case	
		}else{
			/**
			 * Return sum of m and the result of re-calling the method with n-1 instead of n,
			 * 	n represents the # of times m still has to be added to itself so it needs to decrease
			 */ 
			return m + product(m, n-1);
		}

	}


	/**
	 * PART 5: Recursively reverses a given String
	 * @param s -> String to be reversed
	 * @return the reverse of s
	 * @since 11/7/2022
	 */ 
	public String reverseString(String s){

		//base case, we've stored all but the 1st char of s in the stack, return 1st char 
		if (s.length() == 1){
			return s;
		
		//recursive case
		}else{
			/**
			 * Return the last char in s using charAt String method and Character conversion to a String,
			 * 	and the result of re-calling the method with a substring of the orig. String excluding the last char
			 */ 
			return Character.toString(s.charAt(s.length()-1)) + reverseString(s.substring(0, s.length()-1));
		}
	}


	/**
	 * PART 6: Recursively figures out if a given String is a palindrome, 
	 * 	a palindrome is defined as a String that is equal to its reverse
	 * @param s -> String to be evaluated to see if it's a palindrome
	 * @return true if s is a palindrome, false if s is not a palindrome
	 * @since 11/7/2022
	 */ 
	public boolean isPalindrome(String s){

		/**
		 * base case, if s is either length 1 or emtpy that means it must be a palindrome,
		 * 	if we get to this point it means all the other characters in s have matched
		 */ 
		if (s.length()==1 || s.length()==0){
			return true;
		
		//recursive case
		}else{

			//test if the chars at the beginning and end of s match
			if (s.charAt(0) != s.charAt(s.length()-1)){
				//if they don't match s can't be a palindrome so we're done
				return false;
			
			}else{
				/**
				 * if they do match, re-call method with a substring excluding those 2 chars,
				 * 	in order to see if the rest of s is a palindrome
				 */ 
				return isPalindrome(s.substring(1, s.length()-1));
			}

		}

	}//closes isPalindrome



	/** 
	 * PART 7: Main method to test other methods in HW6 class
	 * @since 11/6/2022
	 */ 
	public static void main(String[] args){

		HW6 test = new HW6(); //instance of HW6 to call methods

		int factResult;			//variable to set to return value of factorial()

		int binSearchResult;	//variable to set to return value of binSearch()
		int [] nums = {1, 2, 5, 6, 7, 8, 10, 11, 12, 13};	//hard-coded array to test binSearch()

		int [] nums2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};		//hard-coded array to test reverseArr()

		int prodResult;			//variable to set to return value of product()

		String sParam = "pots&pans";		//String to test reverseString()
		String sParam2 = "annika";			//String to test reverseString() and isPalindrome()
		String sParam3 = "ConnCollege";		//String to test reverseString()
		String sResult;						//variable to be set to return value of reverseString()	

		String sParam4 = "racecar";			//String to test isPalindrome()
		String sParam5 = "gohangasalamiimalasagnahog"; //String to test isPalindrome() 
		String sParam6 = "carter";			//String to test isPalindrome()
		boolean isPalindromeResult; 		//variable to be set to return value of isPalindrome()

		

		//Testing factorial() by calling it with an int and printing the result
		factResult = test.factorial(6);
		System.out.println("\n6! = " + factResult);

		factResult = test.factorial(12);
		System.out.println("12! = " + factResult);

		factResult = test.factorial(8);
		System.out.println("8! = " + factResult);


		/**
		 * Testing binSearch() by calling it with both numbers in the array and not in the array,
		 * Displays result of calling binSearch(), also displays array for user convenience
		 */ 
		System.out.println("\nHere is the array we will be searching: ");
		for (int i=0; i<nums.length; i++){
			System.out.print(nums[i] + " ");
		}

		binSearchResult = test.binSearch(10, nums);
		if (binSearchResult != -1){
			System.out.println("\nFound 10 at index " + binSearchResult);
		}else{
			System.out.println("10 was not found.");
		}

		binSearchResult = test.binSearch(4, nums);
		if (binSearchResult != -1){
			System.out.println("Found 4 at index " + binSearchResult);
		}else{
			System.out.println("4 was not found.");
		}

		binSearchResult = test.binSearch(9, nums);
		if (binSearchResult != -1){
			System.out.println("Found 9 at index " + binSearchResult);
		}else{
			System.out.println("9 was not found.");
		}

		binSearchResult = test.binSearch(13, nums);
		if (binSearchResult != -1){
			System.out.println("Found 13 at index " + binSearchResult);
		}else{
			System.out.println("13 was not found.");
		}

		binSearchResult = test.binSearch(3, nums);
		if (binSearchResult != -1){
			System.out.println("Found 3 at index " + binSearchResult);
		}else{
			System.out.println("3 was not found.");
		}

		binSearchResult = test.binSearch(2, nums);
		if (binSearchResult != -1){
			System.out.println("Found 2 at index " + binSearchResult);
		}else{
			System.out.println("2 was not found.");
		}


		/**
		 * Testing reverseArr() by displaying the hard coded array for user convenience,
		 * 	then calling the method to see if it correctly prints the reverse 
		 */ 
		System.out.println("\nHere is the array before reversing it: ");
		for (int i=0; i<nums2.length; i++){
			System.out.print(nums2[i] + " ");
		}
		System.out.println("\nHere is the array after reversing it: ");
		test.reverseArr(nums2);
		System.out.println();


		//Testing product() by calling it with 2 ints and printing the result
		prodResult = test.product(3, 2);
		System.out.println("\n3*2 = " + prodResult);

		prodResult = test.product(4, 13);
		System.out.println("4*13 = " + prodResult);

		prodResult = test.product(15, 4);
		System.out.println("15*4 = " + prodResult);

		prodResult = test.product(6, 11);
		System.out.println("6*11 = " + prodResult);

		prodResult = test.product(1, 1);
		System.out.println("1*1 = " + prodResult);

		prodResult = test.product(305, 0);
		System.out.println("305*0 = " + prodResult);


		/**
		 * Testing reverseString() by displaying each of the 3 hard-coded Strings, 
		 * 	and displaying the results of calling reverseString() w/ those Strings
		 */ 
		System.out.println("\nHere is the 1st String before reversal: " + sParam);
		sResult = test.reverseString(sParam);
		System.out.println("Here is the String after reversal: " + sResult);

		System.out.println("Here is the 2nd String before reversal: " + sParam2);
		sResult = test.reverseString(sParam2);
		System.out.println("Here is the String after reversal: " + sResult);

		System.out.println("Here is the 3rd String before reversal: " + sParam3);
		sResult = test.reverseString(sParam3);
		System.out.println("Here is the String after reversal: " + sResult);


		//Testing isPalindrome() by display the result of calling it with hard-coded Strings
		isPalindromeResult = test.isPalindrome(sParam4);
		if (isPalindromeResult){
			System.out.println("\n" + sParam4 + " is a palindrome.");
		}else{
			System.out.println("\n" + sParam4 + " is not a palindrome.");
		}

		isPalindromeResult = test.isPalindrome(sParam2);
		if (isPalindromeResult){
			System.out.println(sParam2 + " is a palindrome.");
		}else{
			System.out.println(sParam2 + " is not a palindrome.");
		}

		isPalindromeResult = test.isPalindrome(sParam6);
		if (isPalindromeResult){
			System.out.println(sParam6 + " is a palindrome.");
		}else{
			System.out.println(sParam6 + " is not a palindrome.");
		}

		isPalindromeResult = test.isPalindrome(sParam5);
		if (isPalindromeResult){
			System.out.println(sParam5 + " is a palindrome.");
		}else{
			System.out.println(sParam5 + " is not a palindrome.");
		}

	}//closes main method

}//closes HW6 class