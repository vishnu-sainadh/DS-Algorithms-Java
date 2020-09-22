package queue;

import java.util.*;

class pqueue {
	int Q[];
	int front = -1, rear = -1;
	int size = 0, max;

	pqueue(int y) {
		front = rear = -1;
		max = y;
		Q = new int[max];
	}

	void enqueue(int x) {
		if (rear == -1 && front == -1) {
			rear = 0;
			front = 0;
			Q[front] = x;
			size++;
		} else if (rear == -1) {
			System.out.println("Full");
		} else {
			int i = rear;
			while (Q[i] >= x) {
				Q[i + 1] = Q[i];
				i--;
			}
			Q[i + 1] = x;
			rear++;
			size++;
		}
	}

	boolean isempty() {
		if ((front == rear) && (rear == -1))
			return true;
		else
			return false;
	}

	int dequeue() {
		if (isempty())
			return -1;
		else {
			int t = Q[front];
			++front;
			return t;
		}
	}

	void display() {
		if (rear == -1)
			System.out.println("Queue is empty");
		else
			for (int k = front; k <= rear; k++)
				System.out.println(Q[k]);
	}

	int front() {
		if (front < 0)
			return -1;
		else {
			int t = Q[front];
			return (t);
		}
	}

	public static void main(String[] args) {
		pqueue a = new pqueue(5);
		a.enqueue(4);
		a.enqueue(5);
		a.enqueue(7);
		a.enqueue(6);
		a.enqueue(3);
		a.display();
	}
}
