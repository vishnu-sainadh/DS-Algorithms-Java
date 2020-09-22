package Tries;
import java.util.*;

class Dictionary_Trie_Node {
	int ALPHABET_SIZE = 26;
	Dictionary_Trie_Node[] children = new Dictionary_Trie_Node[ALPHABET_SIZE];
	boolean isEndOfWord;
	String meaning;

	Dictionary_Trie_Node() {
		isEndOfWord = false;
		for (int i = 0; i < ALPHABET_SIZE; i++)
			children[i] = null;
	}
}

class Dictionary_Tries {

	Dictionary_Trie_Node root;

	Dictionary_Tries() {
		root = null;
	}

	void insert(String key, String meaning) {
		int level;
		int length = key.length();
		int index;
		Dictionary_Trie_Node pCrawl = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';
			if (pCrawl.children[index] == null)
				pCrawl.children[index] = new Dictionary_Trie_Node();
			pCrawl = pCrawl.children[index];
		}

		pCrawl.isEndOfWord = true;
		pCrawl.meaning = meaning;
	}

	boolean search(String key) {
		int level;
		int length = key.length();
		int index;
		Dictionary_Trie_Node pCrawl = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';
			if (pCrawl.children[index] == null)
				return false;
			pCrawl = pCrawl.children[index];
		}

		if (pCrawl.isEndOfWord)
			System.out.println(key + " ---> " + pCrawl.meaning);

		return (pCrawl != null && pCrawl.isEndOfWord);
	}

	boolean LeafNode(Dictionary_Trie_Node node) {
		for (int i = 0; i < 26; i++)
			if (node.children[i] != null)
				return false;
		return true;
	}

	void Stemming_Meaning(Dictionary_Trie_Node PrefixEndNode, String CurrentPrefix) {
		if (PrefixEndNode.isEndOfWord) {
			System.out.println(CurrentPrefix + " --> " + PrefixEndNode.meaning);
		}

		if (LeafNode(PrefixEndNode))
			return;

		for (int i = 0; i < 26; i++) {
			if (PrefixEndNode.children[i] != null) {

				CurrentPrefix = CurrentPrefix + Character.toString((char) (97 + i));

				Stemming_Meaning(PrefixEndNode.children[i], CurrentPrefix);

				CurrentPrefix = CurrentPrefix.substring(0, CurrentPrefix.length() - 1);
			}
		}
	}

	int Check_Suggestions(String prefix) {
		Dictionary_Trie_Node pCrawl = this.root;
		int level;
		int n = prefix.length();
		int i=0;

		for (level = 0; level < n; level++) {
			int index = prefix.charAt(level) - 'a';
			if (pCrawl.children[index] == null) {
				break;
			}
			pCrawl = pCrawl.children[index];
			i++;
		}

		boolean isWord = (pCrawl.isEndOfWord == true);

		boolean isLast = LeafNode(pCrawl);
		
		if(i!=n) {
			System.out.println("No words starting with the prefix "+prefix);
		}
		
		if (isWord && isLast) {
			System.out.println(prefix + " --> " + pCrawl.meaning);
			return -1;
		}

		if (!isLast && i==n) {
			String pre = prefix;
			Stemming_Meaning(pCrawl, pre);
		}
		return 0;
	}

}

public class Dictionary_Tries_A1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Dictionary_Tries T = new Dictionary_Tries();
		T.root = new Dictionary_Trie_Node();
		String output = "Not present in Trie";

		T.insert("car", "Vehicle");
		T.insert("cat", "Animal");
		T.insert("carrot", "Vegetable");
		T.insert("carrom", "Game");
		T.insert("cattle", "Group of animals");
		
		while (true) {
			System.out.println("Choose:\t1.Insert\t2.Search\t3.Suggestions\t0.Exit");
			int choose = sc.nextInt();
			if (choose == 0) {
				System.out.print("End");
				break;
			}
			switch (choose) {
			case 1:
				System.out.print("Enter word to insert in the Trie : ");
				String w = sc.next();
				System.out.print("Enter meaning for "+w+" : ");
				String m = sc.next();
				T.insert(w, m);
				break;
			case 2: 
				System.out.print("Enter word to search in the Trie : ");
				String word = sc.next();
				if (T.search(word) != true)
					System.out.println(word + " ---> " + output);
				break;
			case 3: 
				System.out.print("Enter a prefix to get suggestins of a word : ");
				String prefix = sc.next();
				T.Check_Suggestions(prefix);
				break;
			}
		}
		
	}
}
