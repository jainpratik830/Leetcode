package Google.April;

public class Number_of_Dice_Rolls_With_Target_Sum {

    final int MOD = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        int[][] memo = new int[n + 1][target + 1];
        // Intialize the base case
        memo[0][0] = 1;

        for (int diceIndex = 1; diceIndex<=n; diceIndex++) {
            for (int currSum = 1; currSum <= target; currSum++) {
                int ways = 0;

                // Iterate over the possible face value for current dice
                for (int i = 1; i <= Math.min(k, currSum); i++) {
                    ways = (ways + memo[diceIndex -1][currSum - i]) % MOD;
                }

                memo[diceIndex][currSum] = ways;
            }
        }

        return memo[n][target];
    }

}
