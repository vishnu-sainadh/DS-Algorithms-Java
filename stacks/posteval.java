package stacks;
import java.util.*;

public class posteval {
static boolean isdigit(Object ch) {
if ((char) ch >= '0' && (char) ch <= '9')
return true;
else
return false;
}

static boolean isoperator(Object ch) {
if ((char) ch == '+' || (char) ch == '-' || (char) ch == '*' || (char)
ch == '/' || (char) ch == '^')
return true;
else
return false;
}

public static void main(String s[]) {
Stack s1 = new Stack();
System.out.println("enter the string:");
Scanner sc = new Scanner(System.in);
String postfix = sc.next();
for (int i = 0; i < postfix.length(); i++) {
char ch = postfix.charAt(i);
if (isdigit(ch))
s1.push(ch - 48);
else if (isoperator(ch)) {
int temp2 = (int) s1.pop();
int temp1 = (int) s1.pop();
int result = 0;
switch (ch) {
case '+':
result = temp1 + temp2;
break;
case '-':
result = temp1 - temp2;
break;
case '*':
result = temp1 * temp2;
break;
case '/':
result = temp1 / temp2;
break;
case '^':
result = temp1 ^ temp2;
break;
}
s1.push(result);
}
}
System.out.println("result is:" + s1.pop());

}
}