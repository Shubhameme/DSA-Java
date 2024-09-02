package dsa.stack;

import java.util.Stack;

public class StringReverse {

    public static String reverse(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        
        // Push each character onto the stack
        for (char c : chars) {
            stack.push(c);
        }
        
        // Pop each character off the stack and store it back in the array
        for (int i = 0; i < str.length(); i++) {
            chars[i] = stack.pop();
        }
        
        return new String(chars);
    }
    
    public static void main(String[] args) {
       String str = "ABCD";
       System.out.print("Orignal String: ");
       System.out.println(str);
       
     System.out.println("Reversed: "+ reverse(str));
    }
}
