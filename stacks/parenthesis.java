package stacks;
import java.util.*;
public class parenthesis
{
public static void main(String s[])
{
Scanner sc=new Scanner(System.in) ;
String data;
char c,k,j;

Stack ss=new Stack();
System.out.println("Enter the string");
data=sc.nextLine();
for(int i=0;i<data.length();i++)
{

c =(char)data.charAt(i);


if((c=='{' )||(c=='[')||(c=='('))
{
ss.push(c);

}
else if((c=='}' )||(c==']')||(c==')'))
{
k=(char)ss.peek();

j=k;
if(j=='{')
{
if(c=='}')
{
ss.pop();
}
else if((c==']')||(c==')'))
{
System.out.println("Incorrect bracket order");
break;
}
}
else if(j=='[')
{
if(c==']')
{
ss.pop();
}
else if((c=='}')||(c==')'))
{
System.out.println("Incorrect bracket order");
break;
}
}
else if(j=='(')
{

if(c==')')
{
ss.pop();
}
else if((c==']')||(c=='}'))
{
System.out.println("Incorrect bracket order");
break;
}
}
}
}

if(ss.isEmpty())
System.out.println("Your String has correct bracket order");
}
}

