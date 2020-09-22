package linked_lists;
import java.util.*;
public class stacks_ll extends singly_ll {
	snode head = null;
	int size = 0;

	stacks_ll() {
		head = null;
	}

	stacks_ll(int x) {
		head = new snode(x);
		size++;
	}
	
	void push(int data)
	{
		snode node = new snode();
		node.data = data;
		node.next = null;	
		if(head==null)
		{
			head = node;
		}
		else
		{
			snode n = head;
			while(n.next!=null)
			{
				n = n.next;
			}
			n.next =  node;
		}	
	}
	
	boolean isEmpty()
    {
        return head == null;
    }
	
	void pop() {
		snode t = head;
		if (t == null) {
			System.out.println("Empty");
		} else {
			while (t.next.next != null) {
				t = t.next;
			}
			t.next = null;
		}
		size--;
	}
	
	void display() {
		System.out.println("STACK ELEMENTS ARE: -");
		if (head == null) {
	           System.out.printf("\nStack Underflow");  
	       }
	       else {
		snode temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		}
	}
	
	snode peek() {
		snode t = head;
		while (t.next != null) {
			t = t.next;
			if (t == null) {
				System.out.println("Element not found");
			} 
		}
		System.out.println("top element is :"+t.data);
		return t;
	}

public static void main(String[] args) {
	stacks_ll obj = new stacks_ll();
	int i=1;
	Scanner sc=new Scanner(System.in);
	while(i==1) {
	System.out.println("1)push 2)pop 3)peek 4)display 5)exit");
	int q=sc.nextInt();
	switch(q) {
	case 1:System.out.println("Enter the element to be pushed");
	       int s=sc.nextInt();
	       obj.push(s);
	break;
	case 2:obj.pop();
	break;
	case 3:System.out.println(obj.peek());
	break;
	case 4:obj.display();
	break;
	case 5:i=2;
	break;
	}
	}
	System.out.println("End");
	}
}

