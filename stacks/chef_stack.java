package stacks;

import java.util.Scanner;
import java.util.Stack;

public class chef_stack {
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number of coins");
        int n=in.nextInt();
        int i=0;
        int b=0;
        Stack<Integer> s[]=new Stack[n];
        while(i<=n)
        {		i+=1;
            s[i]=new Stack<Integer>();
            for(int j=1;j<=i;j++)
                s[i].push(1);
            n-=i;
        }
        
        if(n!=0)
        {i++;
        	s[i]=new Stack<Integer>();
        for(int k=0;k<n;k++)
        {s[i].push(1);}
        }
        
        for(b=1;b<=i;b++)
        {
            System.out.println(s[b]);
        }
        
        System.out.println("The total number of stack created are:"+(b-1));
    }
}