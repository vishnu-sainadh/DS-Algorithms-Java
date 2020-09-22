package String_Matching;

import java.util.*;

public class kmplab { 
	void KMPSearch(String pat, String txt) 
	{ 
		int M = pat.length(); 
		int N = txt.length(); 
		int lps[] = new int[M]; 
		int j = 0;  
		computeLPSArray(pat, M, lps); 
		int i = 0; 
		int count=0;
		while (i < N) { 
			if (pat.charAt(j) == txt.charAt(i)) { 
				j++; 
				i++; 
			} 
			if (j == M) { 
				System.out.println("Found pattern "+ "at index " + (i - j)); 
				j = lps[j - 1]; 
				count++;
			} 
			else if (i < N && pat.charAt(j) != txt.charAt(i)) {  
				if (j != 0) 
					j = lps[j - 1]; 
				else
					i = i + 1; 
			} 
		} 
		System.out.println("count is:" + count);
		
	} 
	
	void computeLPSArray(String pat, int M, int lps[]) 
	{  
		int len = 0; 
		int i = 1; 
		lps[0] = 0;   
		while (i < M) { 
			if (pat.charAt(i) == pat.charAt(len)) { 
				len++; 
				lps[i] = len; 
				i++; 
			} 
			else  
			{  
				if (len != 0) { 
					len = lps[len - 1]; 
				} 
				else  
				{ 
					lps[i] = len; 
					i++; 
				} 
			} 
		} 
	} 

	public static void main(String args[]) 
	{ 
		Scanner s=new Scanner(System.in);
		String txt = "HELLOWORLDHELLO"; 
		String pat = "HELLO"; 
		int pat_len=3;
		pat=pat.substring(0, pat_len);
		kmplab k=new kmplab();
		k.KMPSearch(pat, txt);
	} 
} 
 
