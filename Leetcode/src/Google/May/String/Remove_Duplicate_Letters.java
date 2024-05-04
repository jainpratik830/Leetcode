package Google.May.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Remove_Duplicate_Letters {

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        HashSet<Character> seen= new HashSet<>();
        HashMap<Character, Integer> last_occurrence = new HashMap<>();
        for(int i = 0; i < s.length(); i++) last_occurrence.put(s.charAt(i), i);
        for (int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if (!seen.contains(curr)){

                while (!stack.isEmpty() && curr<stack.peek() && last_occurrence.get(stack.peek())>i){
                    seen.remove(stack.pop());
                }
                stack.add(curr);
                seen.add(curr);

            }

        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c:stack){
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

}
