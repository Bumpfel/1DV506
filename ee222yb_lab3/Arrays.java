package ee222yb_lab3;

public class Arrays {

	public static void main(String[] args) {
		int[] n = { 9, 2, 5, 7, 0 };
			
		System.out.println("Sum of the array elements is: " + sum(n));
		
		String str = Arrays.toString(n);
		System.out.println("n = " + str + "\n");
		
		int nw = 5;
		int[] newArray = addN(n, nw);
		System.out.println(toString(newArray) + " - made a copy of array n and added the value " + nw + " to every element");
		
		System.out.println(toString(reverse(n)) + " - reversed a copy of array n\n");
		
		int q = 5;
		System.out.println("There is a " + q + " in the array n - " + hasN(n, q));
		
		int replaceWhat = 5;
		int replaceWith = 100;
		replaceAll(n, replaceWhat, replaceWith);
		System.out.println("n = " + toString(n) + " - replaced all " + replaceWhat + "s with " + replaceWith + "s\n");
		
		int[] nSorted = sort(n);
		System.out.println(toString(nSorted) + " - sorted a copy of array n");
		
		int[] subSeq = { 2, 100, 7 };
		System.out.println("The subsequence { " + toString(subSeq) + " } exists in the array n { " + toString(n) + " } - " + hasSubsequence(n, subSeq));
	}

	/**
	 * Counts the sum of all the elements in the array
	 * @param arr - the int array
	 * @return total sum of array integers
	 */
	private static int sum(int[] arr) {
		int total = 0;
		for(int value : arr)
			total += value;
		return total;
	}
	
	/**
	 * Puts the array in a printable string, separated by comma
	 * @param arr - integer array
	 * @return string "arrVal1, arrVal2, ..., arrValN"
	 */
	private static String toString(int[] arr) {
		String print = new String();
		for(int i = 0; i < arr.length; i ++) {
			if(i != 0)
				print += ", ";
			print += arr[i];
		}
		return print;
	}
	
	/**
	 * Creates a copy of the array, and adds 5 to each element
	 * @param arr - integer array
	 * @param n - the value to be added to each element
	 * @return new array
	 */
	private static int[] addN(int[] arr, int n) {
		int[] newArray = new int[arr.length];
		for(int i = 0; i < arr.length; i ++) {
			newArray[i] = arr[i] + n;
		}
		return newArray;
	}
	
	/**
	 * Creates a copy of the array and reverses its order
	 * @param arr - integer array
	 * @return a reversed array, leaving the old one intact
	 */
	private static int[] reverse(int[] arr) {
		int[] reversedArray = new int[arr.length];
		
		for(int index = 0 ; index < arr.length; index ++) {
			int reversedIndex = arr.length - 1 - index;
			reversedArray[reversedIndex] = arr[index];
		}
		return reversedArray;
	}
	
	/**
	 * Checks if the array contains the integer n
	 * @param arr - integer array to be searched through
	 * @param n - requested value
	 * @return boolean
	 */
	private static boolean hasN(int[] arr, int n) {
		for(int value : arr) {
			if(value == n)
				return true;
		}
		return false;
	}
	
	/**
	 * Replaces all the old values in the array with the nw value
	 * @param arr - the array. will be modified
	 * @param old - value to be replaced
	 * @param nw - value to replace the old value
	 */
	private static void replaceAll(int[] arr, int old, int nw) {
		for(int i = 0; i < arr.length; i ++) {
			if(arr[i] == old)
				arr[i] = nw;
		}
	}
	
	/**
	 * Creates a new array and sorts it using selection sort, leaving the old array as it were
	 * @param arr - the array to be sorted
	 * @return new sorted array, 
	 */
	private static int[] sort(int[] arr) {
		int[] sortedArray = new int[arr.length];
		
		// Copies the array
		for(int i = 0; i < arr.length; i ++) {
			sortedArray[i] = arr[i];
		}
		
		// Selection sort
		for(int i = 0; i < sortedArray.length; i ++) {
			int smallestIndex = i;
			
			for(int compareIndex = i + 1; compareIndex < sortedArray.length; compareIndex ++) {
				if(sortedArray[compareIndex] < sortedArray[smallestIndex]) {
					smallestIndex = compareIndex;
				}
			}
			
			int buffer = sortedArray[i];
			sortedArray[i] = sortedArray[smallestIndex];
			sortedArray[smallestIndex] = buffer;
		}
		return sortedArray;
	}
	
	/**
	 * Returns true if the subsequence is found in the array, otherwise false
	 * @param arr - array to be searched through
	 * @param sub - array of integers to be subsequently compared to the array arr
	 * @return boolean
	 */
	private static boolean hasSubsequence(int[] arr, int[] sub) {
		int counter = 0;
		
		for(int i = 0; i < arr.length; i ++) {
			if(sub.length - counter > arr.length - i) // Stops searching if number of objects still needs to be found is greater than number of elements left to compare with
				return false;
			else if(sub[counter] == arr[i]) { // using the found counter variable as index for the subsequence array
				counter ++;
				if(counter == sub.length)
					return true;
			}
			else
				counter = 0;
		}
		return false;
	}

}
