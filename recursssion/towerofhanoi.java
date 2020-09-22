package recursssion;

import java.util.*;
import java.util.Scanner;

public class towerofhanoi {
	static int count=0;
	static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) {
		count++;
		if (n == 1) {
			System.out.println("Move disk 1 from rod " + from_rod + " to rod " + to_rod);
			return;
		}
		towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
		System.out.println("Move disk " + n + " from rod " + from_rod + " to rod " + to_rod);
		towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
	}

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter the number of disks:");
		int n = s.nextInt();
		towerOfHanoi(n, 'A', 'C', 'B');
		System.out.println("count is :"+count);
	}
}