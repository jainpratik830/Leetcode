package Google.September;

import java.util.Stack;

public class Minimum_String_Length_After_Removing_Substrings {

    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        int i=0;
        while (i<s.length()){
            if (stack.isEmpty() || (stack.peek() != 'A' && stack.peek()!= 'C')){
                stack.push(s.charAt(i));
                i++;
            }else {
                if (s.charAt(i)=='B' && stack.peek()=='A'){
                    stack.pop();
                    i++;
                }
                else if (s.charAt(i)=='D' && stack.peek()=='C'){
                    stack.pop();
                    i++;
                }else {
                    stack.push(s.charAt(i));
                    i++;
                }
            }
        }

        return stack.size();
    }

}
