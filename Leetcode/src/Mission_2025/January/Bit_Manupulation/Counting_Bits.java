package Mission_2025.January.Bit_Manupulation;

public class Counting_Bits {

    public int countBit(int n){

        int count =0;
        while (n!=0){
            if ((n&1)!=0){
                count++;
            }
            n=n >> 1;

        }
        return count;
    }

    public int[] countBits(int n) {
        int[] ans= new int[n+1];
        for (int i=0;i<=n;i++){
            ans[i]=countBit(i);
        }
        return ans;
    }

    public int[] countBits2(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

}
