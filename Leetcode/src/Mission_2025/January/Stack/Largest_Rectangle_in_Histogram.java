package Mission_2025.January.Stack;

import java.util.Map;
import java.util.Stack;

public class Largest_Rectangle_in_Histogram {

    public int largestRectangleArea(int[] height) {
        int ans =0;
        int n =height.length;
        int[] leftMost= new int[n];
        int[] rightMost = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<n;i++){
            while (!stack.isEmpty() && height[stack.peek()]>=height[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                leftMost[i]=0;
            }else {
                leftMost[i]=stack.peek()+1;
            }
            stack.push(i);
        }

        stack = new Stack<>();
        for (int i=n-1;i>=0;i--){
            while (!stack.isEmpty() && height[stack.peek()]>=height[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                rightMost[i]=n-1;
            }else {
                rightMost[i]=stack.peek()-1;
            }
            stack.push(i);
        }

        for (int i=0;i<n;i++){
            ans = Math.max(ans,height[i]*(rightMost[i]-leftMost[i]+1));
        }
        return ans;
    }

}
