package linked_lists;

import java.util.Scanner;

class dnode {
	int data;
	dnode prev, next;

	dnode() {
		data = 0;
		prev = next = null;
	}

	dnode(int ele) {
		prev = next = null;
		data = ele;
	}
}

class DLL {
	dnode head, tail;
	int size = 0;

	DLL() {
		head = new dnode();
		tail = new dnode();
		head.prev = null;
		head.next = tail;
		tail.prev = head;
		tail.next = null;
	}

	void addFirst(int ele) {
		dnode n = new dnode(ele);
		head.next.prev = n;
		n.next = head.next;
		head.next = n;
		n.prev = head;
		size++;
	}

	void addLast(int ele) {
		dnode n = new dnode(ele);
		n.prev = tail.prev;
		tail.prev = n;
		tail.prev.prev.next = tail.prev;
		tail.prev.next = tail;
		size++;
	}

	dnode search(int ele) {
		dnode t = this.head;
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

	void printList(dnode h) {
		dnode temp = h.next;
		while (temp.next != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("*****"+head.next.next.prev.data);
		System.out.println();
	}

	void printListRev(dnode h) {
		dnode temp = h.prev;
		while (temp.prev != null) {
			System.out.print(temp.data + " ");
			temp = temp.prev;
		}
		System.out.println();
	}

	void deleteLast() {
		tail.prev = tail.prev.prev;
		tail.prev.next = tail;
		size--;
	}

	void deleteFirst() {
		head = head.next;
		head.prev = null;
		size--;
	}

	dnode concatenate(dnode head1, dnode head2) {
		dnode p;
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		} else if (head1 != null && head2 != null) {
			p = head1;
			while (p.next.next != null) {
				p = p.next;
			}
			p.next = head2;
			return head1;
		}
		return null;
	}

	dnode sortedMerge(dnode headA, dnode headB) {
		dnode dummyNode = new dnode(0);

		dnode tails = dummyNode;
		while (true) {
			if (headA == null) {
				tails.next = headB;
				break;
			}
			if (headB == null) {
				tails.next = headA;
				break;
			}

			if (headA.data <= headB.data) {
				tails.next = headA;
				if (headA == tail) {
					tails.next = headB;
					break;
				}
				headA = headA.next;
			} else {
				tails.next = headB;
				if (headB == tail) {
					tails.next = headA;
					break;
				}
				headB = headB.next;
			}
			tails = tails.next;
		}
		return dummyNode.next;
	}

	void splitingIntoHalf() {
		int len = size;
		dnode t = this.head.next;
		System.out.println("list elements before splitting:");
		this.printList(this.head);
		if (len % 2 != 0)// if len is odd
		{
			len++;
		}
		for (int i = 0; i < (len / 2) - 1; i++) {
			t = t.next;
		}
		DLL lNew = new DLL();
		lNew.head.next = t.next;
		t.next = tail;
		lNew.size = this.size / 2;
		this.size = this.size - lNew.size;
		System.out.println("lists after spliting into 2 halves:");
		System.out.println("list 1 elements:");
		this.printList(this.head);
		System.out.println("list 2 elements:");
		lNew.printList(lNew.head);
	}

	void splitingFrmPos(int pos) {
		dnode t = this.head.next;
		System.out.println("list elements before spliting..");
		this.printList(this.head);
		for (int i = 0; i < pos - 1; i++) {
			t = t.next;
		}
		DLL lnew = new DLL();
		lnew.head.next = t.next;
		t.next = tail;
		System.out.println("lists after splitting from the position...");
		System.out.println("list 1 elements:");
		this.printList(this.head);
		System.out.println("list 2 elements:");
		lnew.printList(lnew.head);

	}

	void splitingFrmEle(int ele) {
		dnode t = this.head.next;
		System.out.println("list elements before spliting:");
		this.printList(this.head);
		while (t.next.data != ele) {
			t = t.next;
		}
		DLL lnew = new DLL();
		lnew.head.next = t.next;
		t.next = tail;
		System.out.println("lists after splitting from the position...");
		System.out.println("list 1 elements:");
		this.printList(this.head);
		System.out.println("list 2 elements:");
		lnew.printList(lnew.head);

	}

	int middle() {
		int len = 0;
		dnode curr = this.head.next;
		dnode mid = this.head.next;
		while (curr.next != null) {
			len++;
			if ((len % 2) == 0) {
				mid = mid.next;
			}
			curr = curr.next;
		}
		return (mid.data);
	}

	void removeDup() {
		dnode t = this.head.next;
		dnode t2;
		while (t.next != null) {
			t2 = t;
			while (t2 != null && t.next != null) {
				while (t2.next != null && t2.next.data == t.data) {
					t2.next = t2.next.next;
					size--;
				}
				t2 = t2.next;
			}
			t = t.next;
		}
	}

	int count() {
		return (size);
	}

	boolean isEmpty() {
		if (this.head.next == null && this.tail.prev == null)
			return true;
		else
			return false;
	}

	void insertafter(int ele, int nele) {
		dnode temp = search(ele);
		dnode t = new dnode(nele);
		t.next = temp.next;
		temp.next.prev = t;
		temp.next = t;
		t.prev = temp;
		size++;
	}

	void insertbefore(int ele, int nele) {
		dnode x = head;
		if (x.data == ele && x == head) {
			addFirst(nele);
		} else {
			dnode temp = search(ele);
			dnode t = new dnode(nele);
			temp.prev.next = t;
			t.prev = temp.prev;
			t.next = temp;
			temp.prev = t;
			size++;
		}
	}

	void deleteparticularelement(int ele) {
		dnode temp = search(ele);
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		size--;
	}

	void insertAt(int index, int data) {
		dnode no = new dnode(data);

		if (index == 0) {
			addFirst(data);
		} else {
			dnode n = head;
			for (int i = 0; i < index; i++) {
				n = n.next;
			}
			n.next.prev = no;
			no.next = n.next;
			no.prev = n;
			n.next = no;
			size++;
		}
	}

	void deleteAt(int index) {
		if (index == 0) {
			head = head.next;
		} else {
			dnode n = head;
			dnode n1 = null;
			for (int i = 0; i < index; i++) {
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;
			n1 = null;
			size--;
		}
	}
}

public class doubly_ll {
	public static void main(String[] args) {
		DLL L1 = new DLL();
		DLL L2 = new DLL();
		DLL L3 = new DLL();
		DLL L4 = new DLL();
		L4.addLast(20);
		L4.addLast(22);
		L4.addLast(23);
		L4.addLast(24);
		System.out.println("DOUBLY LINKED LIST L4 is:");
		L4.printList(L4.head);
		DLL L5 = new DLL();
		L5.addLast(21);
		L5.addLast(25);
		L5.addLast(26);
		L5.addLast(27);
		System.out.println("DOUBLY LINKED LIST L5 is:");
		L5.printList(L5.head);
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while (t == 1) {
			System.out.println("choose a option to perform on L1:");
			System.out.println("1.insert first.");
			System.out.println("2.insert last.");
			System.out.println("14.insert at index");
			System.out.println("15.insert After element");
			System.out.println("16.insert Before element");
			System.out.println("3.delete first.");
			System.out.println("4.delete last.");
			System.out.println("18.Delete At");
			System.out.println("17.delete Particular Element");
			System.out.println("13.print middle element in one pass");
			System.out.println("11.size");
			System.out.println("12.search a element");
			System.out.println("7.remove duplicates");
			System.out.println("5.print list elements.");
			System.out.println("6.reverse print.");
			System.out.println("8.split into equal halves.");
			System.out.println("9.split at position.");
			System.out.println("10.split at element.");
			System.out.println("19.Concatenate L2 and L3");
			System.out.println("20.Merging sorted lists L4 and L5");
			System.out.println("21.Do you want to end");
			int cho = sc.nextInt();
			switch (cho) {
			case (1):
				System.out.println("enter element to be inserted:");
				int ele = sc.nextInt();
				L1.addFirst(ele);
				break;
			case (2):
				System.out.println("enter element to be inserted:");
				ele = sc.nextInt();
				L1.addLast(ele);
				break;
			case (3):
				L1.deleteFirst();
				break;
			case (4):
				L1.deleteLast();
				break;
			case (5):
				System.out.println("the list elements are");
				L1.printList(L1.head);
				break;
			case (6):
				System.out.println("the revese order elements in a list");
				L1.printListRev(L1.tail);
				break;
			case (7):
				System.out.println("elements before duplicate removal:");
				L1.printList(L1.head);
				System.out.println("elements after duplicate removal:");
				L1.removeDup();
				L1.printList(L1.head);
				break;
			case (8):
				L1.splitingIntoHalf();
				break;
			case (9):
				System.out.println("list elements:");
				L1.printList(L1.head);
				System.out.println("enter position no.(index starting form 0,1,2....)");
				int pos = sc.nextInt();
				L1.splitingFrmPos(pos);
				break;
			case (10):
				System.out.println("list elements:");
				L1.printList(L1.head);
				System.out.println("enter element no.:");
				ele = sc.nextInt();
				L1.splitingFrmEle(ele);
				break;
			case (11):
				System.out.println("list elements:");
				L1.printList(L1.head);
				System.out.println("the no. of elements in the list is:" + L1.count());
				break;
			case (12):
				System.out.println("enter element to be searched:");
				ele = sc.nextInt();
				L1.search(ele);
				break;
			case (13):
				System.out.println("list elements are:");
				L1.printList(L1.head);
				System.out.println("middle element is :" + L1.middle());
				break;
			case (14):
				System.out.println("Enter the index and data");
				int x = sc.nextInt();
				int r = sc.nextInt();
				L1.insertAt(x, r);
				break;
			case (15):
				System.out.println("Insert after which element and enter the element to be inserted");
				x = sc.nextInt();
				int y = sc.nextInt();
				L1.insertafter(x, y);
				break;
			case (16):
				System.out.println("Insert before which element and enter the element to be inserted");
				x = sc.nextInt();
				int z = sc.nextInt();
				L1.insertbefore(x, z);
				break;
			case (17):
				System.out.println("Enter the element to be deleted");
				x = sc.nextInt();
				L1.deleteparticularelement(x);
				break;
			case (18):
				System.out.println("Enter the index");
				x = sc.nextInt();
				L1.deleteAt(x);
				break;
			case (19):
				System.out.println("L2 before concatenation is:");
				L2.printList(L2.head);
				System.out.println("size of L2 before concatenation is:" + L2.size);
				System.out.println("L3 before concatenation is:");
				L3.printList(L3.head);
				System.out.println("size of L2 before concatenation is:" + L2.size);
				L2.concatenate(L2.head.next, L3.head.next);
				L2.size = L2.size + L3.size;
				System.out.println("L2 after concatenation is:");
				L2.printList(L2.head);
				System.out.println("size of L2 after concatenation is:" + L2.size);
				break;
			case (20):
				System.out.println("L4 before concatenation is:");
				L4.printList(L4.head);
				System.out.println("size of L4 before concatenation is:" + L4.size);
				System.out.println("L5 before concatenation is:");
				L5.printList(L5.head);
				System.out.println("size of L5 before concatenation is:" + L5.size);
				L4.sortedMerge(L4.head.next, L5.head.next);
				L4.size = L4.size + L5.size;
				System.out.println("L4 after sortedMerge is:");
				L2.printList(L4.head);
				System.out.println("size of L4 after sortedMerge is:" + L4.size);
				break;
			case (21):
				t = 0;
				System.out.println("end");
				break;
			default:
				System.out.println("try again....");
			}
		}
	}
}
