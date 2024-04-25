package Google.March;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Meeting_Rooms_III {

    public int meetingRoom2(int[][] meetings) {
        int ans = 0;

        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(meetings[0][1]);
        for (int i=1;i<meetings.length;i++){
            if (meetings[i][0]< priorityQueue.peek()){
                ans++;
                priorityQueue.poll();
            }

            priorityQueue.add(meetings[i][1]);
        }

        return ans;
    }

    public int mostBooked(int n, int[][] meetings) {
        int ans = 0;
        boolean[] free = new boolean[n];
        Arrays.fill(free,true);
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });

        PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[0]==o2[0]){
                    return (int) (o1[1]-o2[1]);
                }
                return (int) (o1[0]-o2[0]);
            }
        });
        priorityQueue.add(new long[]{meetings[0][1],0});
        int[] count = new int[n];
        free[0]=false;
        count[0]=1;
        int avail = n-1;
        for (int i=1;i<meetings.length;i++){
            System.out.println(Arrays.toString(priorityQueue.toArray()));
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0]<=meetings[i][0]){
                long[] curr=  priorityQueue.poll();
                free[(int) curr[1]]=true;
                avail++;
            }
            if (avail==0){

                long[] curr=  priorityQueue.poll();
                System.out.println(Arrays.toString(curr));

                count[(int) curr[1]]++;
                free[(int) curr[1]]= false;
                priorityQueue.add(new long[]{Math.abs(curr[0]-meetings[i][0])+meetings[i][1],curr[1]});
            }else{

                for (int j=0;j<n;j++){
                    if (free[j]){
                        count[j]++;
                        free[j]=false;
                        priorityQueue.add(new long[]{meetings[i][1],j});
                        break;
                    }
                }
//                count[n-avail]++;
//                free[n-avail]=false;
                avail--;
            }

        }

        System.out.println(Arrays.toString(count));
        int max =0;
        for (int i=0;i<count.length;i++){
            if (count[i]>max){
                max = count[i];
                ans=i;
            }
        }

        return ans;
    }

}
