package Google.July;

import java.util.Arrays;
import java.util.Comparator;

public class Minimum_Initial_Energy_to_Finish_Tasks {

    public int minimumEffort(int[][] tasks) {
        int ans =0;
        Arrays.sort(tasks, Comparator.comparingInt(a->-1*(a[1]-a[0])));
        int curr =tasks[0][1]-tasks[0][0];
        ans+=tasks[0][1];
        for (int i=1;i<tasks.length;i++){
            if (curr<tasks[i][1]){
                ans+= tasks[i][1]-curr;
                curr =tasks[i][1]- tasks[i][0];
            }else {
                curr-=tasks[i][0];
            }
            System.out.println(curr);
        }

        return ans;

    }


}
