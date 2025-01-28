package Mission_2025.January.Intervals;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Meeting_Rooms_II {

    public class Interval {
      public int start, end;
      public Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Min-heap to track the end times of meetings
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // Iterate through intervals
        for (int[] interval : intervals) {
            // If the current meeting starts after or when the earliest meeting ends
            if (!heap.isEmpty() && interval[0] >= heap.peek()) {
                heap.poll(); // Free up the room
            }

            // Allocate a new room (add the current meeting's end time to the heap)
            heap.add(interval[1]);
        }

        // The size of the heap is the minimum number of rooms required
        return heap.size();
    }
    
    public int minMeetingRooms(List<Interval> intervals) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(Interval i:intervals){
            map.put(i.start,map.getOrDefault(i.start,0)+1);
            map.put(i.end,map.getOrDefault(i.end,0)-1);
        }

        int prev =0;
        int res =0;
        for(int key:map.keySet()){
            prev += map.get(key);
            res = Math.max(prev,res);
        }

        return res;
    }
}
