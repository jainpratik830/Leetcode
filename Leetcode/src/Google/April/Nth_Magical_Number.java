package Google.April;

public class Nth_Magical_Number {

//    T = O(log(n*min(a,b))
//    S = O(1)

    public int nthMagicalNumber(int n, int a, int b) {

        long A = a, B = b;
        long mod = (long)(Math.pow(10,9)+7);


        long left = Math.min(a,b), right = (long)n*Math.min(a,b);

        // Finding GCD
        while (B > 0) {
            long tmp = A;
            A = B;
            B = tmp % B;
        }

        long lcm = (a*b)/A;

        while (left<right){

            long mid = left+ (right-left)/2;

            if (mid/a+mid/b-mid/lcm<n){
                left= mid+1;
            }else{
                right = mid;
            }

        }

        return (int)(left%mod);


    }

}
