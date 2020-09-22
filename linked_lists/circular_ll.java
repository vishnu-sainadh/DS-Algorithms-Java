package linked_lists;

import java.util.Scanner;

class cnode {
	int data;
	cnode next;

	cnode() {
		data = 0;
		next = null;
	}

	cnode(int x) {
		data = x;
		next = null;
	}
}

class CircularSLL {
	cnode front;
	cnode tail;
	int size = 0;

	CircularSLL() {
//front=tail=null;
		tail = new cnode();
		tail.next = tail;
	}

	CircularSLL(int x) {
//front=new Cnode(x);
		tail = new cnode(x);
		tail.next = tail;
		size++;
	}

	void insertFirst(int x) {
//Cnode t=new Cnode(x);
		if (tail.next == tail) {
			cnode t = new cnode(x);
			t.next = tail;
			tail.next = t;
		} else {
			cnode t = new cnode(x);
			t.next = tail.next;
			tail.next = t;
		}
		size++;

	}

	void insertLast(int x) {
		cnode t = new cnode(x);
		cnode t1 = tail.next;
		if (tail.next == tail) {
			tail.next = t;
			t.next = tail;
		} else {
			while (t1.next != tail) {
				t1 = t1.next;
			}
			t1.next = t;
			t.next = tail;
		}
		size++;
	}

	void insertafter(int ele, int element) {
		cnode s = search(element);
		cnode t = new cnode(ele);
		t.next = s.next;
		s.next = t;
		size++;
	}

	void insertbefore(int ele, int element) {
		cnode s = search(element);
		cnode t = tail.next;
		cnode t1 = new cnode(ele);
		while (t.next.data != s.data) {
			t = t.next;
		}
		if (s.data == element) {

			t1.next = t.next;
			t.next = t1;
			size++;
		}
	}

	void deleteFirst() {
		if (tail.next != tail) {
			tail.next = tail.next.next;
			size--;
		} else
			System.out.println("List is empty");
	}

	void deleteLast() {
		if (tail.next == tail) {
			System.out.println("List is Underflow...");
		} else if (tail.next.next == tail) {
			tail.next = tail;
		} else {
			cnode t = tail.next;
			while (t.next.next != tail) {
				t = t.next;
			}
			t.next = tail;
		}
		size--;
	}

	public void deleteParticularElement(int x) {
		cnode temp = front;

		if (front != null) {
			if (temp.data == x) {
				front = front.next;
				tail.next = front;
			} else {
				do {
					cnode next = temp.next;
					if (next.data == x) {
						temp.next = next.next;
						break;
					}
					temp = temp.next;
				} while (temp != front);
			}
		}
		size--;
	}

	void deleteparticularPosition(int pos) {
		cnode t1 = tail.next;
		if (pos <= size) {
			for (int i = 1; i < pos - 1; i++) {
				t1 = t1.next;
			}
			t1.next = t1.next.next;
			size--;
		} else
			System.out.println("Element not Found...");
	}

	public void middleElement() {
		int x = size;
		int count = 0;
		cnode t = tail.next;

		while (count < x / 2 - 1) {
			t = t.next;
			count = count + 1;
		}
		if (x % 2 == 0) {
			System.out.println("The Middle Elements in the List are " + t.data + " and " + t.next.data);

		} else {
			t = t.next;
			System.out.println("The Middle Element in the List is " + t.data);

		}
	}

	void removeDuplicates() {
		cnode t = this.tail.next;
		cnode t2;
		while (t != tail) {
			t2 = t;
			while (t2 != tail && t.next != tail) {
				while (t2.next != tail && t2.next.data == t.data) {
					t2.next = t2.next.next;
				}
				t2 = t2.next;
			}
			t = t.next;
		}
	}

	cnode search(int ele) {
		cnode t = tail.next;
		while (t != null && t.data != ele) {
			t = t.next;
		}
		if (t == tail) {
			System.out.println("Element Not Found");
		} else {
			if (t.data == ele) {
				System.out.println("The Searched Element is : " + t.data);
				return t;
			}
		}
		return t;
	}

	void display() {
		if (size == 0) {
			System.out.println(" Empty...");
		} else {
			cnode temp = tail.next;
			while (temp.next != tail) {
				System.out.print(temp.data + "->");
				temp = temp.next;
			}
			System.out.println(temp.data);
		}
		System.out.println("The Head node is :" + tail.next.data);
	}

	void concatenate(CircularSLL list) {
		cnode t1 = this.tail.next;
		cnode t2 = list.tail.next;
		while (t1.next != this.tail) {
			t1 = t1.next;
		}
		while (t2.next != list.tail) {
			t2 = t2.next;
		}
		t1.next = list.tail.next;
		this.size = this.size + list.size;
		t2.next = this.tail;
		list.tail.next = list.tail;
	}

	void splitPosition(int position) {
		CircularSLL list2 = new CircularSLL();
		int PosCount = 1;
		cnode temp = this.tail.next;
		while (PosCount != position) {
			temp = temp.next;
			PosCount++;
		}
		if (PosCount == position) {
			cnode t = temp.next;
			temp.next = tail;
			// tail.prev=temp;
			while (t != tail) {
				list2.insertLast(t.data);
				t = t.next;
			}
			System.out.print("List 1: ");
			display();
			System.out.print("List 2: ");
			list2.display();

			size = size - list2.size;

		}

	}

	void SplitHalf() {
		splitPosition(size / 2);
	}

	void SplitElement(int element) {
		int Position = 1;
		cnode temp = tail.next;
		while (temp.data != element) {
			temp = temp.next;
			Position++;
		}
		splitPosition(Position);
	}

	int count() {
		return size;
	}

	void sortedMerge(CircularSLL list) {
		CircularSLL tempList = new CircularSLL();
		cnode a = this.tail.next;
		cnode b = list.tail.next;
		while (a != this.tail && b != list.tail) {
			if (a.data < b.data) {
				tempList.insertLast(a.data);
				a = a.next;
			} else if (b.data < a.data) {
				tempList.insertLast(b.data);
				b = b.next;
			}
		}
		if (a == this.tail) {
			while (b != list.tail) {
				tempList.insertLast(b.data);
				b = b.next;
			}
		} else {
			while (a != this.tail) {
				tempList.insertLast(a.data);
				a = a.next;
			}
		}
		this.tail.next = tempList.tail.next;
		cnode t1 = tempList.tail.next;
		while (t1.next != tempList.tail) {
			t1 = t1.next;
		}
		t1.next = this.tail;
		list.tail.next = list.tail;
		this.size = this.size + list.size;
		list.size = 0;
	}

	void circularCheck() {
		cnode t = tail.next;
		for (int i = 0; i < size; i++) {
			t = t.next;
		}
		if (t == tail) {
			System.out.println("It is a circular List");
		} else
			System.out.println("Not a Circular List");
	}

}

public class circular_ll {

	public static void main(String[] args) {
		CircularSLL obj = new CircularSLL();
		CircularSLL obj1 = new CircularSLL();
		Scanner sc = new Scanner(System.in);
		int x, x1, x2, ele, posEle;
		do {
			System.out.println(
					"1.InsertFirst 2.InsertLast 3.Insertafter 4.InsertBefore 5.Display \n6.Search  7.MiddleElement 8.DeleteParticularElement 9.DeleteLast \n10.DeleteFirst 11.DeleteParticularPosition 12.RemoveDuplicates 13.Concatenate\n14.SplitPosition 15.SplitHalf 16.SplitatElement 17.MergeSortedList 18.CheckCircular 19.Count 20.Exit");
			x = sc.nextInt();
			switch (x) {
			case 1:
				System.out.print("Enter the data to be Inserted :");
				x1 = sc.nextInt();
				obj.insertFirst(x1);
				break;
			case 2:
				System.out.print("Enter the data to be Inserted :");
				x2 = sc.nextInt();
				obj.insertLast(x2);
				break;
			case 3:
				System.out.print("Enter Element to be Inserted : ");
				int x4 = sc.nextInt();
				System.out.print("Enter the before Element : ");
				int x5 = sc.nextInt();
				obj.insertafter(x4, x5);
				break;
			case 4:
				System.out.print("Enter Element to be Inserted : ");
				int x7 = sc.nextInt();
				System.out.print("Enter the after Element : ");
				int x8 = sc.nextInt();
				obj.insertbefore(x7, x8);
				break;
			case 5:
				System.out.print("List is ");
				obj.display();
				break;
			case 6:
				System.out.print("Enter the element to be Searched : ");
				ele = sc.nextInt();
				obj.search(ele);
				break;
			case 8:
				System.out.print("Enter the particular Element to be Deleted:");
				int x9 = sc.nextInt();
				obj.deleteParticularElement(x9);
				break;
			case 7:
				obj.middleElement();
				break;
			case 9:
				obj.deleteLast();
				break;
			case 10:
				obj.deleteFirst();
				break;
			case 11:
				System.out.println("\nEnter position of element to be deleted: ");
				int x10 = sc.nextInt();
				obj.deleteparticularPosition(x10);
				break;
			case 12:
				obj.removeDuplicates();
				break;
			case 13:
				CircularSLL l2 = new CircularSLL();
				int DLL2Size;
				System.out.print("Enter number of elements in second list: ");
				DLL2Size = sc.nextInt();
				for (int i = 0; i < DLL2Size; i++) {
					Scanner scanner = new Scanner(System.in);
					System.out.print("Enter element to insert into second list: ");
					int ele1 = scanner.nextInt();
					l2.insertFirst(ele1);
				}
				System.out.print("First List: ");
				obj.display();
				System.out.print("Second List: ");
				l2.display();

				obj.concatenate(l2);

				System.out.print("Concatenated List: ");
				obj.display();
				break;
			case 14:
				obj.display();
				System.out.print("Enter position where to split: ");
				int splitPos = sc.nextInt();
				obj.splitPosition(splitPos);
				break;
			case 15:
				obj.SplitHalf();
				break;
			case 16:
				System.out.print("Enter element where to split :");
				int splitele = sc.nextInt();
				obj.SplitElement(splitele);
				break;
			case 17:
				int size3, size4, i1 = 0, j1 = 0;
				// Scanner size = new Scanner(System.in);
				System.out.print("Enter number of elements in list 1: ");
				size3 = sc.nextInt();
				while (i1 < size3) {
					int elements1;
					System.out.print("Enter element to be inserted: ");
					elements1 = sc.nextInt();
					obj.insertFirst(elements1);
					i1++;
				}
				System.out.print("\nList 1 : ");
				obj.display();

				System.out.print("Enter number of elements in list 2: ");
				size4 = sc.nextInt();
				while (j1 < size4) {
					int elements2;
					System.out.print("Enter element to be inserted: ");
					elements2 = sc.nextInt();
					obj1.insertFirst(elements2);
					j1++;
				}
				System.out.print("List 2 : ");
				obj1.display();
				obj.sortedMerge(obj1);
				System.out.print("Merged Sorted list is : ");
				obj.display();
				System.out.println("\n");
				break;

			case 18:
				obj.circularCheck();
				break;
			case 19:
				int co = obj.count();
				System.out.println("The Total no.of Elements in List is : " + co);
				break;

			}

		} while (x != 20);

	}

}