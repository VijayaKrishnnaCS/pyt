import java.util.Scanner;

public class SuperStack {
	private static Scanner sc;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
		System.out.println("SuperStack. Enter your input below. To dissolve current stack enter 'exit'.");
		sc = new Scanner(System.in);
		
		while (true) {
			initSuperStack();
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
	
	private static void initSuperStack() throws Exception {
		SuperStackModel<Integer> stack = new SuperStackModel<Integer>();
		String inputStr = "";
		int inputCount = Integer.parseInt(sc.nextLine().trim());
		
		while (inputCount > 0) {
			inputStr = sc.nextLine().trim();
			if (inputStr.contains("pop") || inputStr.contains("POP")) {
				Integer top = stack.pop();
				System.out.println((stack.isEmpty()) ? "EMPTY" : top);
			} else if (inputStr.contains("push") || inputStr.contains("PUSH")) {
				System.out.println(stack.push(new Integer(inputStr.split(" ")[1])));
			} else if (inputStr.contains("inc") || inputStr.contains("INC")) {
				System.out.println(stack.increment(Integer.parseInt(inputStr.split(" ")[1]), 
						(Integer.parseInt(inputStr.split(" ")[2]))));
			} else {
				System.out.println("Entered input is not in the right format. Kindly enter the correct input again.");
				++inputCount;
			}
			--inputCount;
		}
		
	}

}
