package Google.May.CodingRound;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Car_Fleet {

    public int carFleet(int target, int[] position, int[] speed) {
        int[][] arr= new int[position.length][2];
        for (int i=0;i<position.length;i++){
            arr[i] = new int[]{position[i],speed[i]};
        }

        Arrays.sort(arr,Comparator.comparingInt(a->a[0]));
        Stack<Double> stack= new Stack<>();
        for (int i=position.length-1;i>=0;i--){
            double time = (target-arr[i][0])*1.0/arr[i][1];
            if (!stack.isEmpty() &&stack.peek()>= time){
                continue;
            }
            stack.push(time);

        }

        return stack.size();
    }

}
