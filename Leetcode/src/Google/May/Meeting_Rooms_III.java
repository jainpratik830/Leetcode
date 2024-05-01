package Google.May;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Meeting_Rooms_III {

    public int mostBooked(int n, int[][] meetings) {
        int ans =0 ;
        boolean[] free =new boolean[n];
        Arrays.fill(free,true);
        Arrays.sort(meetings,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return (int) (o1[1]-o2[1]);
                }
                return (int) (o1[0]-o2[0]);

            }
        });
        PriorityQueue<long[]> priorityQueue= new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[0]==o2[0]){
                    return (int) (o1[1]-o2[1]);
                }
                return (int) (o1[0]-o2[0]);

            }
        });

        priorityQueue.add(new long[]{meetings[0][1],0});

        int[] count= new int[n];
        count[0]=1;
        free[0]=false;
        int avail =n-1;
        for (int i=1;i<meetings.length;i++){
            int[]  curr= meetings[i];

            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0]<=meetings[i][0]){
                long[] curr2=  priorityQueue.poll();
                free[(int) curr2[1]]=true;
                avail++;
            }
            if (avail==0){

                long[] curr2=  priorityQueue.poll();
                free[(int) curr2[1]]=false;
                avail++;
                count[(int) curr2[1]]++;
                priorityQueue.add(new long[]{Math.abs(curr2[0]-meetings[i][0])+meetings[i][1],(int) curr2[1]});
            }else {

                for (int j=0;j<n;j++){
                    if (free[j]){
                        priorityQueue.add(new long[]{meetings[i][1],j});
                        free[j]=false;

                        count[j]++;
                        break;
                    }
                }

            }
            avail--;
        }
        int max = 0;
        for (int i=0;i<count.length;i++){
            if (count[i]>max){
                max = count[i];
                ans=i;
            }
        }

        return ans;

    }



}
