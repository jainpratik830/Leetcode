package Google.March;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Single_Threaded_CPU {

    public int[] getOrder(int[][] tasks) {
        int[] ans = new int[tasks.length];
        int[][] task_new = new int[tasks.length][3];
        for (int i=0;i< tasks.length;i++){
            task_new[i] = new int[]{tasks[i][0],tasks[i][1], i};
        }
        Arrays.sort(task_new, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]==o2[1]){
                    return o1[2]-o2[2];
                }
                return o1[1]-o2[1];
            }
        });

        int count  =0;
        int time = task_new[0][0];
        int k=0;
        while (count<tasks.length){
            while (count<tasks.length && time>= task_new[count][0]){
                priorityQueue.add(task_new[count++]);
            }
            if (!priorityQueue.isEmpty()){
                int[] curr = priorityQueue.remove();
                ans[k++]=curr[2];
                time+=curr[1];
            }
            else {
                time = task_new[count][0];
            }
        }
        while (!priorityQueue.isEmpty()){
            int[] curr = priorityQueue.remove();
            ans[k++]=curr[2];
        }

        return ans;
    }

}
