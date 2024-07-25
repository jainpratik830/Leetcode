package Google.July;

import java.util.Map;
import java.util.TreeMap;

public class Count_Integers_in_Intervals {

    class CountIntervals {

        TreeMap<Integer,Integer> map ;
        int count;

        public CountIntervals() {
            map = new TreeMap<>();
            count = 0;
        }

        public void add(int left, int right) {
            int currSize = right-left+1;

            Map.Entry<Integer,Integer> leftEntry = map.floorEntry(left);

            while (leftEntry!=null && leftEntry.getValue()>=left){

                int newLeft = leftEntry.getKey();
                int newRight = leftEntry.getValue();

                if (newRight>=right){
                    return;
                }


                currSize -= newRight-left+1;

                map.remove(newLeft);
                left = newLeft;
                leftEntry = map.floorEntry(left);
            }


            Map.Entry<Integer,Integer> rightEntry = map.ceilingEntry(left);
            while (rightEntry!=null && rightEntry.getKey()<=right){

                int newLeft = rightEntry.getKey();
                int newRight = rightEntry.getValue();

                currSize -= Math.min(right,newRight)-newLeft+1;

                right = Math.max(right,newRight);

                map.remove(newLeft);

                rightEntry = map.ceilingEntry(left);

            }

            count += currSize;

            map.put(left,right);

        }

        public int count() {
            return count;
        }
    }


}
