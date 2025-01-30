package Zeta;

import java.util.Arrays;

public class ProbabilityOfKHeads {

    /*
    This question is a probabilistic problem where you calculate the total probability of getting exactly
𝐾
K heads from an array of coin toss probabilities. Each element in the array represents the probability of a coin showing heads in a single toss.

Problem Breakdown:
Input:

An array arr where arr[i] is the probability of getting heads for the
𝑖
i-th coin.
An integer
𝐾
K, the number of heads you want to achieve.
Output:

The total probability of getting exactly
𝐾
K heads.
Key Points:

Each coin toss can result in either heads or tails.
The probability of a specific outcome is the product of the probabilities of heads and tails for the chosen combination.
Approach:

Use Dynamic Programming (DP) to compute the total probability efficiently.
Let dp[j] represent the probability of getting exactly
𝑗
j heads after processing
𝑖
i coins.
     */

    double[][] dp;

    public double helper(double[] arr,int k,int index){
        if (k==0){
            return 1.0;
        }

        if (index== arr.length){
            return 0.0;
        }

        if (dp[index][k]!=-1){
            return dp[index][k];
        }

        double currHead = arr[index]*helper(arr,k-1,index+1);
        double currTail = (1-arr[index])*helper(arr,k,index+1);

        return dp[index][k]=currHead+currTail;

    }

    public double probabilityOfKHeads(double[] arr, int K) {
        dp = new double[arr.length][K];
        for (double[] a:dp){
            Arrays.fill(a,-1.0);
        }
        return helper(arr,K,0);
    }

}
