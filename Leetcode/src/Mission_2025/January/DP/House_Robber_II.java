package Mission_2025.January.DP;

public class House_Robber_II {

    public int rob_helper(int[] nums) {
        int n=nums.length;
        int[] dp= new int[n];
        dp[0]= nums[0];
        if (n<=1){
            return nums[0];
        }
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[n-1];
    }

    public int rob(int[] nums) {
        if(nums.length<=1){
            return nums[0];
        }
        int[] b= new int[nums.length-1];
        for (int i=1;i<nums.length;i++){
            b[i-1]=nums[i];
        }
        int a = rob_helper(b);
        b= new int[nums.length-1];
        for (int i=0;i<nums.length-1;i++){
            b[i]=nums[i];
        }
        return Math.max(a, rob_helper(b));
    }

}
