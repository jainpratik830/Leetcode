package Google.April;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee_Free_Time {

    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ans = new ArrayList<>();

        List<Interval> intervals = new ArrayList<>();
        for (List<Interval> list:schedule){
            for (Interval i:list){
                intervals.add(i);
            }
        }

        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));

        int curr = intervals.get(0).end;
        int i=1;
        while (i<intervals.size()){
            Interval intervalCurr = intervals.get(i);
            if (intervalCurr.start>curr){
                ans.add(new Interval(curr,intervalCurr.start));

            }
            curr = Math.max(curr,intervalCurr.end);
            i++;
        }


        return ans;
    }
}
