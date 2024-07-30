package Google.July;

import java.util.Stack;

public class Remove_K_Digits2 {

    public String removeKdigits(String num, int k) {

        Stack<Integer> stack = new Stack<>();
        String ans ="";
        int count =0;
        for (Character c:num.toCharArray()){
            while (!stack.isEmpty() && stack.peek()>Character.getNumericValue(c) && count<k){
                stack.pop();
                count++;
            }
            stack.push(Character.getNumericValue(c));

        }
        // System.out.println(stack);
        boolean start = true;
        for (int i:stack){
            if (start && i==0){
                // if (count<k){
                //     count++;
                // }

                continue;

            }
            ans+= i;
            start= false;

        }
        // System.out.println(ans);
        ans = ans.substring(0,Math.max(0,ans.length()-(k-count)));
        // System.out.println(ans);
        return ans.isEmpty() ? "0": ans;
    }

}
