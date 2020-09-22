package stacks;

class stackobj {
	int maxsize, top, len;
	Object s[];

	stackobj() {
		len = 0;
		top = -1;
		s = new Object[10];
		maxsize = 10;
	}

	stackobj(int x) {
		len = 0;
		top = -1;
		s = new Object[x];
		maxsize = 10;
	}

	boolean isEmpty() {
		if (top == -1)
			return true;
		else
			return false;
	}

	void display() {
		int i;
		for (i = 0; i < top; i++) {
			System.out.println(s[i]);
		}
	}

	void push(int ele) {
		if (top == maxsize - 1)
			System.out.println("stack is full");
		else
			s[++top] = ele;
	}

	Object pop() {
		if (isEmpty()) {
			return -1;
		} else {
			Object t = s[top];
			top--;
			return (t);
		}

	}

	Object peek() {
		if (isEmpty()) {
			return -1;
		} else {
			Object t = s[top];
			return (t);
		}

	}
}

