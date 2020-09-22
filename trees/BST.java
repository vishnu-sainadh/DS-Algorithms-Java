package trees;

import java.util.*;

class bstnode {
	bstnode left;
	int key;
	bstnode right;

	public bstnode(int item) {
		key = item;
		left = right = null;
	}
}

class BST {
	bstnode root;
	int cleaf = 0;
	int cinternal = 0;
	int cnodes = 0;
	private Stack<bstnode> s1;
	private Stack<bstnode> s2;

	BST() {
		root = null;
		s1 = new Stack<bstnode>();
		s1 = new Stack<bstnode>();
	}

	bstnode insertrec(bstnode r, int key) {
		if (r == null) {
			r = new bstnode(key);
			return r;
		}
		if (key < r.key)
			r.left = insertrec(r.left, key);
		else if (key > r.key)
			r.right = insertrec(r.right, key);

		return r;
	}

	void InOrder(bstnode root) {
		if (root == null)
			return;
		InOrder(root.left);
		System.out.println(root.key);
		InOrder(root.right);
	}

	void PreOrder(bstnode root) {
		if (root == null)
			return;
		System.out.println(root.key);
		PreOrder(root.left);
		PreOrder(root.right);
	}

	void PostOrder(bstnode root) {
		if (root == null)
			return;
		PostOrder(root.left);
		PostOrder(root.right);
		System.out.println(root.key + " ");
	}

	boolean SearchRec(bstnode T, int value) {
		boolean flag = false;
		bstnode temp = T;
		if (T == null)
			return flag;
		else if (value == temp.key) {
			flag = true;
			return flag;
		} else if (value < temp.key) {
			return (SearchRec(temp.left, value));
		} else {
			return (SearchRec(temp.right, value));
		}
	}

	int Smallest() {
		bstnode t = root;
		if (root != null) {
			while (t.left != null) {
				t = t.left;
			}
			return t.key;
		} else
			return -1;
	}

	int Largest() {
		bstnode t = root;
		if (root != null) {
			while (t.right != null) {
				t = t.right;
			}
			return t.key;
		} else
			return -1;
	}

	void CountLeaf(bstnode root) {
		if (root != null) {
			CountLeaf(root.left);
			if ((root.left == null) && (root.right == null)) {
				cleaf++;
			}
			CountLeaf(root.right);
		}
	}

	void CountInternal(bstnode root) {
		if (root != null) {
			CountInternal(root.left);
			if ((root.left != null) || (root.right != null)) {
				cinternal = cinternal + 1;
				CountInternal(root.right);
			}
		}
	}

	void CountNodes(bstnode root) {
		if (root != null) {
			CountNodes(root.left);
			cnodes++;
			CountNodes(root.right);
		}
	}

	int TreeHeight(bstnode r) {
		if (r == null)
			return 0;
		else {
			int left_Depth = TreeHeight(r.left);
			int right_Depth = TreeHeight(r.right);
			if (left_Depth > right_Depth)
				return (left_Depth + 1);
			else
				return (right_Depth + 1);
		}
	}

	void InorderPredecessor(int value) {
		bstnode t = this.root;
		bstnode p = this.root;
		bstnode y = this.root;
		if (y == null) {
			System.out.println("TREE IS EMPTY");
		} else {
			while (y != null) {
				if (value == y.key) {
					t = y;
					break;
				} else if (value < y.key) {
					y = y.left;
				} else if (value > y.key) {
					y = y.right;
				}
			}
			t = t.left;
			while (t != null) {
				p = t;
				t = t.right;
			}
			System.out.println("Inorder Predecessor of " + value + "is:" + p.key);
		}
	}

	void InorderSuccessor(int value) {
		bstnode t = this.root;
		bstnode p = this.root;
		bstnode y = this.root;
		if (y == null) {
			System.out.println("TREE IS EMPTY");
		} else {
			while (y != null) {
				if (value == y.key) {
					t = y;
					break;
				} else if (value < y.key) {
					y = y.left;
				} else if (value > y.key) {
					y = y.right;
				}
			}
			t = t.right;
			while (t != null) {
				p = t;
				t = t.left;
			}
			System.out.println("Inorder Successor of " + value + "is:" + p.key);
		}
	}

	boolean Path(bstnode r, int value) {
		boolean flag = false;
		bstnode temp = r;
		if (r == null) {
			return flag;
		} else if (value == temp.key) {
			flag = true;
			return flag;
		} else if (value < temp.key) {
			System.out.println(r.key);
			return Path(temp.left, value);
		} else {
			System.out.println(r.key);
			return Path(temp.right, value);
		}
	}

	bstnode ParentNode(bstnode T, int value) {
		if (T == null) {
			return null;
		}
		bstnode getparent = null;
		while (T != null) {
			if (value < T.key) {
				getparent = T;
				T = T.left;
			} else if (value > T.key) {
				getparent = T;
				T = T.right;
			} else {
				break;
			}
		}
		return getparent;
	}

	public static void main(String[] args) {
		BST T = new BST();
		BST T1 = new BST();
		T.root = T.insertrec(T.root, 6);
		T.root = T.insertrec(T.root, 4);
		T.root = T.insertrec(T.root, 8);
		T1.insertrec(T1.root, 5);
		T1.insertrec(T1.root, 3);
		T1.insertrec(T1.root, 4);
		T1.insertrec(T1.root, 8);
		Scanner sc = new Scanner(System.in);
		int ch, dd;
		do {
			System.out.println("Enter your choice\n" + "0.exit\n" + "1.Insert " + "2.Inorder " + "3.Preorder"
					+ "\n4.Postorder " + "5.Search " + "6.Smallest value " + "\n7.Largest value " + "8.Countleaf "
					+ "9.CountInternal " + "\n10.CountNodes " + "11.Height of Tree " + "12.Depth of Tree "
					+ "\n13.Inorder Predecessor " + "14.Inorder Successor " + "15.Path " + "\n16.get parent node");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter the data to be inserted");
				dd = sc.nextInt();
				T.root = T.insertrec(T.root, dd);
				break;
			case 2:
				System.out.println("inorder");
				T.InOrder(T.root);
				break;
			case 3:
				System.out.println("preorder");
				T.PreOrder(T.root);
				break;
			case 4:
				System.out.println("postorder");
				T.PostOrder(T.root);
				break;
			case 5:
				System.out.println("Enter the data to be searched:");
				dd = sc.nextInt();
				if (T.SearchRec(T.root, dd))
					System.out.println("Found");
				else
					System.out.println("Not Found");
				break;
			case 6:
				System.out.println("Smallest Element in the tree is:" + T.Smallest());
				break;
			case 7:
				System.out.println("Largest Element in the tree is:" + T.Largest());
				break;
			case 8:
				T.CountLeaf(T.root);
				System.out.println("No of leaves:" + T.cleaf);
				T.cleaf = 0;
				break;
			case 9:
				T.CountInternal(T.root);
				System.out.println("No of Internal nodes:" + T.cinternal);
				T.cinternal = 0;
				break;
			case 10:
				T.CountNodes(T.root);
				System.out.println("No of nodes:" + T.cnodes);
				T.cnodes = 0;
				break;
			case 11:
				System.out.println("Height of the tree is:" + T.TreeHeight(T.root));
				break;
			case 12:
				System.out.println("Depth of the tree is:" + T.TreeHeight(T.root));
				break;
			case 13:
				System.out.println("Enter the element:");
				dd = sc.nextInt();
				if (T.SearchRec(T.root, dd)) {
					T.InorderPredecessor(dd);
				} else {
					System.out.println("Element not found");
				}
				break;
			case 14:
				System.out.println("Enter the element:");
				dd = sc.nextInt();
				if (T.SearchRec(T.root, dd)) {
					T.InorderSuccessor(dd);
				} else {
					System.out.println("Element not found");
				}
				break;
			case 15:
				System.out.println("search an element for its path:");
				dd = sc.nextInt();
				if (T.SearchRec(T.root, dd)) {
					T.Path(T.root, dd);
					System.out.println("element found");
				} else
					System.out.println("Not Found");
				break;
			case 16:
				System.out.println("Enter the data to be searched for parent:");
				dd = sc.nextInt();
				if (T.SearchRec(T.root, dd)) {
					if (dd != (T.root).key) {
						System.out.println("Parent of " + dd + "is:" + (T.ParentNode(T.root, dd)).key);
					} else {
						System.out.println("Parent for this node doesnot exist\n this is root node");
					}
				} else
					System.out.println("Not Found");
				break;
			}
		} while (ch != 0);
		System.out.println("End");
	}
}