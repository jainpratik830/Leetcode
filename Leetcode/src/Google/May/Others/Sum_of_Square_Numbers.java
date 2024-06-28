package Google.May.Others;

public class Sum_of_Square_Numbers {

    public boolean judgeSquareSum(int c) {
        boolean ans = false;

        for (int i=0;i<=Math.sqrt(c);i++){
            long a = (long) Math.sqrt(c-i*i);
            if (i*i+a*a==c){
                return true;
            }
        }

        return ans;
    }


}
