package Google.August;

import java.util.List;

public class Maximum_Distance_in_Arrays {

    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIdx = -1, maxIdx = -1;
        for(int i = 0; i < arrays.size(); i++) {
            List<Integer> l = arrays.get(i);
            if(min > l.get(0)) {
                min = l.get(0);
                minIdx = i;
            }

            if(max < l.get(l.size() - 1)) {
                max = l.get(l.size() - 1);
                maxIdx = i;
            }
        }
        int maxDist = 0;
        for(int i = 0; i < arrays.size(); i++) {
            List<Integer> l = arrays.get(i);
            if(i != minIdx) {
                maxDist = Math.max(maxDist, Math.abs(l.get(l.size() - 1) - min));
            }

            if(i != maxIdx) {
                maxDist = Math.max(maxDist, Math.abs(max - l.get(0)));
            }
        }
        return maxDist;
    }

}
