package Google.May.Neetcode150;

import java.util.*;

public class Task_Scheduler {



    public int leastInterval(char[] tasks, int n) {

        HashMap<Character,Integer> count = new HashMap<>();
        for (char c:tasks){
            count.put(c,count.getOrDefault(c,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (char c:count.keySet()){
            pq.add(count.get(c));
        }

        int ans =0;
        int curr = n;
        while (!pq.isEmpty()){
            int cycle = n + 1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;
            // Execute tasks in each cycle
            while (cycle-- > 0 && !pq.isEmpty()) {
                int currentFreq = pq.poll();
                if (currentFreq > 1) {
                    store.add(currentFreq - 1);
                }
                taskCount++;
            }
            // Restore updated frequencies to the heap
            store.forEach(pq::offer);
            // Add time for the completed cycle
            ans += (pq.isEmpty() ? taskCount : n + 1);
        }

        return ans;
    }



}
