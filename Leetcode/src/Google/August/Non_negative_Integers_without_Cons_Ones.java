package Google.August;

public class Non_negative_Integers_without_Cons_Ones {

    int countValidInts(int integer, int limit,int[] dp) {
        // do not add to total count if current integer exceeds limit
        if (integer > limit) {
            return 0;
        }

        if (dp[integer]!=0){
            return dp[integer];
        }

        if ((integer & 1)==1) {
            // current integer ends with bit 1
            // one option - append bit 0

            // add 1 to count current valid integer
            // add count of valid integers when appending 0 to current integer

            return  dp[integer]= 1 + countValidInts((integer << 1) | 0, limit,dp);
        } else {
            // current integer ends with bit 0
            // two options - append bit 0 or bit 1

            // add 1 to count current valid integer
            // add count of valid integers when appending 0 to current integer and
            // add count of valid integers when appending 1 to current integer

            return dp[integer]=1 + countValidInts((integer << 1) | 0, limit,dp) + countValidInts((integer << 1) | 1, limit,dp);
        }
    }

    public int findIntegers(int n) {
        int[] dp= new int[n+1];
        return 1 + countValidInts(1, n,dp);
    }

}
