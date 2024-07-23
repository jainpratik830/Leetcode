package Google.July;

public class Check_Valid_Partition_For_The_Array {

    public boolean validPartition(int[] nums) {
        boolean[] dp = new boolean[nums.length+1];
        dp[0]=true;
        for (int i=0;i<nums.length;i++){
            if (i>0 && nums[i]==nums[i-1]){
                dp[i+1]= dp[i+1] || dp[i-1];
            }
            if (i>1 && (( nums[i]==nums[i-1] && nums[i]==nums[i-2]) || (nums[i]==nums[i-1]+1 && nums[i]==nums[i-2]+2 ))){
                dp[i+1]= dp[i+1] || dp[i-2];
            }
        }

        return dp[nums.length];
    }

}
