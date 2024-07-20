package Google.July;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Single_Threaded_CPU {

    public int[] getOrder(int[][] tasks) {

        int[][] arr = new int[tasks.length][3];
        for (int i=0;i<tasks.length;i++){
            arr[i]= new int[]{tasks[i][0], tasks[i][1], i};
        }

        Arrays.sort(arr,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){

                if (a[0]==b[0]){
                    return a[1]-b[1];
                }
                return a[0]-b[0];
            }
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1]==b[1]){
                    return a[2]-b[2];
                }
                return a[1]-b[1];
            }
        });

        int[] ans = new int[tasks.length];
        int k=0;
        int count =0;
        int time = arr[count][0];

        while (count<arr.length){

            while (count<arr.length && arr[count][0]<=time){
                pq.add(arr[count]);
                count++;
            }

            if (!pq.isEmpty()){
                int[] curr =pq.poll();
                ans[k++]=curr[2];
                time += curr[1];
            }else {
                time = arr[count][0];
            }

        }

        while (!pq.isEmpty()){
            int[] curr =pq.poll();
            ans[k++]=curr[2];
        }

        return ans;

    }

}
