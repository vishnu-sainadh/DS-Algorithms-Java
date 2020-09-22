package trees;

import java.util.*;

class avlnode {
	int key, height;
	avlnode left, right;

	avlnode(int d) {
		key = d;
		height = 1;
	}
}

class AVL {

	avlnode root;

	int height(avlnode N) {
		if (N == null)
			return 0;

		return N.height;
	}

	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	avlnode rightRotate(avlnode y) {
		avlnode x = y.left;
		avlnode T2 = x.right;

		x.right = y;
		y.left = T2;

		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		return x;
	}

	avlnode leftRotate(avlnode x) {
		avlnode y = x.right;
		avlnode T2 = y.left;

		y.left = x;
		x.right = T2;

		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		return y;
	}

	int getBalance(avlnode N) {
		if (N == null)
			return 0;

		return height(N.left) - height(N.right);
	}

	avlnode insert(avlnode node, int key) {

		/* 1. Perform the normal BST insertion */
		if (node == null)
			return (new avlnode(key));

		if (key < node.key)
			node.left = insert(node.left, key);
		else if (key > node.key)
			node.right = insert(node.right, key);
		else // Duplicate keys not allowed
			return node;

		/* 2. Update height of this ancestor node */
		node.height = 1 + max(height(node.left), height(node.right));

		/*
		 * 3. Get the balance factor of this ancestor node to check whether this node
		 * became unbalanced
		 */
		int balance = getBalance(node);

		// If this node becomes unbalanced, then there are 4 cases

		// Left Left Case
		if (balance > 1 && key < node.left.key) {
			System.out.print("Inserting " + key + " is LL case.\nSo performed Right Rotation.\n");
			return rightRotate(node);
		}

		// Right Right Case
		if (balance < -1 && key > node.right.key) {
			System.out.print("Inserting " + key + " is RR case.\nSo performed Left Rotation.\n");
			return leftRotate(node);
		}

		// Left Right Case
		if (balance > 1 && key > node.left.key) {
			System.out.print("Inserting " + key + " is LR case.\n"
					+ "So performed Left Rotation at left child of critical node\n"
					+ "followed by Right Rotation at critical node\n");
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Case
		if (balance < -1 && key < node.right.key) {
			System.out.print("Inserting " + key + " is RL case.\n"
					+ "So performed Right Rotation at right child of critical node\n"
					+ "followed by Left Rotation at critical node\n");
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		/* return the (unchanged) node pointer */
		return node;
	}

	void preOrder(avlnode node) {
		if (node != null) {
			System.out.print(node.key + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	void InOrder(avlnode node) {
		if (node != null) {
			InOrder(node.left);
			System.out.print(node.key + " ");
			InOrder(node.right);
		}
	}

	boolean SearchRec(avlnode T, int value) {
		boolean flag = false;
		avlnode temp = T;
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

	public static void main(String[] args) {
		AVL tree = new AVL();
		Scanner sc = new Scanner(System.in);
		int ch, dd;
		do {
			System.out.println(
					"Enter your choice\n" + "0.exit\n" + "1.Insert\n" + "2.Preorder\n" + "3.Inorder\n" + "4.Search");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter the data to be inserted");
				dd = sc.nextInt();
				tree.root = tree.insert(tree.root, dd);
				break;
			case 2:
				System.out.println("Preorder traversal of constructed tree is : ");
				tree.preOrder(tree.root);
				System.out.println("");
				break;
			case 3:
				System.out.println("Inorder traversal of constructed tree is : ");
				tree.InOrder(tree.root);
				System.out.println("");
				break;
			case 4:
				System.out.println("Enter the data to be searched:");
				dd = sc.nextInt();
				if (tree.SearchRec(tree.root, dd))
					System.out.println("Found");
				else
					System.out.println("Not Found");
				break;
			}
		} while (ch != 0);

	}
}