import java.util.Scanner;

public class FindNumDigits {
	private static int numCount = 0;
	
	public static int digitCount(int currDigit) {
	     if (currDigit / 10 != 0) {
	         numCount += 1;
	         System.out.println("Numcount: " + numCount);
	         System.out.println("Current digit: " + currDigit);
	         currDigit = currDigit / 10;
	         numCount = digitCount(currDigit);
	         return numCount;
	     }
	     else {
	        numCount += 1;
	        System.out.println("DONE");
	        return numCount;
	     }
	   }
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
	      int num, digits;
	      
	      num = scnr.nextInt();
	      digits = digitCount(num);
	      System.out.println(digits);
	      
	      scnr.close();

	}

}
