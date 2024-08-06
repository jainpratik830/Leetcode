package Google.August;

public class Burst_Balloons {

    int[][] dp;

    public int helper(int left,int right,int[] arr){

        if (left>right){
            return 0;
        }



        if (dp[left][right]!=0){
            return dp[left][right];
        }
        int res = 0;
        for (int i=left;i<=right;i++){
            int curr = arr[left-1]*arr[i]*arr[right+1];
            int other = helper(left,i-1,arr)+helper(i+1,right,arr);

            res = Math.max(res,curr+other);
        }

        return dp[left][right]=res;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] newNums = new int[n];
        System.arraycopy(nums, 0, newNums, 1, n - 2);
        newNums[0] = 1;
        newNums[n - 1] = 1;
        // dp[i][j] represents
        // maximum if we burst all nums[left]...nums[right], inclusive
        dp = new int[n][n];
        // // do not include the first one and the last one
        // // since they are both fake balloons added by ourselves and we can not burst
        // // them
        // for (int left = 1; left <=n-2; left++) {
        //     for (int right = left; right <= n - 2; right++) {
        //         // find the last burst one in newNums[left]...newNums[right]
        //         for (int i = left; i <= right; i++) {
        //             // newNums[i] is the last burst one
        //             int gain = newNums[left - 1] * newNums[i] * newNums[right + 1];
        //             // recursively call left side and right side
        //             int remaining = dp[left][i - 1] + dp[i + 1][right];
        //             // update
        //             dp[left][right] = Math.max(remaining + gain, dp[left][right]);
        //         }
        //     }
        // }
        // // burst newNums[1]...newNums[n-2], excluding the first one and the last one
        // return dp[1][n - 2];
        return helper(1,n-2,newNums);
    }

}
