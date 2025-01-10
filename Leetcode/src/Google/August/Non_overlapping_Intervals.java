package Google.August;

import java.util.*;

public class Non_overlapping_Intervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Step 1: Sort the intervals based on their end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        // Step 2: Line sweep to find the minimum number of intervals to remove
        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                // If there's an overlap, we need to remove this interval
                count++;
            } else {
                // No overlap, update the end time
                prevEnd = intervals[i][1];
            }
        }

        return count;

    }

}
