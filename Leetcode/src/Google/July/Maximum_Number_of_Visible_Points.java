package Google.July;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Maximum_Number_of_Visible_Points {

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int answer = 0;

        // find the required polar angle with respect to the location
        for (var point : points) {
            int dx = point.get(0) - location.get(0);
            int dy = point.get(1) - location.get(1);

            if (dx == 0 && dy == 0) { // points at same position as location
                answer++;
                continue;
            }

            angles.add(Math.toDegrees(Math.atan2(dy, dx)));
        }

        // Sorting the angles will make sure that the required count is a
        // contiguous length of angles
        Collections.sort(angles);
        System.out.println(angles);
        /*
            -> Push angles again by adding 360 to handle the case of consecutive points
            being after a complete cycle.
            -> Example: -345 and 14 (if angle >= 29)
        */
        int n = angles.size();
        for (int i = 0; i < n; ++i) {
            angles.add(angles.get(i) + 360);
        }
        System.out.println(angles);
        int start = 0;
        int count = 0;

        // Sliding window to find the maximum widow covered by the given angle
        for (int end = 0; end < angles.size(); ++end) {
            while (angles.get(end) - angles.get(start) > angle) {
                start++;
            }

            count = Math.max(count, end - start + 1);
        }

        // adding the count to the number of overlapping points with the given location
        // computed earlier.
        answer += count;

        return answer;
    }

}
