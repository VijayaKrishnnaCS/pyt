import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CountingDistinctPairs {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				countDistinctPairs(sc);
				System.out.println("If you want to test again enter 'Y' in the console");
				if (!"Y".equalsIgnoreCase(sc.nextLine().trim())) {
					System.out.println("Program control exiting.....");
					break;
				}
			}
		}
	}

	private static void countDistinctPairs(Scanner sc) {
		System.out.println("CountingDistinctPairs:: Enter your input below.");
		
		int inputArrayCount = Integer.parseInt(sc.nextLine().trim());
		int distinctPairCount = 0, diff = 0;
		
		HashSet<Integer> set = new HashSet<Integer>();
		for (int n = 0; n < inputArrayCount; n++) {
			set.add(Integer.parseInt(sc.nextLine().trim()));
		}
		
		diff = Integer.parseInt(sc.nextLine().trim());
		
		Integer[] uniqueArray = (Integer[]) set.toArray(new Integer[0]);
		// Sort the array first
		Arrays.sort(uniqueArray);
		
		 for (int i = 0; i < uniqueArray.length - 1; i++) {
			 if (binarySearch(uniqueArray, i + 1, uniqueArray.length - 1, uniqueArray[i] + diff) != -1) {
				 distinctPairCount++; 
			 }
		 }
		 System.out.println(distinctPairCount);
	}
	private static int binarySearch (Integer arr[], int low, int high, int x) { 
		if (high >= low)  { 
			int mid = low + (high - low) / 2; 
			if (x == arr[mid]) return mid; 
			if (x > arr[mid]) return binarySearch(arr, (mid + 1), high, x); 
			else return binarySearch(arr, low, (mid - 1), x); 
		} 
		return -1; 
	} 
}
