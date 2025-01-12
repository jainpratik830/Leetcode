package Mission_2025.January.Stack;

import java.util.HashMap;
import java.util.Stack;

public class Valid_Parentheses {

    public boolean isValid(String s) {

        HashMap<Character,Character> map= new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()){
            if (map.values().contains(c)){
                stack.push(c);
            }else {
                if (!stack.isEmpty() && map.get(c).equals(stack.peek())){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
