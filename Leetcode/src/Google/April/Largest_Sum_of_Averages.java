package Google.April;

import java.util.ArrayList;
import java.util.List;

public class Largest_Sum_of_Averages {

    public double getMaxScore(int index, int[] nums, int k, Double[][] dp){
        if (k <= 0) {
            return Double.MIN_VALUE;
        }

        if (index >= nums.length) {
            return 0.0d;
        }

        if (dp[index][k] != null) {
            return dp[index][k];
        }

        double maxScore = 0.0d;
        int sum = 0, count = 0;
        if (k == 1) {
            for (int i = index; i <= nums.length - k; ++i) {
                sum += nums[i];
                count += 1;
            }
            maxScore = (double) sum / count;
        } else {
            for (int i = index; i <= nums.length - k; ++i) {
                sum += nums[i];
                count += 1;
                double average = ((double) sum / count);
                maxScore = Math.max(maxScore, average + getMaxScore(i + 1, nums, k - 1, dp));
            }
        }
        return dp[index][k] = maxScore;

    }


    public double largestSumOfAverages(int[] nums, int k) {
        Double[][] dp = new Double[nums.length][k+1];
        return getMaxScore(0,nums,k,dp);
    }

}
