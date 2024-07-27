package Google.July;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class The_Number_of_Weak_Characters_in_Game {

    public int numberOfWeakCharacters(int[][] properties) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int[] i:properties){
            map.putIfAbsent(i[0],new ArrayList<>());
            map.get(i[0]).add(i[1]);
            max = Math.max(max,i[0]);
            min = Math.min(min,i[0]);
        }

        int ans =0;
        int maxDef = -1;

        for (int i=max;i>=min;i--){
            int currMax = 0;
            for (int j:map.getOrDefault(i,new ArrayList<>())){
                currMax = Math.max(currMax,j);
                if (j<maxDef){
                    ans++;
                }
            }

            maxDef = Math.max(maxDef,currMax);

        }

        return ans;
    }

}
