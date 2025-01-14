package Mission_2025.January.Daily_Problems;

import java.util.HashSet;

public class Find_the_Prefix_Common_Array_of_Two_Arrays {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans = new int[A.length];
        HashSet<Integer> a_set = new HashSet<>();
        HashSet<Integer> b_set = new HashSet<>();

        int n = A.length;
        int count = 0;
        for (int i=0;i<n;i++){

            a_set.add(A[i]);
            b_set.add(B[i]);
            if (A[i]==B[i]){
                count=1;
            }else {

                count = (b_set.contains(A[i]))?1 :0;
                count += (a_set.contains(B[i])) ? 1 :0;
            }

            if (i==0){
                ans[i] = count;
            }else {
                ans[i] = ans[i-1]+count;
            }

        }
        return ans;
    }

}
