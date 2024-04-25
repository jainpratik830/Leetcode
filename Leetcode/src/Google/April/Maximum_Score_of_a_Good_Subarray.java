package Google.April;

import java.util.Arrays;
import java.util.Stack;

public class Maximum_Score_of_a_Good_Subarray {

    public int maximumScore2(int[] nums, int k) {
        int ans =nums[k] ;
        int left = k;
        int right = k;
        int min = nums[k];
        while (left>0 || right <nums.length-1){
            if ((left > 0 ? nums[left-1]: 0 )< (right<nums.length-1? nums[right+1]: 0)){
                right++;
                min = Math.min(min,nums[right]);
            }else {
                left--;
                min = Math.min(min,nums[left]);
            }

            ans = Math.max(ans,min*(right-left+1));
        }


        return ans;
    }


    public int maximumScore(int[] nums, int k) {
        int ans =0 ;
        int[] lsv = new int[nums.length];
        int[] rsv = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int i=0;
        while (i<nums.length){
            while (!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                lsv[i]=0;
            }else {
                lsv[i] = stack.peek()+1;
            }
            stack.add(i);
            i++;
        }

        stack = new Stack<>();
        i=nums.length-1;
        while (i>=0){
            while (!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                rsv[i]=nums.length-1;
            }else {
                rsv[i] = stack.peek()-1;
            }
            stack.add(i);
            i--;
        }
        System.out.println(Arrays.toString(lsv));
        System.out.println(Arrays.toString(rsv));
        for (i=0;i<nums.length;i++){
            if (lsv[i]<=k && rsv[i]>=k){
                ans = Math.max(ans,(nums[i]*(rsv[i]-lsv[i]+1)));
            }
        }

        return ans;
    }

}
