package Google.May.Others;

import java.util.Arrays;

public class Find_the_Maximum_Sum_of_Node_Values {

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long[][] memo = new long[nums.length][2];
        for (long[] i: memo)
            Arrays.fill(i, -1);

        return maxSumOfNodes(0, nums, k, memo,1);
    }

    public long maxSumOfNodes(int curr,int[] nums,int k,long[][] memo,int isEven){

        if (curr==nums.length){
            return isEven==1 ?0: Integer.MIN_VALUE;
        }
        if (memo[curr][isEven]!=-1){
            return memo[curr][isEven];
        }


        return  memo[curr][isEven] = Math.max(nums[curr]+maxSumOfNodes(curr+1,nums,k,memo,isEven),(nums[curr]^k)+maxSumOfNodes(curr+1,nums,k,memo,isEven^1));

    }

}
