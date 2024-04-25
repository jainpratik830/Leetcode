package Google.April;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> minPriorityQueue;
    PriorityQueue<Integer> maxPriorityQueue;
    int count ;


    public MedianFinder() {
        count=0;
        minPriorityQueue= new PriorityQueue<>();
        maxPriorityQueue= new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (count%2==0){
            minPriorityQueue.add(num);
            maxPriorityQueue.add(minPriorityQueue.poll());
        }else{
            maxPriorityQueue.add(num);
            minPriorityQueue.add(maxPriorityQueue.poll());
        }

        count++;
    }

    public double findMedian() {
        if (count%2==0){
            return (double) ((double) maxPriorityQueue.peek()+ (double) minPriorityQueue.peek())/2.0;
        }else {
            return maxPriorityQueue.peek();
        }
    }

}
