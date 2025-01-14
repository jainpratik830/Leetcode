package Mission_2025.January.Priority_Queue;

import java.util.*;

public class Task_Scheduler {

    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:tasks){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i: map.values()){
            pq.add(i);
        }
        int ans =0;
        int cycle = n+1;
        while (!pq.isEmpty()){
            cycle= n+1;
            List<Integer> list= new ArrayList<>();
            int task = 0;
            while (cycle-->0 && !pq.isEmpty()){
                int curr = pq.poll();
                if (curr>1) {
                    list.add(curr-1);
                }
                task++;
            }

            for (int i:list){
                pq.add(i);
            }

            if (pq.isEmpty()) {
                ans += task;
            }else {
                ans+= n+1;
            }

        }

        return ans;

    }

}
