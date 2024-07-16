package Google.July;

import java.util.Stack;

public class Remove_K_Digits {

    public String removeKdigits(String num, int k) {

        if (k==num.length()){
            return "0";
        }

        Stack<Integer> stack = new Stack<>();
        for (char c:num.toCharArray()){
            while (!stack.isEmpty() && k>0 && stack.peek()>(c-'0')){
                stack.pop();
                k--;
            }
            stack.push((c-'0'));
        }
        for (int i=0;i<k;i++){
            stack.pop();
        }

        boolean leadingZero = true;
        StringBuilder result = new StringBuilder();
        for (int i:stack){
            if (leadingZero && i==0){
                continue;
            }
            leadingZero=false;
            result.append(i);

        }

        return result.length()==0 ? "0" : result.toString();

    }

}
