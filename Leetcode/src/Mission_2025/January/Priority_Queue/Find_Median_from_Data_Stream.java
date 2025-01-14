package Mission_2025.January.Priority_Queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class Find_Median_from_Data_Stream {

    class MedianFinder {

        PriorityQueue<Integer> minQ,maxQ;

        public MedianFinder() {
            minQ = new PriorityQueue<>();
            maxQ = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void addNum(int num) {
            maxQ.add(num);
            int curr = maxQ.poll();
            minQ.add(curr);
            if (minQ.size()>maxQ.size()+1){
                curr = minQ.poll();
                maxQ.add(curr);
            }
        }

        public double findMedian() {
            if ((minQ.size()+maxQ.size())%2==0){
                return (minQ.peek()+maxQ.peek())*1.0/2;
            }else {
                return minQ.peek();
            }
        }
    }

}
