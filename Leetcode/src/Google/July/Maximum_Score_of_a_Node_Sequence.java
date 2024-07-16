package Google.July;

import java.util.*;

public class Maximum_Score_of_a_Node_Sequence {

    public int maximumScore(int[] scores, int[][] edges) {
        HashMap<Integer, PriorityQueue<int[]>> map = new HashMap<>();
        for (int[] i:edges){
            map.putIfAbsent(i[0],new PriorityQueue<>(Comparator.comparingInt(a->(a[1]))));
            map.get(i[0]).add(new int[]{i[1],scores[i[1]]});
            map.putIfAbsent(i[1],new PriorityQueue<>(Comparator.comparingInt(a->(a[1]))));
            map.get(i[1]).add(new int[]{i[0],scores[i[0]]});
            if (map.get(i[0]).size()>3){
                map.get(i[0]).poll();
            }
            if (map.get(i[1]).size()>3){
                map.get(i[1]).poll();
            }
        }

        int ans =0;
        for (int[] i:edges){
            int a1 = i[0];
            int a2 = i[1];
            int score =scores[a1]+scores[a2];
            Set<Integer> visited= new HashSet<>();
            visited.add(a1);
            visited.add(a2);
            for (int[] a:map.getOrDefault(a1,new PriorityQueue<>())){
                if (!visited.contains(a[0])){
                    score += a[1];
                    visited.add(a[0]);
                    for (int[] b:map.getOrDefault(a2,new PriorityQueue<>())){
                        if (!visited.contains(b[0])){
                            score+= b[1];
                            ans = Math.max(ans,score);
                            score -= b[1];
                            visited.remove(b[0]);
                        }
                    }
                    score -= a[1];
                    visited.remove(a[0]);

                }
            }
        }

        return ans==0 ? -1 : ans;
    }

}
