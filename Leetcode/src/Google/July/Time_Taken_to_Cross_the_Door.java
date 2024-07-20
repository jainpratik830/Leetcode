package Google.July;

import java.util.*;

public class Time_Taken_to_Cross_the_Door {

    public int[] timeTaken(int[] arrival, int[] state) {
        int[] ans = new int[arrival.length];

        Deque<int[]> queue = new ArrayDeque<>();
        int n = ans.length;
        for (int i=0;i<n;i++){
            queue.addLast(new int[]{arrival[i],state[i],i});
        }


        int prev = queue.peek()[1];


        for (int i=0;i<n;i++){

            int[] curr1 = queue.poll();
            System.out.println(Arrays.toString(curr1));
            if (!queue.isEmpty() && queue.peek()[0]==curr1[0]){
                int[] curr2 = queue.poll();
                if (prev==curr1[1]){
                    curr2[0]++;
                    queue.addFirst(curr2);
                    ans[curr1[2]]=curr1[0];
                }else if(prev==curr2[1]) {
                    curr1[0]++;
                    queue.addFirst(curr1);
                    ans[curr2[2]]=curr2[0];
                }else{
                    curr2[0]++;
                    queue.addFirst(curr2);
                    ans[curr1[2]]=curr1[0];
                    prev = curr1[1];
                }


            }else {
                prev = curr1[1];
                ans[curr1[2]]=curr1[0];
            }

        }
        return ans;
    }

}
