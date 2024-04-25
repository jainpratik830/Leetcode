package Google.March;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Minimum_Area_Rectangle {

    public int minAreaRect(int[][] points) {
        HashMap<Integer, Set<Integer>> map =  new HashMap<>();
        for (int[] i:points){
            Set<Integer> list =  map.getOrDefault(i[0],new HashSet<>());
            list.add(i[1]);
            map.put(i[0],list);
        }

        int min_area = Integer.MAX_VALUE;

        for (int i=0;i<points.length;i++){
            for (int j=i+1;j< points.length;j++){

                if(points[i][0]!=points[j][0] && points[i][1] != points[j][1]){

                    int cx = points[j][0];
                    int cy = points[i][1];
                    int dx = points[i][0];
                    int dy= points[j][1];

                    if (map.containsKey(cx) && map.get(cx).contains(cy) && map.containsKey(dx) && map.get(dx).contains(dy)){
                        min_area = Math.min(min_area, Math.abs(cx-dx)*Math.abs(cy-dy));
                    }
                }

            }
        }

        return min_area != Integer.MAX_VALUE ? min_area : 0 ;


    }

}
