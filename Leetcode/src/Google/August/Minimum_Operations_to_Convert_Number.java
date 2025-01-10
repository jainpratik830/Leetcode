package Google.August;

import java.util.HashSet;
import java.util.*;
import java.util.Queue;

public class Minimum_Operations_to_Convert_Number {

    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[]{start,0});
        Set<Integer> visited = new HashSet<>();
        // visited.add(start);
        while (!queue.isEmpty()){
            int [] curr =queue.poll();

            if (curr[0]==goal){
                return curr[1];
            }

            // if (visited.contains(curr[0])){
            //     continue;
            // }

            if(curr[0]<0 || curr[0]>1000 ) continue;
            visited.add(curr[0]);

            for (int i:nums){
                int temp  = i+curr[0];
                if (!visited.contains(temp)){
                    queue.add(new int[]{temp,curr[1]+1});
                    visited.add(temp);
                }

                temp  = curr[0]-i;
                if (!visited.contains(temp)){
                    queue.add(new int[]{temp,curr[1]+1});
                    visited.add(temp);
                }

                temp  = curr[0]^i;
                if (!visited.contains(temp)){
                    queue.add(new int[]{temp,curr[1]+1});
                    visited.add(temp);
                }
            }
        }


        return -1;
    }

}
