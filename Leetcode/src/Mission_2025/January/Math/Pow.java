package Mission_2025.January.Math;

public class Pow {

    public double helper(double x,int n){

        if (n==0){
            return 1;
        }

        double temp = helper(x,n/2);
        return n%2==0 ? temp*temp : x*temp*temp;

    }

    public double myPow(double x, int n) {

        double ans = helper(x,Math.abs(n));
        return n<0 ? 1/ans: ans;
    }
}
