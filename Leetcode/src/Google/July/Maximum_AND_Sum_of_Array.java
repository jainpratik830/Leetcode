package Google.July;

public class Maximum_AND_Sum_of_Array {

    public int maximumANDSum(int[] nums, int numSlots) {
        int maskTotal = (int)Math.pow(3, numSlots) - 1;
        int[] dp = new int[maskTotal+1];
        return helper(nums.length-1,maskTotal,dp,nums,numSlots);
    }

    public int helper(int i,int mask,int[] dp,int[] nums,int slots){
        if (dp[mask]>0){
            return dp[mask];
        }

        if (i<0){
            return 0;
        }
// Divide by 3 gives for 3 options (0-occupied,1-one empty,2-both empty)
        for (int slot =1,bit =1;slot<=slots;slot++,bit *= 3){
            if (mask/bit%3>0){
                dp[mask] = Math.max(dp[mask],(slot&nums[i]) + helper(i-1,mask-bit,dp,nums,slots) );
            }
        }
        return dp[mask];
    }

}
