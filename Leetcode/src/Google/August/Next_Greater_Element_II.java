package Google.August;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Next_Greater_Element_II {

    public int[] nextGreaterElements(int[] nums) {
        Integer[] nge = new Integer[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<2*nums.length;i++){
            int k = i%nums.length;
            while (!stack.isEmpty() && nums[stack.peek()]<nums[k]){
                int x = stack.pop();
                nge[x]=nums[k];
            }
            stack.push(k);
        }
        while (!stack.isEmpty()){
            int x = stack.pop();
            if(nge[x]!=null){
                continue;
            }

            nge[x]=-1;
        }

        return Arrays.stream(nge).mapToInt(i->i).toArray();

    }

}

