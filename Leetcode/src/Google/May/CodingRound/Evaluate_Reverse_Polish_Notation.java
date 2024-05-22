package Google.May.CodingRound;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s:tokens){
            if (s.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b+a);
            }else if (s.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            }else if (s.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b*a);
            }else if (s.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            }else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

}
