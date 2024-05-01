package Google.April;

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
        int n = nums.length+2;
        int[] arr = new int[n];
        for (int i=1;i<n-1;i++){
            arr[i]= nums[i-1];
        }
        arr[0]=1;
        arr[n-1]=1;

        dp= new int[n][n];
        return helper(1,n-2,arr);
    }

}
