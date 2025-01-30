package Zeta;

import java.util.Stack;

public class Remove_K_Digits {

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int count =k;
        for (int i=0;i<num.length();i++){

            while (!stack.isEmpty() && stack.peek()>=Character.getNumericValue(num.charAt(i)) && count>0){
                stack.pop();
                count--;
            }
            System.out.println("Stack="+stack);
            stack.push(num.charAt(i));
        }

        while (count>0){
            stack.pop();
            count--;
        }

        StringBuilder ans = new StringBuilder();
        boolean first = true;
        for (char c:stack){
            if (first && c=='0'){
                continue;
            }
            first=false;
            ans.append(c);
        }
        return ans.toString().length()==0 ? "0" : ans.toString();
    }

}
