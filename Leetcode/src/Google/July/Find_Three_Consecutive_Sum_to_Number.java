package Google.July;

public class Find_Three_Consecutive_Sum_to_Number {

    public long[] sumOfThree(long num) {
        if (num%3==0){
            long x = num/3;
            return new long[]{x-1,x,x+1};
        }else {
            return new long[]{};
        }
    }

}
