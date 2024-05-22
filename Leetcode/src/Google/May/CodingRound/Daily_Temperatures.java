package Google.May.CodingRound;

import java.util.Stack;

public class Daily_Temperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<temperatures.length;i++){
            if (stack.isEmpty()){
                stack.push(i);
            }else {
                while (!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                    int curr = stack.pop();
                    ans[curr]=i-curr;
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty() ){
            int curr = stack.pop();
            ans[curr]=0;
        }

        return ans;
    }

}
