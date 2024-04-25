package Google.April;

public class Partition_Array_for_Maximum_Sum {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int ans =0;
        int[] dp = new int[arr.length+1];
        dp[0]=0;
        for (int i=1;i<=arr.length;i++){
            dp[i] = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j=1;j<=k && i-j>=0;j++){
                max = Math.max(max,arr[i-j]);
                // System.out.println("i="+i+" max="+getMax(i-1,i-j,arr));
                dp[i] = Math.max(dp[i],dp[i-j]+max*j);
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[arr.length];
    }

    public int getMax(int i,int j,int[] arr){
        int max = Integer.MIN_VALUE;
        // System.out.println("i="+j+" j="+i);
        for (int k=j;k<=i;k++){
            max = Math.max(max,arr[k]);
        }
        return max;
    }


}
