package Google.August;

import java.util.Stack;

public class Find_the_Most_Competitive_Subsequence {

    public int[] mostCompetitive(int[] nums, int k) {
        int toRemove = nums.length-k;

        Stack<Integer> stack = new Stack<>();

        for (int i:nums){
            while (!stack.isEmpty() && stack.peek()>i && toRemove>0){
                stack.pop();
                toRemove--;
            }
            stack.push(i);
        }

        while (toRemove > 0){
            stack.pop();
            toRemove--;
        }

        int[] ans = stack.stream().mapToInt(i->i).toArray();
        return ans;

    }

}
