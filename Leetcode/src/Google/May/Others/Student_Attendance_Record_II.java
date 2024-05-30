package Google.May.Others;

import java.util.Arrays;

public class Student_Attendance_Record_II {

    long ans;
    long MODULO = 1000000007;
    long dp[][][];

    public long generate(int currLen,int prevP,int prevA,int prevL){


        if (prevA >= 2 || prevL >= 3) {
            return 0;
        }

        if (currLen==0){
            return 1;
        }
        // System.out.println(prevA);
        if (dp[currLen][prevL][prevA]!=-1){
            return dp[currLen][prevL][prevA];
        }

        long count= generate(currLen-1,prevP+1,prevA,0)%MODULO;
        if (prevL+1<3){
            count = (count + generate(currLen-1,prevP,prevA,prevL+1))%MODULO;
        }
        if (prevA+1<2){
            count = (count +  generate(currLen-1,prevP,prevA+1,0))%MODULO;
        }

        dp[currLen][prevL][prevA]=count%MODULO;

        return count;
    }

    public int checkRecord(int n) {
        ans = 0;
        dp= new long[n+1][3][2];
        for (long[][] array2D : dp) {
            for (long[] array1D : array2D) {
                Arrays.fill(array1D, -1);
            }
        }
        // generate(0,n,0,0,0);

        return (int) (generate(n,0,0,0)%MODULO);
    }

}
