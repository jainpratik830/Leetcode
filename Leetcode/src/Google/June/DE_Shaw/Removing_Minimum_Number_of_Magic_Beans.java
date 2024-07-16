package Google.June.DE_Shaw;

import java.util.Arrays;

public class Removing_Minimum_Number_of_Magic_Beans {

    public long minimumRemoval(int[] beans) {
        long ans = Long.MAX_VALUE;
        Arrays.sort(beans);
        long[] prefix = new long[beans.length];
        prefix[0]= beans[0];
        int n = beans.length;
        for (int i=1;i<beans.length;i++){
            prefix[i]= prefix[i-1]+beans[i];
        }
        for (int i=0;i<beans.length;i++){
            // (prefix - beans[i]) + (suffix - beans[i] * (n - i - 1L));
            int curr  = beans[i];
            long currAns =  prefix[i]-beans[i];
            long suffix = prefix[n-1]-prefix[i];
            currAns += (suffix - beans[i]*(n-i-1L));

            ans = Math.min(ans,currAns);

        }


        return ans;
    }

}
