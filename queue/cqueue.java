package queue;

import java.util.Scanner;

public class cqueue {
	int front, rear, max, size;
	int Q[];

	cqueue() {
		front = -1;
		rear = -1;
		max = 5;
		size = 0;
		Q = new int[max];
	}

	cqueue(int m) {
		front = -1;
		rear = -1;
		max = m;
		size = 0;
		Q = new int[m];
	}

	void enqueue(int x) {
		if ((front == -1) && rear == -1) {
			front = rear = 0;
			Q[rear] = x;
			size++;
		} else if ((rear == max - 1) && (front != 0)) {
			rear = 0;
			Q[rear] = x;
			System.out.println(Q[rear]);
			size++;
		} else if ((front == 0) && (rear == max - 1) || (rear + 1 == front)) {
			System.out.println("Q is full.");
		} else {
			Q[++rear] = x;
			size++;

		}
	}

	int dequeue() {
		if ((front == -1) && rear == -1) {
			System.out.println("Q is empty.");
			return -1;
		} else if (front == rear) {
			front = rear = -1;
			size--;
			return front;
		} else if (front == max - 1) {
			front = 0;
			size--;
			return front;
		} else {
			int t = Q[front];
			front++;
			return t;
		}
	}

	boolean isempty() {
		if (front == -1 && rear == -1)
			return true;
		else
			return false;
	}

	boolean isfull() {
		if ((front == 0) && (rear == max - 1) || (rear + 1 == front))
			return true;
		else
			return false;
	}

	void display() {
		System.out.println("circular Queue elements are:");
		if (rear < front) {
			for (int i = front; i <= max - 1; i++) {
				System.out.println(Q[i]);
			}
			for (int j = 0; j <= rear; j++) {
				System.out.println(Q[j]);
			}
		} else {
			for (int i = front; i <= rear; i++) {
				System.out.println(Q[i]);
			}
		}
	}

	public static void main(String[] args) {
		cqueue a = new cqueue(5);
		a.enqueue(3);
		a.enqueue(1);
		a.enqueue(9);
		a.enqueue(5);
		a.enqueue(5);
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.enqueue(12);
		a.enqueue(14);
		a.enqueue(8);
		a.display();
	}
}