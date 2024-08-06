package Google.August;

public class Maximum_Sum_Circular_Subarray {

    public int maxSubarraySumCircular(int[] nums) {
        int minSum = nums[0];
        int maxSum = nums[0];
        int total  =nums[0];
        int currMax = 0;
        int currMin = 0;

        for (int i=1;i<nums.length;i++){

            currMax = Math.max(currMax+nums[i],nums[i]);
            maxSum = Math.max(currMax,maxSum);

            currMin = Math.min(currMin+nums[i],nums[i]);
            minSum = Math.min(currMin,minSum);

            total+= nums[i];

        }

        if (total==minSum){
            return maxSum;
        }

        return Math.max(maxSum,total-minSum);
    }

}
