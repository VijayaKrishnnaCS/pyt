import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MinimumUniqueArraySum {

	private static Pattern pattern;
	private static Scanner sc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		System.out.println("Minimum Unique Array Sum Finder");
		pattern = Pattern.compile("\\d+");
		sc = new Scanner(System.in);
		
		while (true) {
			findMinimumUniqueArraySum();
			System.out.println("If you want to test again enter 'Y' in the console");
			if (!"Y".equalsIgnoreCase(sc.nextLine().trim())) {
				System.out.println("Program control exiting.....");
				break;
			}
		}
		
		} finally {
			if (null != sc)	sc.close();
		}
	}

	private static void findMinimumUniqueArraySum() {
		System.out.println("Enter your input below:");

		String inputData = "";
		int arrayLen = 0, minUniqueSumCount = 0;
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean> ();
		
		// Do input validation and sanitization here
		while (true) {
			inputData = sc.nextLine().trim();
			
			if (pattern.matcher(inputData).matches()) {
				arrayLen = Integer.parseInt(inputData);
				if (arrayLen < 0 || arrayLen > 2000) {
					System.out.println("Enter the array length within this specified range. 1 <= length <= 2000");
				} else {
					arrayLen = Integer.parseInt(inputData);
					break;
				}
			} else {					
				System.out.println("Enter the array length as a valid iteger only");
			}
		}
		
		for (int index = 0; index < arrayLen; index++) {
			outer : while (true) {
				inputData = sc.nextLine().trim();
				
				if (pattern.matcher(inputData).matches()) {
					int tempNum = Integer.parseInt(inputData);
					
					inner : while (true) {
						if (!map.containsKey(tempNum)) {
							map.put(tempNum, true);
							minUniqueSumCount += tempNum;
							break inner;
						} else {
							++tempNum;
						}
					}
					
					break outer;
				} else {					
					System.out.println("Enter the array input data as a valid iteger only");
				}
			}
		}
		
		System.out.println("minUniqueSumCount : " + minUniqueSumCount);
	}
}
