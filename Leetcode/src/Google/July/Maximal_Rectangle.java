package Google.July;

import java.util.Stack;

public class Maximal_Rectangle {

    public int calArea(int[] height){
        int max = Integer.MIN_VALUE;
        if (height.length==1){
            return height[0];
        }else {
            int[] left = new int[height.length];
            Stack<Integer> stack = new Stack<>();
            left[0] = 0;
            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    left[i] = 0;
                } else {
                    left[i] = stack.peek() + 1;
                }
                stack.push(i);
            }

            int[] right = new int[height.length];
            stack = new Stack<>();
            right[height.length - 1] = 0;
            for (int i = height.length-1; i >= 0; i--) {
                while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    right[i] = height.length - 1;
                } else {
                    right[i] = stack.peek() - 1;
                }
                stack.push(i);
            }
            for (int i=0;i<height.length;i++){
                max = Math.max(max,(right[i]-left[i]+1)*height[i]);

            }
            return max;
        }

    }

    public int maximalRectangle(char[][] matrix) {

        int[] height =new int[matrix[0].length];
        int ans =0;
        for (int i=0;i<matrix.length;i++){

            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]=='0'){
                    height[j]=0;
                }else {
                    height[j]=1+ height[j];
                }
            }

            ans = Math.max(ans,calArea(height));
        }

        return ans;
    }

}
