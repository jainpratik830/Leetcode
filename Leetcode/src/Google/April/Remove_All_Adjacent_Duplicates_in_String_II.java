package Google.April;

import java.util.Stack;

public class Remove_All_Adjacent_Duplicates_in_String_II {

    public String removeDuplicates(String s, int k) {

        Stack<Character> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();

        int i=0;
        while (i<s.length()){

            if (!stack.isEmpty()){
                if (!stack.isEmpty() && stack.peek()==s.charAt(i) && count.peek()==k-1){
                    int j=k-1;
                    while (!stack.isEmpty() && j>0){
                        stack.pop();
                        count.pop();
                        j--;
                    }
                }else{
                    if (stack.peek()==s.charAt(i)){
                        stack.push(s.charAt(i));
                        count.push(count.peek()+1);
                    }else {
                        stack.push(s.charAt(i));
                        count.push(1);
                    }
                }


            }else {
                stack.push(s.charAt(i));
                count.push(1);
            }
            i++;

        }

        StringBuilder ans = new StringBuilder();
        for (char c:stack){
            ans.append(c);
        }

        return ans.toString();

    }

}
