package linked_lists;
import java.util.*;
public class queues_ll extends singly_ll{
	snode head = null;
	int size = 0;

	queues_ll() {
		head = null;
	}

	queues_ll(int x) {
		head = new snode(x);
		size++;
	}
	
	void enqueue(int data)
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
	
	void dequeue() {
		if (head == null) {
			System.out.println("No elements");
		} else
			head = head.next;
		size--;
	}
	
	void display() {
		System.out.println("QUEUE ELEMENTS ARE: -");
		if (head == null) {
	           System.out.printf("\nqueue Underflow");  
	       }
	       else {
		snode temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		}
	}
	
	void front() {
		snode temp = head;
		System.out.println("front element is :"+temp.data);
	}
	
	public static void main(String[] args) {
		queues_ll obj = new queues_ll();
		int i=1;
		Scanner sc=new Scanner(System.in);
		while(i==1) {
		System.out.println("1)Enqueue 2)Dequeue 3)Front 4)display 5)exit");
		int q=sc.nextInt();
		switch(q) {
		case 1:System.out.println("Enter the element to be pushed");
		       int s=sc.nextInt();
		       obj.enqueue(s);
		break;
		case 2:obj.dequeue();
		break;
		case 3:obj.front();
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
