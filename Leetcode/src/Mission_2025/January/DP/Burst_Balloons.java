package Mission_2025.January.DP;

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
            ans =Math.max(ans,curr+other);
        }

        return dp[l][r]=ans;

    }

    public int maxCoins2(int[] nums) {
        int n = nums.length;
        int[] new_ballons = new int[n+2];
        for (int i=1;i<=n;i++){
            new_ballons[i]=nums[i-1];
        }
        new_ballons[0]=1;
        new_ballons[n+1]=1;
        dp= new int[n+2][n+2];
        return helper(new_ballons,1,n);
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] new_ballons = new int[n+2];
        for (int i=1;i<=n;i++){
            new_ballons[i]=nums[i-1];
        }
        new_ballons[0]=1;
        new_ballons[n+1]=1;
        dp= new int[n+2][n+2];
        for (int length=1;length<=n;length++){

            for (int i=1;i<=n-length+1;i++){
                int j = i+length-1;
                for (int k=i;k<=j;k++){
                    dp[i][j]= Math.max(dp[i][j],new_ballons[i-1]*new_ballons[k]*new_ballons[j+1]+dp[i][k-1]+dp[k+1][j] );
                }


            }

        }

        return dp[1][n];

    }

}
