package Google.August;

import java.util.HashMap;
import java.util.Stack;

public class Next_Greater_Element_I {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> index= new HashMap<>();
        int[] nge = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<nums2.length;i++){
            while (!stack.isEmpty() && nums2[stack.peek()]<nums2[i]){
                int x = stack.pop();
                index.put(nums2[x],nums2[i]);
            }

            stack.push(i);
        }
        while (!stack.isEmpty()){
            int x = stack.pop();
            index.put(nums2[x],-1);
        }

        int[] ans = new int[nums1.length];
        for (int i=0;i< nums1.length;i++){
            ans[i]= index.get(nums1[i]);
        }

        return ans;

    }

}
