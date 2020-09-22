package Tries;
import java.util.*;

class TrieNode {
	int ALPHABET_SIZE = 26;
	TrieNode[] children = new TrieNode[ALPHABET_SIZE];
	boolean isEndOfWord;

	TrieNode() {
		isEndOfWord = false;
		for (int i = 0; i < ALPHABET_SIZE; i++)
			children[i] = null;
	}
}

class Tries {

	TrieNode root;

	Tries() {
		root = null;
	}

	void insert(String key) {
		int level;
		int length = key.length();
		int index;

		TrieNode pCrawl = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';
			if (pCrawl.children[index] == null)
				pCrawl.children[index] = new TrieNode();

			pCrawl = pCrawl.children[index];
		}

		pCrawl.isEndOfWord = true;
	}

	boolean search(String key) {
		int level;
		int length = key.length();
		int index;
		TrieNode pCrawl = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';

			if (pCrawl.children[index] == null)
				return false;

			pCrawl = pCrawl.children[index];
		}

		return (pCrawl != null && pCrawl.isEndOfWord);
	}
	
}

public class TriesImpl {
	public static void main(String args[]) {
		String output = "Not present in Trie";

		Tries T = new Tries();
		T.root = new TrieNode();

		T.insert("car");
		T.insert("cat");

		if (T.search("car") != true)
			System.out.println("car --- " + output);

		if (T.search("ca") != true)
			System.out.println("ca --- " + output);

		if (T.search("cat") != true)
			System.out.println("cat --- " + output);

	}
}