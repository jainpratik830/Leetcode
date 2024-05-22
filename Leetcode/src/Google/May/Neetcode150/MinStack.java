package Google.May.Neetcode150;

import java.util.Map;
import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> mins;

    public MinStack() {
        stack = new Stack<>();
        mins = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (mins.isEmpty()){
            mins.push(val);
        }else {
            mins.push(Math.min(mins.peek(),val));
        }
    }

    public void pop() {
        stack.pop();
        mins.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mins.peek();
    }


}
