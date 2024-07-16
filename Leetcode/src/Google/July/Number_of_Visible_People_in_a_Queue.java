package Google.July;

import java.util.Stack;

public class Number_of_Visible_People_in_a_Queue {

    public int[] canSeePersonsCount(int[] heights) {
        int[] ans = new int[heights.length];
        Stack<Integer> stack= new Stack<>();
        for (int i=heights.length-1;i>=0;i--){
            while (!stack.isEmpty() && heights[stack.peek()]<=heights[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                ans[i]=0;
            }else {
                ans[i]=stack.size();
            }
            stack.add(i);
        }

        return ans;
    }

}
