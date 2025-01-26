package Mission_2025.January.Daily_Problems;

import java.util.*;

public class Maximum_Employees_to_Be_Invited_to_a_Meeting {

    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] inDegree= new int[favorite.length];
        Queue<Integer> queue= new LinkedList<>();
        for (int i=0;i<n;i++){
            inDegree[favorite[i]]++;
        }
        for (int i=0;i<n;i++){
            if (inDegree[i]>=2){
                queue.add(i);
            }
        }

        int count =0;
        while (!queue.isEmpty()){

            int curr = queue.poll();
            inDegree[favorite[curr]]--;
            if (inDegree[favorite[curr]]==0){
                queue.add(favorite[curr]);
            }
            count++;
        }

        return count;

    }


}
