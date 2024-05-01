package Google.April;

public class Number_of_1_Bits {

    public int hammingWeight(int n) {
        int ans =0;
        int i=0;
        int t=0;
        while (t<=n){
            t = 1 << i;
            if ((n & (t) ) == t){
                ans++;
            }
            i++;
        }

        return ans;
    }

}
