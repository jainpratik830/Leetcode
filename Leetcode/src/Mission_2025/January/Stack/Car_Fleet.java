package Mission_2025.January.Stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Car_Fleet {

    public int carFleet(int target, int[] position, int[] speed) {
        int[][] time = new int[position.length][2];
        for (int i=0;i<position.length;i++){
            time[i]= new int[]{speed[i],position[i]};
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });
        Stack<Double> stack= new Stack<>();
        stack.push((target-time[position.length-1][1])*1.0/time[position.length-1][0]);
        for(int i= position.length-1;i>=0;i--){
            if (stack.peek()<(target-time[i][1])*1.0/time[i][0]){
                stack.push((target-time[i][1])*1.0/time[i][0]);
            }
        }

        return stack.size();
    }

}
