package Google.August;

import java.util.Arrays;

public class Stone_Game_V {

    public int findSum(int[] stoneValue)
    {
        int sum=0;
        for(int n:stoneValue) sum+=n;
        return sum; //  returns the sum of the stoneValue Array.
    }
    public int findMin(int[] stoneValue,int start,int end,int preSum,int sum,int[][] dp)
    {
        if(start==end) return 0; // returns 0 whenever the length of the array equals 1.

        if(dp[start][end]!=-1) return dp[start][end]; // returns the stored value of the sub problem when the specific values of start and end already solved before.

        int ans=Integer.MIN_VALUE; // Initializing the required maximum score of alice with the minimum possible integer.

        for(int i=start;i<end;i++) // Iterating a for loop from the starting index to the ending index to check with all the possible partitions.
        {
            preSum=preSum+stoneValue[i]; //Increment the preSum with value of stoneValue at current index where we are going to make partition.

            if(preSum < sum-preSum)
            {
                ans=Math.max(ans,preSum+findMin(stoneValue,start,i,0,preSum,dp));
                //if the preSum(the sum of the array from start index to current index) is less than the remaining part of the array,
                //Then Bob throws away the right array i.e the array with the largest sum,
                //Alice score is increased by preSum(sum of the left array) and parameters of the left array are sent to the recursion.
            }
            else if(preSum>sum-preSum)
            {
                ans=Math.max(ans,sum-preSum+findMin(stoneValue,i+1,end,0,sum-preSum,dp));
                //if the preSum(the sum of the array from start index to current index) is more than the remaining part of the array,
                //Then Bob throws away the left array i.e the array with the largest sum,
                //Alice score is increased by sum-preSum(sum of the right array) and parameters of the right array are sent to the recursion.
            }
            else{
                ans=Math.max(ans,Math.max(preSum+findMin(stoneValue,start,i,0,preSum,dp),sum-preSum+findMin(stoneValue,i+1,end,0,sum-preSum,dp)));
                // if the preSum(the sum of left array) and sum-preSum(the sum of the right array) are equal,
                // Then, Bob gives Alice a chance to remove either the left array or the right array,
                // So alice has a chance to get maximum score from either of the arrays,
                // So Alice take the the Max value from both the recursions(recursion calls of both left array and right array).
            }
        }
        return dp[start][end]=ans; // store the value of the partition for specific start and end values in the dp array.
    }
    public int stoneGameV(int[] stoneValue) {
        int sum = findSum(stoneValue); // To find Sum of the stoneValue array.

        int[][] dp = new int[stoneValue.length][stoneValue.length]; // A 2D array for memorization.

        for(int i=0;i<stoneValue.length;i++)
        {
            Arrays.fill(dp[i],-1); // Initializing all the values of the 2D array dp with -1.
        }
        return findMin(stoneValue,0,stoneValue.length-1,0,sum,dp); // function to find Maximum score of alice.
    }

}
