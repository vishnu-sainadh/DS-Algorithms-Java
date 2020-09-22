package queue;

public class lqueue {
	int front;
	int rear;
	int size;
	int max;
	int Q[];

	lqueue() {
		front = rear = -1;
		size = 0;
		max = 10;
		Q = new int[10];
	}

	lqueue(int n) {
		front = rear = -1;
		size = 0;
		max = n;
		Q = new int[n];
	}

	void enqueue(int x) {
		if ((front == -1) && (rear == -1)) {
			front = rear = 0;
			Q[rear] = x;
			size++;
		} else {
			if (rear == max - 1) {
				System.out.println("queue full");
			} else {
				Q[++rear] = x;
				size++;
			}
		}
	}

	int dequeue() {
		if (front == -1) {
			System.out.println("Queue is empty");
			return -1;
		} else {
			if (front == rear) {
				front = rear = 0;
				System.out.println("empty queue");
				size--;
				return 0;
			} else {
				int i = Q[front];
				front++;
				return i;
			}
		}
	}

	boolean isempty() {
		if ((front == -1) && (rear == -1))
			return true;
		else
			return false;
	}

	boolean isfull() {
		if (rear == max - 1)
			return true;
		else
			return false;
	}

	void display() {
		System.out.println("linear Queue elements are:");
		int i;
		for (i = front; i <= rear; i++) {
			System.out.println(Q[i]);
		}
	}

	void front() {
		if (isempty()) {
			return;
		}
		else {
			System.out.println(Q[front]);
		}
	}

	public static void main(String[] args) {
		lqueue a = new lqueue(5);
		a.enqueue(3);
		a.enqueue(1);
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.display();
	}
}
