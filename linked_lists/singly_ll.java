package linked_lists;

import java.util.*;

class snode {
	int data;
	snode next;

	snode() {
		data = 0;
		next = null;
	}

	snode(int a) {
		data = a;
		next = null;
	}
}

class SLL {
	snode head = null;
	int size = 0;

	SLL() {
		head = null;
	}

	SLL(int x) {
		head = new snode(x);
		size++;
	}

	snode search(int ele) {
		snode t = head;
		while (t != null && t.data != ele) {
			t = t.next;
			if (t == null) {
				System.out.println("Element not found");
			} else if (t.data == ele) {
				System.out.println("search element is " + t.data);
			}
		}
		return t;
	}

	snode searchbefore(int ele) {
		snode t = head;
		while (t.next != null && t.next.data != ele) {
			t = t.next;
			if (t == null) {
				System.out.println("Element not found");
			} else if (t.data == ele) {
				System.out.println("search element is " + t.data);
			}
		}
		return t;
	}

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

	void insertlast(int data) {
		snode node = new snode();
		node.data = data;
		node.next = null;
		if (head == null) {
			head = node;
		} else {
			snode n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = node;
		}
		size++;
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

	void insertafter(int ele, int nele) {
		snode temp = search(ele);
		snode t = new snode(nele);
		t.next = temp.next;
		temp.next = t;
		size++;
	}

	void insertbefore(int ele, int nele) {
		snode x = head;
		if (x.data == ele && x == head) {
			insertfirst(nele);
		} else {
			snode temp = searchbefore(ele);
			snode t = new snode(nele);
			t.next = temp.next;
			temp.next = t;
			size++;
		}
	}

	void deleteparticularelement(int ele) {
		snode temp = searchbefore(ele);
		temp.next = temp.next.next;
		size--;
	}

	void insertAt(int index, int data) {
		snode node = new snode();
		node.data = data;
		node.next = null;

		if (index == 0) {
			insertfirst(data);
		} else {
			snode n = head;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			node.next = n.next;
			n.next = node;
		}
		size++;
	}

	void deleteAt(int index) {
		if (index == 0) {
			head = head.next;
		} else {
			snode n = head;
			snode n1 = null;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;
			// System.out.println("n1 " + n1.data);
			n1 = null;
		}
		size--;
	}

	void display() {
		snode temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	int count() {
		System.out.println("size is :" + size);
		return size;
	}

	void sortList() {
		snode current = head, index = null;
		int temp;
		if (head == null) {
			return;
		} else {
			while (current != null) {
				index = current.next;

				while (index != null) {
					if (current.data > index.data) {
						temp = current.data;
						current.data = index.data;
						index.data = temp;
					}
					index = index.next;
				}
				current = current.next;
			}
		}
	}

	int printMiddleElement() {
		snode p = head;
		snode q = head;
		while (q != null && q.next != null) {
			p = p.next;
			q = q.next.next;
		}
		return p.data;
	}

	void removeDuplicate() {
		snode current = head, index = null, temp = null;
		if (head == null) {
			return;
		} else {
			while (current != null) {
				temp = current;
				index = current.next;
				while (index != null) {
					if (current.data == index.data) {
						temp.next = index.next;
						size--;
					} else {
						temp = index;
					}
					index = index.next;
				}
				current = current.next;
			}
		}
	}

	snode concatenate(snode head1, snode head2) {
		snode p;
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		else if (head1!=null&&head2!=null) {
			p = head1;
			while (p.next != null) {
				p = p.next;
			}
			p.next = head2;	
			return head1;
		}
		return null;
	}

	snode isCircular(snode head) {
		snode p = head;
		snode q = head;
		while (p == null && q == null && q.next == null) {
			p = p.next;
			q = q.next.next;
			if (p == q) {
				System.out.println("Is Circular");
				return p;
			}
		}
		return null;
	}
	
	snode sortedMerge(snode headA, snode headB)
	{
	   snode dummyNode = new snode(0);

	   snode tail = dummyNode;
	   while(true)  
	   {
	       if(headA == null)
	       {
	           tail.next = headB;
	           break;
	       }
	       if(headB == null)
	       {
	           tail.next = headA;
	           break;
	       }
	       
	       if(headA.data <= headB.data)
	       {
	           tail.next = headA;
	           headA = headA.next;
	       }  
	       else
	       {
	           tail.next = headB;
	           headB = headB.next;
	       }
	       tail = tail.next;
	   }
	   return dummyNode.next;
	}
	
	SLL splitHalf(){
	    snode t2 = this.head;
	    int length = size;
	    if (size % 2 != 0){
	        length++;
	    }
	    for (int i=0;i<length/2-1;i++){
	        t2 = t2.next;
	    }
	    SLL list = new SLL();
	    list.head = t2.next;
	    t2.next = null;
	    list.size = this.size/2;
	    this.size = this.size - list.size;
	    snode p=list.head;
	    System.out.println("second half of half splitted list is :");
	    while(p!=null) {
	    	System.out.println(p.data);
	    	p=p.next;
	    }
	    return list;
	}

	SLL splitAtPos(int pos){
	    snode t = this.head;
	    SLL list = new SLL();
	    if (pos <= this.size && this.size >= 2){
	        for (int i=0; i<pos-2; i++){
	            t = t.next;
	        }
	        list.head = t.next;
	        t.next = null;
	        list.size = this.size - (pos - 1);
	        this.size = pos - 1;
	    }
	    else System.out.println("Index out of bounds...");
	    snode p=list.head;
	    System.out.println("second part of position splitted list is :");
	    while(p!=null) {
	    	System.out.println(p.data);
	    	p=p.next;
	    }
	    return list;
	}

	SLL splitAtEle(int ele){
	    snode t = this.head;
	    int count = 1;
	    while (t.next != null && t.next.data != ele){
	        t = t.next;
	        count++;
	    }
	    SLL list = new SLL();
	    list.head = t.next;
	    t.next = null;
	    if (count != size){
	        list.size = this.size - count;
	        this.size = count;
	    }
	    snode p=list.head;
	    System.out.println("second part of element splitted list is :");
	    while(p!=null) {
	    	System.out.println(p.data);
	    	p=p.next;
	    }
	    return list;
	}

}

public class singly_ll {
	public static void main(String[] args) {
		System.out.println("linked list L1 is :");
		SLL L1 = new SLL();
		L1.insertlast(1);
		L1.insertlast(2);
		L1.insertlast(3);
		L1.insertlast(4);
		L1.insertlast(8);
		L1.display();
		System.out.println("");
		
		System.out.println("linked list L2 is :");
		SLL L2 = new SLL();
		L2.insertlast(6);	
		L2.insertlast(7);
		L2.insertlast(8);
		L2.insertlast(9);
		//insert last
		L2.insertlast(10);
		//delete first
		L2.deletefirst();	
		//insert first
		L2.insertfirst(6);	
		//delete last
		L2.deletelast();
		/*insert after a specific element here we also use SEARCH command
		to return the address of node*/
		L2.insertafter(9, 10);	
		//delete particular element
		L2.deleteparticularelement(10);
		//insert at index
		L2.insertAt(4, 10);	
		//delete at index
		L2.deleteAt(3);		
		/*insert before a specific element here we also use SEARCH BEFORE command
		to return the address of node before the given element node*/
		L2.insertbefore(10, 9);		
		L2.insertlast(10);	
		//displays the list
		L2.display();	
		//count the number of nodes
		L2.count();	
		/*If linked list isCircular we get a statement returning
		IS CIRCULAR*/
		L2.isCircular(L2.head);
		System.out.println("After Removing Duplicates L2 is :");
		//remove duplicate if present
		L2.removeDuplicate();	
		L2.display();
		L2.count();
		System.out.print("Middle Element of a Linked List 2 is :");
		//find middle element in one pass
		System.out.println(L2.printMiddleElement());
		System.out.println("");
		
		SLL L3=new SLL();
		System.out.println("linked list L3 is :");
		System.out.println("L3 == Concatenation of L1 and L2 is:");
		//concatenation of L1 and L2 lists
		L3.head=L3.concatenate(L1.head, L2.head);	
		L3.display();
		L3.size=L1.size+L2.size;
		L3.count();
		L3.size=L1.size+L2.size;
		snode p=L1.head;
		p.next.next.next.next.next=null;
		System.out.println("");
		
		SLL L4=new SLL();
		System.out.println("linked list L4 is :");
		System.out.println("L4 == Sorted Merge of L1 and L2 is:");
		//sortedMerge of L1 and L2 lists
		L4.head=L4.sortedMerge(L1.head, L2.head);
		L4.display();
		L4.size=L1.size+L2.size;
		L4.count();
		System.out.println("");
		
		System.out.println("splitting list L4 into two halves :");
		//splitting linked list(L4) into two halves
		L4.splitHalf();
		System.out.println("First half of half splitted list is :");
		L4.display();
		System.out.println("");
		
		System.out.println("After splitting L4 into equal halves L4 is :");
		System.out.println("linked list L4 is :");
		L4.display();
		System.out.println("");
		
		System.out.println("splitting list at particular element :");
		//splitting linked list(L4) into two parts at particular element
		L4.splitAtEle(4);
		System.out.println("First part of element splitted list is :");
		L4.display();
		System.out.println("");
		
		System.out.println("After splitting L4 at particular element L4 is :");
		System.out.println("linked list L4 is :");
		L4.display();
		System.out.println("");
		
		System.out.println("splitting list at particular position :");
		//splitting linked list(L4) into two parts at particular position
		L4.splitAtPos(1);
		System.out.println("First part of position splitted list is :");
		L4.display();
		System.out.println("");
		
		System.out.println("After splitting L4 at particular position L4 is :");
		System.out.println("linked list L4 is :");
		L4.display();
		System.out.println("");
	}
}
