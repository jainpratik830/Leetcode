package Google.April;

public class Bitwise_AND_of_Numbers_Range {

    public int rangeBitwiseAnd(int left, int right) {
        int ans =right;
        while (ans>left){
            ans = ans & (ans-1);
        }

        return ans;
    }

}
