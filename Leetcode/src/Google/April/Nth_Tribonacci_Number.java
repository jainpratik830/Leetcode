package Google.April;

public class Nth_Tribonacci_Number {

    public int tribonacci(int n) {
        int ans =0;

        int t1 = 0,t2=1,t3=1;
        if (n==0){
            return 0;
        }
        if (n<3){
            return 1;
        }

        while (n>=3){
            int temp = t1+t2+t3;
            t1 = t2;
            t2= t3;
            t3 = temp;
            n--;
        }

        return t3;
    }

}
