package Mission_2025.January.Greedy;

public class Burst_Balloons {
    int[][] dp;
    public int helper(int[] nums,int l,int r){

        if (l>r){
            return 0;
        }
        if (dp[l][r]!=0){
            return dp[l][r];
        }
        int ans =0;
        for (int i=l;i<=r;i++){
            int curr = nums[l-1]*nums[i]*nums[r+1];
            int other = helper(nums,l,i-1)+helper(nums,i+1,r);
            ans = Math.max(ans,curr+other);
        }

        return dp[l][r]=ans;

    }

    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length+2];
        dp=new int[arr.length][arr.length];
        for (int i=0;i<nums.length;i++){
            arr[i+1]=nums[i];
        }
        arr[0]=1;
        arr[arr.length-1]=1;
        return helper(arr,1,nums.length);
    }

}
