package stacks;

class stackint {
	int maxsize, s[], top, len;

	stackint() {
		len = 0;
		top = -1;
		s = new int[10];
		maxsize = 10;
	}

	stackint(int x) {
		len = 0;
		top = -1;
		s = new int[x];
		maxsize = x;
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
		len++;
	}

	int pop() {
		if (isEmpty()) {
			return -1;
		} else {
			int t = s[top];
			top--;
			len--;
			return (t);
		}

	}

	int peek() {
		if (isEmpty()) {
			return -1;
		} else {
			int t = s[top];
			return (t);
		}

	}
}
