package Google.March;

import java.util.Stack;

public class Maximal_Rectangle {

    public static int calcArea(int[] height){
        int max = Integer.MIN_VALUE;
        if (height.length==1){
            return height[0];
        }else{

            int[] lsv= new int[height.length];
            int[] rsv = new int[height.length];
            Stack<Integer> stack = new Stack<>();
            for (int i=0;i<height.length;i++){
                while (!stack.isEmpty() && height[stack.peek()]>=height[i]){
                    stack.pop();
                }
                if (stack.isEmpty()){
                    lsv[i]=0;
                }else {
                    lsv[i]= stack.peek()+1;
                }
                stack.add(i);

            }

            stack=new Stack<>();
            for (int i=height.length-1;i>=0;i--){
                while (!stack.isEmpty() && height[stack.peek()]>=height[i]){
//                    System.out.println(stack.peek());
                    stack.pop();
                }
                if (stack.isEmpty()){
                    rsv[i]=height.length-1;
                }else {
                    rsv[i]= stack.peek()-1;
                }
                stack.add(i);
            }
            for (int i=0;i<height.length;i++){
                max = Math.max(max,((rsv[i]-lsv[i]+1)*height[i]));
            }
        }
        return max;
    }

    public static void main(String[] args){
        calcArea(new int[]{2,1,5,6,2,3,1});
    }

    public int maximalRectangle(char[][] matrix) {
        int[] height = new int[matrix[0].length];
        int ans = 0;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]!=0){
                    height[j]+=1;
                }else{
                    height[j]=0;
                }
            }

            ans = Math.max(ans,calcArea(height));
        }

        return ans;
    }

}
