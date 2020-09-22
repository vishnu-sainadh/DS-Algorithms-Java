package queue;

public class deque {
	int n, front, rear, max;
	int Q[];

	deque() {
		front = rear = -1;
		max = 10;
		Q = new int[10];
	}

	deque(int n) {
		front = rear = -1;
		max = n;
		Q = new int[n];
	}

	void insertfront(int x) {
		if ((front == -1) && (rear == -1)) {
			front = rear = 0;
			Q[front] = x;
		} else {
			if (front == 0) {
				System.out.println("Q is full");
			} else {
				front--;
				Q[front] = x;
			}
		}
	}

	void insertrear(int x) {
		if (rear == -1) {
			front = rear = 0;
			Q[rear] = x;
		} else {
			if (front == max - 1) {
				System.out.println("Q is full");
			} else {
				if (rear == max - 1) {
					System.out.println("Q is full");
				} else {
					rear++;
					Q[rear] = x;
				}
			}
		}
	}

	int deleterear() {
		if (rear == -1) {
			System.out.println("Q is empty");
			return -1;
		} else if (front == rear) {
			int temp = Q[rear];
			front = rear = -1;
			return temp;
		} else {
			return Q[rear--];
		}
	}

	int deletefront() {
		if (front == -1) {
			System.out.println("Q is empty");
			return -1;
		} else if (front == rear) {
			int temp = Q[front];
			front = rear = -1;
			return temp;
		} else {
			return Q[front++];
		}

	}

	boolean isEmpty() {
		if ((front == -1) & (rear == -1)) {
			return true;
		} else {
			return false;
		}
	}

	boolean isFull() {
		if (front == max - 1) {
			return true;
		} else {
			return false;
		}
	}

	void display() {
		int j;
		for (j = front; j <= rear; j++) {
			System.out.println(Q[j]);
		}
	}

	void front() {
		if (isEmpty()) {
			return;
		} else {
			System.out.println(Q[front]);
		}
	}

	public static void main(String[] args) {
		deque a = new deque(5);
		a.insertrear(3);
		a.insertrear(4);
		a.insertrear(5);
		a.insertrear(6);
		a.insertrear(7);
		a.deletefront();
		a.insertfront(2);
		a.display();

	}
}
