package Mission_2025.January.Greedy;

public class Jump_Game {

    public boolean canJump(int[] nums) {
        int mxReach = nums[0];
        int last = nums.length-1;
        if(nums.length==1){
            return true;
        }
        for (int i= 1;i<nums.length && i<=mxReach;i++) {
           mxReach = Math.max(mxReach,nums[i]+i);

           if (mxReach>=last){
               return true;
           }
        }
        return false;
    }

    public boolean canJump2(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length-1]=true;

        for (int i= nums.length-2;i>=0;i--) {
            for (int j = 1; j <= Math.min(nums.length - 1, nums[i]); j++){
                if (dp[i+j] == true) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

}
