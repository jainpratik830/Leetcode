package Google.March;

public class Nth_Magical_Number {

    public int nthMagicalNumber(int n, int a, int b) {
        long ans = 0;
        long modulo = (long) (1e9+7);
        int i=1;
        int j=1;

        if (a>b){
            int curr = b;
            b= a;
            a= curr;
        }
        long newA = a;
        long newB = b;
        while (n>0){
            ans = Math.min(newA,newB);
            if (ans==a){
                newA = a*i;
                i++;
            }else{
                newB =b*j;
                j++;
            }

            n--;
        }


        return (int) (ans%modulo);
    }

}
