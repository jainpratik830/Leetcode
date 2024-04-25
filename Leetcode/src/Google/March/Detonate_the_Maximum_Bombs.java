package Google.March;

import java.util.*;

public class Detonate_the_Maximum_Bombs {

    HashMap<Integer, List<Integer>> map;
    public int maximumDetonation(int[][] bombs) {
        map = new HashMap<>();
        int ans = 0;
        for (int i=0;i< bombs.length;i++){
            for(int j=i+1;j<bombs.length;j++){
                // System.out.println(distance(bombs[i],bombs[j]));
                double distance_bomb = distance(bombs[i],bombs[j]);
                if (distance_bomb<=bombs[i][2]) {
                    List<Integer> list = map.getOrDefault(i, new ArrayList<>());
                    list.add(j);
                    map.put(i, list);
                }
                if(distance_bomb<=bombs[j][2]){
                    List<Integer> list2 = map.getOrDefault(j,new ArrayList<>());
                    list2.add(i);
                    map.put(j,list2);
                }
            }
        }
        System.out.println(map);
        boolean[] visited = new boolean[bombs.length];
//        boolean[] curr = new boolean[bombs.length];

        for (int i=0;i<bombs.length;i++){
            visited = new boolean[bombs.length];
            Queue<Integer> queue= new LinkedList<>();
            queue.add(i);
            int count =0;
            while (!queue.isEmpty()){
                int j = queue.poll();
                if (visited[j]){
                    continue;
                }else{
                    count++;
                    visited[j]=true;
                    for (int k:map.getOrDefault(j,new ArrayList<>())){
                        if (!visited[k]){
                            queue.add(k);
                        }
                    }
                }
            }
            ans= Math.max(ans,count);
        }
        return ans;
    }


    public double distance(int[] a,int[] b){
        return Math.sqrt(Math.pow(a[0]-b[0],2)+Math.pow(a[1]-b[1],2));
    }

}
