package Mission_2025.January.Math;

import java.util.HashSet;
import java.util.Set;

public class Happy_Number {

    Set<Integer> visited=new HashSet<>();

    public int helper(int n){
        String s= Integer.toString(n);
        int sum= 0;
        for (char c:s.toCharArray()){
            sum+= (c-'0')*(c-'0');
        }

        return sum;
    }

    public boolean isHappy(int n) {
        int sum = helper(n);
        if (sum==1){
            return true;
        }if (visited.contains(sum)){
            return false;
        }
        visited.add(sum);
        return isHappy(sum);

    }

    public boolean isHappy2(int n) {
        int slow = n, fast = sumOfSquares(n);

        while (slow != fast) {
            fast = sumOfSquares(fast);
            fast = sumOfSquares(fast);
            slow = sumOfSquares(slow);
        }

        return fast == 1;
    }

    private int sumOfSquares(int n) {
        int output = 0;
        while (n != 0) {
            output += (n % 10) * (n % 10);
            n /= 10;
        }
        return output;
    }
}
