package Google.April;

import java.util.Stack;

public class Plus_One {

    public int[] plusOne(int[] digits) {
        Stack<Integer> list = new Stack<>();
        int carry =1;
        // int toAdd = 1;
        int curr=0;
        for (int i=digits.length-1;i>=0;i--){
            curr= digits[i]+carry;
            curr = curr%10;
            carry = curr/10;
            list.push(curr);

        }
        System.out.println(carry);
        if (carry!=0){
            list.push(carry);
        }

        int[] ans  = new int[list.size()];

        int i=0;
        while (!list.isEmpty()){
            ans[i++]= list.pop();
        }

        return ans;
    }

}
