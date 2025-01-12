package Mission_2025.January.Stack;

import java.util.Stack;

public class Daily_Temperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack=  new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i=0;i<temperatures.length;i++){

            while (!stack.isEmpty() && temperatures[stack.peek()]< temperatures[i]){
                int curr =stack.pop();
                ans[curr]= i-curr;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()){
            ans[stack.pop()]=0;
        }
        return ans;

    }

}
