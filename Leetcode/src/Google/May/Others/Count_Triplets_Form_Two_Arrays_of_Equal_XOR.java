package Google.May.Others;

import java.util.Arrays;

public class Count_Triplets_Form_Two_Arrays_of_Equal_XOR {

    public int countTriplets(int[] arr) {
        int ans =0;

        int[] prefix1 = new int[arr.length + 1];
        prefix1[0] = 0;
        System.arraycopy(arr, 0, prefix1, 1, arr.length);
        int size = prefix1.length;




        // Perform XOR on consecutive elements in the modified array
        for (int i = 1; i < size; i++) {
            prefix1[i] ^= prefix1[i - 1];
        }

        for (int i=0;i<=arr.length;i++){
            for (int j=i+1;j<=arr.length;j++){
                if (prefix1[j]==prefix1[i]){
                    ans+= j-i-1;
                }
            }
        }

        return ans;
    }

}
