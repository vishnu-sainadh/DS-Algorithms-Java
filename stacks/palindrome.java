package stacks;

import java.util.Scanner;

public class palindrome {
	public static void main(String args[]) {
		String org = "aha";
		String dup = "";
		reverse n1 = new reverse(org);
		dup=n1.doRev();
		System.out.println("dup="+n1.output);
		if (org.equals(dup)) {
			System.out.println("is a palindrome");
		} else {
			System.out.println("not a palindrome");
		}
	}
}