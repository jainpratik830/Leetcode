package Google.April;

import java.util.Stack;

public class Remove_All_Adjacent_Duplicates_In_String {

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        int i=0;
        while (i<s.length()){
            if (!stack.isEmpty()){
                if (stack.peek()==s.charAt(i)){
                    // while (i<s.length()&& stack.peek()==s.charAt(i++));
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));

                }
            }else {
                stack.push(s.charAt(i));
                // i++;
            }
            i++;

        }

        StringBuilder ans = new StringBuilder();
        for (char c:stack){
            ans.append(c);
        }

        return ans.toString();
    }


}
