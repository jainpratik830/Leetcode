package Google.July;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;

public class Find_Building_Where_Alice_and_Bob_Can_Meet {

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (b[0]-a[0]));
        int[] res = new int[queries.length];
        int pos = 0;
        int n = heights.length;
        for (int[] q:queries){
            if (q[0]==q[1] || heights[Math.max(q[0],q[1])]> heights[Math.min(q[0],q[1])]){
                res[pos] = Math.max(q[0],q[1]);
                pos++;
                continue;
            }
            int[] temp = new int[3];
            temp[0] = Math.max(q[0],q[1]);
            temp[1]= Math.max(heights[q[0]],heights[q[1]]);
            temp[2]=pos;
            pos++;
            pq.offer(temp);
        }



        TreeSet<int[]> treeSet =new TreeSet<>((a,b)->(a[0] - b[0]));
        for (int i=heights.length-1;i>=0;i--){
            while (pq.size()>0 && pq.peek()[0]==i){
                int[] q= pq.poll();;
                int[] next = treeSet.ceiling(new int[]{q[1]+1,0});
                if (next==null){
                    res[q[2]]=-1;
                }else {
                    res[q[2]]=next[1];
                }
            }
            while (!treeSet.isEmpty() && treeSet.first()[0]<=heights[i]){
                treeSet.remove(treeSet.first());
            }
            int[] ele = new int[]{heights[i],i};
            treeSet.add(ele);
        }
        return res;
    }


}
