package String_Matching;
import java.util.*;

public class Sub_String {
   public static void main(String args[]) {
      String str = "Sub String";
      String substr = "Str";
      int n = str.length();
      int m = substr.length();
      System.out.println("String: " + str);
      System.out.println("Substring: " + substr);
      for (int i = 0; i <= n - m; i++) {
         int j;
         for (j = 0; j < m; j++) {
            if (str.charAt(i + j) != substr.charAt(j))
               break;
         }
         if (j == m) {
            System.out.println("Substring is at index " + i);
            return;
         }
      }
      System.out.println("Substring is not in the string");
   }
}

