package stacks;

import java.util.Scanner;

public class reverse {
	String input;
	String output;

	reverse(String in) {
		input = in;
	}

	String doRev() {
		int stackSize = input.length();
		stackch theStack = new stackch(stackSize);

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			theStack.push(ch);
		}
		output = "";
		while (!theStack.isEmpty()) {
			char ch = theStack.pop();
			output = output + ch;
		}
		return output;
	}

	public static void main(String args[]) {
		String input = "Java123";
		String output;
		reverse theReverser = new reverse(input);
		output = theReverser.doRev();
		System.out.println("Reversed: " + output);
	}
}