package Google.July;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Race_Car {



    public int racecar(int target) {
        Queue<int[]> queue =new LinkedList<>();
        Set<String> visited= new HashSet<>();

        queue.add(new int[]{0,1});
        visited.add("0,1");
        int level =0;
        while (!queue.isEmpty()){
            int size =queue.size();

            for (int i=0;i<size;i++){
                int[] curr = queue.poll();
                if (curr[0]==target){
                    return level;
                }
                int[] next = new int[]{curr[0]+curr[1],curr[1]<<1};
                if (!visited.contains(next[0]+","+next[1]) && 0 < (next[0]) && (next[0]) < (target << 1)){
                    queue.add(next);
                    visited.add(next[0]+","+next[1]);
                }

                next = new int[]{curr[0],(curr[1]>0?-1:1)};
                if (!visited.contains(next[0]+","+next[1])  && 0 < next[0] && next[0] < (target << 1)){
                    queue.add(next);
                    visited.add(next[0]+","+next[1]);
                }

            }
            level++;

        }
        return -1;
    }

}
