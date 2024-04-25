package Google.April;

public class Partition_Equal_Subset_Sum {

    Boolean[][] dp;
    public boolean isPossible(int i,int currSum,int target,int[] nums){

        if (currSum==target){
            return true;
        }

        if (currSum>target || i>=nums.length){
            return false;
        }

        if (dp[i][currSum]!=null){
            return dp[i][currSum];
        }


        return dp[i][currSum]=isPossible(i+1,currSum+nums[i],target,nums) || isPossible(i+1,currSum,target,nums);

    }

    public boolean canPartition(int[] nums) {
        boolean ans = true;

        int sum = 0;
        dp= new Boolean[nums.length][sum];
        for (int i:nums){
            sum+= i;
        }
        dp= new Boolean[nums.length][sum];
        if (sum%2!=0){
            return false;
        }

        return isPossible(0,0,sum/2,nums);
    }

}
