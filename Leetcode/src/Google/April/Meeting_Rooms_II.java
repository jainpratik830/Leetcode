package Google.April;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Meeting_Rooms_II {

    public int minMeetingRooms2(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i=0;i<intervals.length;i++){
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int startPtr=0;
        int endPtr=0;

        int count =0;

        while (startPtr<intervals.length){
            if (start[startPtr]>=end[endPtr]){
                count--;
                endPtr++;
            }

            startPtr++;
            count++;
        }

        return count;
    }

    public int minMeetingRooms(int[][] intervals) {
        int count =0;
        PriorityQueue<Integer> queue= new PriorityQueue<>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        queue.add(intervals[0][1]);

        for (int i=1;i<intervals.length;i++){
            if (queue.peek()<=intervals[i][0]){
                queue.poll();
            }

            queue.add(intervals[i][1]);
        }

        return queue.size();
    }

}
