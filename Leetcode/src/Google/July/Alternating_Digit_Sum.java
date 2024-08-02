package Google.July;

public class Alternating_Digit_Sum {

    public int alternateDigitSum(int n) {
        int sign =1;
        if (String.valueOf(n).length()%2==0){
            sign=-1;
        }

        int ans =0;
        while (n!=0){
            int curr = n%10;
            curr = curr*sign;
            ans+= curr;
            sign = sign==-1? 1: -1;
            n=n/10;
        }
        return ans;
    }

}
