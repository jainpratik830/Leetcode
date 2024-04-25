package Google.April;

import java.util.Random;

public class Random_Pick_with_Weight {

    int[] prefix;
    int[] w;
    int n;
    Random random;

    public Random_Pick_with_Weight(int[] w) {
        this.w = w;
        prefix = new int[w.length];
        random=  new Random();
        n = w.length;
        prefix[0]=w[0];
        for (int i=1;i<w.length;i++){
            prefix[i] = prefix[i-1] + w[i];
        }
    }

    public int pickIndex() {

        if(n==1){
            return 0;
        }
        int low = 0;
        int high = n;
        double target = this.prefix[n-1] * Math.random();
        while (low<high){
            int mid = low + (high - low) / 2;
            if (prefix[mid]<=target){
                low=mid+1;
            }else {
                high=mid;
            }
        }

        return high;

    }

}
