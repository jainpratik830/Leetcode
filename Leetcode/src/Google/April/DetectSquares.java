package Google.April;

import java.util.*;

public class DetectSquares {


    HashMap<Integer, Set<Integer>> map;
    HashMap<String,Integer> count;
    List<int[]> list;

    public DetectSquares() {
        list = new ArrayList<>();
        count = new HashMap<>();
        map= new HashMap<>();

    }

    public void add(int[] point) {
        map.putIfAbsent(point[0],new HashSet<>());
        map.get(point[0]).add(point[1]);
        list.add(point);
        count.put(point[0]+","+point[1],count.getOrDefault(point[0]+","+point[1],0)+1);
    }

    public int count(int[] point) {
        int ans  = 0;
        for (int[] i: list){
            if (i[0]!=point[0] && i[1]!=point[1]){
                int x1 = i[0];
                int x2= point[0];
                int y1 = point[1];
                int y2= i[1];

                if (Math.abs(x1-x2)==Math.abs(y1-y2)) {
                    if (map.containsKey(x1) && map.get(x1).contains(y1) && map.containsKey(x2) && map.get(x2).contains(y2)) {
                        System.out.println("Points="+Arrays.toString(point)+","+Arrays.toString(i)+","+Arrays.toString(new int[]{x1,y1})+","+Arrays.toString(new int[]{x2,y2}));
                        ans += (count.get(x1 + "," + y1)) * (count.get(x2 + "," + y2));
                    }
                }
            }
        }
        return ans;


    }

}
