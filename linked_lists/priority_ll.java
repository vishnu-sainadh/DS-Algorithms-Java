package linked_lists;

import java.util.*;

class pnode {
	int data, priority;
	pnode next;

	pnode() {
		data = 0;
		priority = 0;
		next = null;
	}

	pnode(int a, int p) {
		data = a;
		priority = p;
		next = null;
	}
}

public class priority_ll {
	pnode head = null;

	priority_ll() {
		head = null;
	}

	priority_ll(int a, int p) {
		head = new pnode(a, p);
	}

	void push(int a, int p) {
		pnode t = head;
		pnode r = new pnode(a, p);
		if (head == null) {
			head = r;
		} else if (head.priority < p) {
			r.next = head;
			head = r;
		} else {
			while ((t.next != null) && (t.next.priority >= p)) {
				t = t.next;
			}
			if (t.next == null) {
				t.next = r;
			} else {
				pnode t2 = t.next;
				t.next = r;
				r.next = t2;
			}
		}
	}

	pnode pop() {
		if (head == null) {
			System.out.println("Queue is empty");
			return null;
		} else {
			pnode t = head;
			head = head.next;
			return t;
		}

	}

	int peek() {
		return head.data;

	}

	void display() {
		pnode t = head;
		if (t == null) {
			System.out.println("Empty");
		} else {
			System.out.println("The following elements in priority queue are:");
			while (t != null) {
				System.out.println(t.data);
				t = t.next;
			}
		}
	}

	public static void main(String[] args) {
		priority_ll obj = new priority_ll();
		int i = 1;
		Scanner sc = new Scanner(System.in);
		while (i == 1) {
			System.out.println("1)push 2)pop 3)peek 4)display 5)exit");
			int q = sc.nextInt();
			switch (q) {
			case 1:
				System.out.println("Enter the element to be pushed");
				int a = sc.nextInt();
				int p = sc.nextInt();
				obj.push(a, p);
				break;
			case 2:
				obj.pop();
				break;
			case 3:
				System.out.println(obj.peek());
				break;
			case 4:
				obj.display();
				break;
			case 5:
				i = 2;
				break;
			}
		}
		System.out.println("End");
	}
}