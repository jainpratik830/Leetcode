package Google.April;

import java.util.Stack;

public class Remove_K_Digits {



    public String removeKdigits(String num, int k) {

       if (k==num.length()){
           return "0";
       }

       String ans ="";
        Stack<Integer> stack= new Stack<>();
        for (int i=0;i<num.length();i++){
            while (stack.size()>0 && k>0 && stack.peek()>(num.charAt(i)-'0')){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i)-'0');

        }
        for(int i=0; i<k; ++i) {
            stack.pop();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for(int digit: stack) {
            if(leadingZero && digit == 0) continue;
            leadingZero = false;
            ret.append(digit);
        }

        if (ret.length() == 0) return "0";
        return ret.toString();
    }


}
