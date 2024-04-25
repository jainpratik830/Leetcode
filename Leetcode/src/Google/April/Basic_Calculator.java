package Google.April;

import java.util.Stack;

public class Basic_Calculator {


    public int calculate(String s) {
        int res = 0;
        if (s == null || s.length() == 0) return res;

        Stack<Integer> stack = new Stack<>();
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // calculates current numbers
            if (Character.isDigit(c)) {
                int val =0;
                while (i<s.length() && Character.isDigit(s.charAt(i))){
                    val = val *10 + (s.charAt(i)-'0');
                    i++;

                }
                i--;
                val = val*sign;
                sign=1;
                res += val;
            } else if (c == '(') {
                // memorizes the most recent operator
                stack.push(res);
                stack.push(sign);
                sign=1;
                res=0;
            } else if (c == ')') {
                res *=stack.pop();
                res+=stack.pop();
            }else if (c=='-'){
                sign=-1;
            }
        }
        return res;
    }

}
