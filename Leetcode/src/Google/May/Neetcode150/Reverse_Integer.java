package Google.May.Neetcode150;

public class Reverse_Integer {

    public int reverse(int x) {
        long ans = 0;
        // int sign = (x<0? -1 : 1);
        while (x!=0){
            int c = x%10;
            ans = ans*10+c;
            x=x/10;
        }
        // ans = ans*sign;
        if (ans>Integer.MAX_VALUE || ans<Integer.MIN_VALUE){
            return 0;
        }
        return (int) (ans);
    }

}
