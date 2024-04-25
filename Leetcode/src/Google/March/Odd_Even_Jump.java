package Google.March;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Odd_Even_Jump {

    public int oddEvenJumps(int[] arr){
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        int ind = 0;


        int oddArr[] = new int[arr.length]; // this stores the index of possible element where index i can go if it is odd jump
        int evenArr[] = new int[arr.length]; // this stores the index of possible element where index i can go if it is even jump

        int n = arr.length;
        tm.put(arr[n-1], n - 1);
        Arrays.fill(oddArr, -1);
        Arrays.fill(evenArr, -1);

        for(int i = n- 2; i>=0; i--) {
            Map.Entry<Integer,Integer> hEntry = tm.ceilingEntry(arr[i]);
            if(hEntry != null) {
                oddArr[i] = hEntry.getValue();
            }

            Map.Entry<Integer,Integer> lEntry = tm.floorEntry(arr[i]);
            if(lEntry != null) {
                evenArr[i] = lEntry.getValue();
            }
            tm.put(arr[i], i);
        }

        boolean dp[][] = new boolean[n][2]; // this stores wether index i can reach destination 0 -- odd and 1 -- even
        for(boolean i[] : dp) {
            Arrays.fill(i, false);
        }
        dp[n-1][0] = true; // for last index odd is possible
        dp[n-1][1] = true; // for last index even is possible
        int ans = 1;
        for(int i = n-2; i>=0; i--) {
            if(oddArr[i] != -1)
                dp[i][0] = dp[oddArr[i]][1]; //for current odd check next even
            if(evenArr[i] != -1)
                dp[i][1] = dp[evenArr[i]][0]; //for current even check next odd

            if(dp[i][0]) ans++; // if odd is true then increase answer as we need starting position and 1 is odd
        }

        return ans;
    }

    public int oddEvenJumps2(int[] arr) {

        int[][] dp = new int[arr.length][2];
        int n = arr.length;
        dp[n-1]= new int[]{1,1};
        int ans =0;
        for (int i=n-2;i>=0;i--){
            dp[i][0]=0;
            dp[i][1]=0;
            int min_diff=Integer.MAX_VALUE;
            int max_diff = Integer.MAX_VALUE;
            for (int j=n-1;j>i;j--){
                if (arr[j] >= arr[i] && min_diff >= arr[j]-arr[i]){
                    dp[i][0]=dp[j][1];
                    min_diff = arr[j]-arr[i];
                }

                if (arr[j] <= arr[i] && max_diff >= arr[i]-arr[j]){
                    dp[i][1] = dp[j][0];
                    max_diff = arr[i]-arr[j];
                }
            }
            if (dp[i][0]==1) {
                ans++;
            }
        }



        // for (int[] i:dp){
        //     System.out.println(Arrays.toString(i));
        // }
        return ans;
    }

}
