package linked_lists;

import java.util.*;

public class assign5q {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList L1 = new LinkedList();
		LinkedList L2 = new LinkedList();
		
		L1.add(1);L1.add(2);L1.add(3);L1.add(4);L1.add(5);
		L2.add(10);L2.add(20);L2.add(30);L2.add(40);L2.add(50);
		
		int ele, choice;
		do {
			System.out.println("choose a function:");
			System.out.println("1.insert");
			System.out.println("2.delete a sublist");
			System.out.println("3.display");
			System.out.println("4.make a sublist");
			System.out.println("5.display using iterator");
			choice = sc.nextInt();
			switch (choice) {
			case (1):
				System.out.println("choose one option:");
				System.out.println("a. first list");
				System.out.println("b. second list");
				char sel = sc.next().charAt(0);
				if (sel == 'a' || sel == 'A') {
					System.out.println("enter element to inserted.");
					ele = sc.nextInt();
					L1.add(ele);
				} else if (sel == 'b' || sel == 'B') {
					System.out.println("enter element to inserted.");
					ele = sc.nextInt();
					L2.add(ele);
				}
				break;
			case (2):
				System.out.println("choose one option:");
				System.out.println("a. first list");
				System.out.println("b. second list");
				sel = sc.next().charAt(0);
				if (sel == 'a' || sel == 'A') {
					System.out.println("1st list elements:" + L1);
					System.out.println("enter first node and last node index starting from 0");
					int first = sc.nextInt();
					int last = sc.nextInt();
					L1.subList(first, last).clear();
				} else if (sel == 'b' || sel == 'B') {
					System.out.println("2nd list elements:" + L2);
					System.out.println("enter first node and last node index starting from 0");
					int first = sc.nextInt();
					int last = sc.nextInt();
					L2.subList(first, last).clear();
				}
				break;
			case (3):
				System.out.println("choose one option:");
				System.out.println("a.for list 1");
				System.out.println("b.for list 2");
				sel = sc.next().charAt(0);
				if (sel == 'a' || sel == 'A') {
					System.out.println("1st list elements are:" + L1);
				} else if (sel == 'b' || sel == 'B') {
					System.out.println("2nd list elements are:" + L2);
				}
				break;
			case (4):
				System.out.println("choose one option:");
				System.out.println("a.for list 1");
				System.out.println("b.for list 2");
				sel = sc.next().charAt(0);
				if (sel == 'a' || sel == 'A') {
					System.out.println("enter first node and last node index starting from 0");
					int first = sc.nextInt();
					int last = sc.nextInt();
					List sub = L1.subList(first, last);
					System.out.println("sub list of the list one is:" + sub);
					System.out.println("do you want to insert this sublist into another list press5");
					int cho = sc.nextInt();
					if (cho == 5) {
						System.out.println("choose one option:");
						System.out.println("a.for list 1");
						System.out.println("b.for list 2");
						sel = sc.next().charAt(0);
						if (sel == 'a' || sel == 'A') {
							System.out.println("enter index position to be inserted starting from 0: ");
							int index = sc.nextInt();
							L1.add(index, sub);
						} else if (sel == 'b' || sel == 'B') {
							System.out.println("enter index position to be inserted starting from 0: ");
							int index = sc.nextInt();
							L2.add(index, sub);
						}
					}
				} else if (sel == 'b' || sel == 'B') {
					System.out.println("enter first node and last node index starting from 0");
					int first = sc.nextInt();
					int last = sc.nextInt();
					List sub = L2.subList(first, last);
					System.out.println("sub list of the list one is:" + sub);
					System.out.println("do you want to insert this sublist into another list press5");
					int cho = sc.nextInt();
					if (cho == 5) {
						System.out.println("choose one option:");
						System.out.println("a.for list 1");
						System.out.println("b.for list 2");
						sel = sc.next().charAt(0);
						if (sel == 'a' || sel == 'A') {
							System.out.println("enter index position to be inserted starting from 0: ");
							int index = sc.nextInt();
							L1.add(index, sub);
						} else if (sel == 'b' || sel == 'B') {
							System.out.println("enter index position to be inserted starting from 0: ");
							int index = sc.nextInt();
							L2.add(index, sub);
						}
					}
				}
				break;
			case (5):
				System.out.println("choose one option:");
				System.out.println("a.for list 1");
				System.out.println("b.for list 2");
				sel = sc.next().charAt(0);
				if (sel == 'a' || sel == 'A') {
					ListIterator it = L1.listIterator(0);// starting index of the list
					System.out.println("list 1 elements:");
					while (it.hasNext()) {
						System.out.println(it.next());
					}
				} else if (sel == 'b' || sel == 'B') {
					ListIterator it = L2.listIterator(0);// starting index of the list
					System.out.println("list 2 elements:");
					while (it.hasNext()) {
						System.out.println(it.next());
					}
				}
				break;

			default:
				System.out.println("choosen wrong option...try again...");

			}
		} while (true);
	}
}