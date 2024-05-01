package Google.April;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Brick_Wall {

    public int leastBricks(List<List<Integer>> wall) {
        int sum = 0;
        for (int i:wall.get(0)){
            sum+=i;
        }
        HashMap<Integer,Integer> map = new HashMap<>();

        for (List<Integer> list:wall){
            int curr = 0;
            for (int i=0;i<wall.size()-1;i++){
                curr = curr+list.get(i);
                map.put(curr,map.getOrDefault(curr,0)+1);
            }
        }

        int max = 0;
        for (int i: map.values()){
            if (i>max){
                max = i;
            }
        }

        return wall.size()-max;
    }

}
