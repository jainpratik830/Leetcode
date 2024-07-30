package Google.July;

import java.util.HashMap;

public class New_21_Game {

    public double new21Game(int n, int k, int maxPts) {
        if (k==0){
            return 1;
        }

        double windowSum = 0;
        for (int i=k;i<=Math.min(k+maxPts-1,n);i++){
            windowSum+=1;
        }
        // System.out.println(windowSum);
        HashMap<Integer,Double> map = new HashMap<>();

        for (int i=k-1;i>=0;i--){
            double  temp = (windowSum*1.0)/maxPts;
            double remove =0;

            if (i+maxPts<=n){
                remove = map.getOrDefault(i+maxPts,1.0);
            }
            map.put(i,temp);
            windowSum+=temp-remove;

        }

        return map.get(0);
    }

}
