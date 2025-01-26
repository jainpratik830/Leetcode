package Mission_2025.January.Bit_Manupulation;

public class Sum_of_Two_Integers {

    public int getSum(int a, int b) {
        int carry =0;
        int ans =0;
        while (a!=0 ||b!=0){
            if (((a & 1) > 0 ) && ( (b & 1) >0 ) ){
                if (carry==1){
                    carry =1;
                    ans = (ans << 1) | 1;
                }else {
                    carry = 1;
                    ans = ans << 1;
                }
            }else if (((a & 1) > 0 ) || ( (b & 1) >0 )){
                if (carry==1){
                    carry =1;
                    ans = (ans << 1);
                }else {
                    carry = 0;
                    ans = (ans << 1) | 1;
                }
            }else{

                ans = (ans << 1) | carry;
                carry =0;
            }
            a = a>>1;
            b=b>>1;
        }

        while (a!=0){
            if ((a & 1) > 0 ) {
                if (carry == 1) {
                    carry = 1;
                    ans = (ans << 1);
                } else {
                    carry = 0;
                    ans = (ans << 1) | 1;
                }
            }else{
                if (carry == 0) {
                    carry = 0;
                    ans = (ans << 1);
                } else {
                    carry = 0;
                    ans = (ans << 1) | 1;
                }
            }
            a = a>>1;
        }

        while (b!=0){
            if ((b & 1) > 0 ) {
                if (carry == 1) {
                    carry = 1;
                    ans = (ans << 1);
                } else {
                    carry = 0;
                    ans = (ans << 1) | 1;
                }
            }else{
                if (carry == 0) {
                    carry = 0;
                    ans = (ans << 1);
                } else {
                    carry = 0;
                    ans = (ans << 1) | 1;
                }
            }
            b = b>>1;
        }

        return carry==1 ? ans = (ans << 1) | 1: ans;
    }

}
