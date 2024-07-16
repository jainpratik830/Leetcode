package Google.July;

import java.util.Stack;

public class Basic_Calculator {


    public int calculate(String s) {
        Stack<Integer> stack =new Stack<>();
        int res = 0;
        if (s == null || s.length() == 0) return res;
        int sign=1;
        for (int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if (Character.isDigit(curr)){
                int val =0;
                while (i<s.length() && Character.isDigit(s.charAt(i))){
                    val = val*10+ (s.charAt(i)-'0');
                    i++;
                }
                i--;
                val= val*sign;
                sign=1;
                res += val;
            }else if (curr=='('){
                stack.push(res);
                stack.push(sign);
                res=1;
                sign=1;
            }else if (curr==')'){
                sign= stack.pop();
                res= stack.pop();
            }else if (curr=='-'){
                sign=-1;
            }
        }
        return res;
    }

}
