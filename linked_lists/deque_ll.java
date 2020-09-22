package linked_lists;
import java.util.*;
public class deque_ll extends singly_ll {
	snode head = null;
	int size = 0;

	void insertfirst(int a) {
		if (head == null) {
			head = new snode(a);
			size++;
		} else {
			snode t = new snode(a);
			t.next = head;
			head = t;
			size++;
		}
	}

	void insertlast(int data)
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

	void deletefirst() {
		if (head == null) {
			System.out.println("No elements");
		} else
			head = head.next;
		size--;
	}

	void deletelast() {
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
		System.out.println("DEQUE ELEMENTS ARE: -");
		if (head == null) {
	           System.out.printf("\ndeque Underflow");  
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
		deque_ll obj = new deque_ll();
		int i=1;
		Scanner sc=new Scanner(System.in);
		while(i==1) {
		System.out.println("1)InsertFirst 2)InsertLast 3)DeleteFirst 4)DeleteLast 5)Front 6)display 7)exit");
		int q=sc.nextInt();
		switch(q) {
		case 1:System.out.println("Enter the element to be inserted");
		       int s=sc.nextInt();
		       obj.insertfirst(s);
		break;
		case 2:System.out.println("Enter the element to be inserted");
		       int k=sc.nextInt();
		  obj.insertlast(k);
		break;
		case 3:obj.deletefirst();
		break;
		case 4:obj.deletelast();
		break;
		case 5:obj.front();
		break;
		case 6:obj.display();
		break;
		case 7:i=2;
		break; 
		}
		}
		System.out.println("End");
	}
}
