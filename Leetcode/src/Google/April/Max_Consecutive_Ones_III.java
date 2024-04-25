package Google.April;

public class Max_Consecutive_Ones_III {

    public int longestOnes(int[] nums, int k) {
        int ans =0;
        int left = 0;
        int right =0;
        int curr_k=k;
        while (left<nums.length && right< nums.length){
            if (nums[right]==1){
                right++;
                ans = Math.max(ans,right-left+1);
            }else{
                if (nums[right]==0 && curr_k>0){
                    curr_k--;
                    right++;
                    ans = Math.max(ans,right-left+1);
                }else{
                    while (nums[left]!=0){
                        left++;
                        curr_k++;
                    }
                }
            }
        }

        return ans;
    }


}
