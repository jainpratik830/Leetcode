package Google.May.Neetcode150;

import java.util.Arrays;
import java.util.Stack;

public class Largest_Rectangle_in_Histogram {

    public int largestRectangleArea(int[] height) {
        if (height.length==1){
            return height[0];
        }
        int n =height.length;
        int[] lsv = new int[n];
        int[] rsv = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i=0;i<n;i++){
           while (!stack.isEmpty() && height[stack.peek()]>=height[i]){
               stack.pop();
           }
           if (stack.isEmpty()){
               lsv[i]=0;
           }else {
               lsv[i]=stack.peek()+1;
           }
           stack.push(i);
        }

        stack = new Stack<>();

        for (int i=n-1;i>=0;i--){
            while (!stack.isEmpty() && height[stack.peek()]>=height[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                rsv[i]=n-1;
            }else {
                rsv[i]=stack.peek()-1;
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(lsv));
        System.out.println(Arrays.toString(rsv));
        int max = Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            max = Math.max(max,height[i]*(rsv[i]-lsv[i]+1));
        }
        return max;
    }

}
