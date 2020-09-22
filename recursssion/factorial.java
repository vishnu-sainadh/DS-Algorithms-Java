package recursssion;

import java.util.*;

public class factorial {
	public static long fact(long n) {
		if (n <= 1)
			return 1;
		else
			return n * fact(n - 1);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number to find its factorial:");
		int n = sc.nextInt();
		System.out.println("The factorial of "+ n+" is: " + fact(n));
	}
}