package Google.May.Neetcode150;

import java.util.ArrayList;
import java.util.List;

public class Gas_Station {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int curr =0;
        int total = 0;
        int ans=0;
        for (int i=0;i<n;i++){
           curr+= gas[i]-cost[i];
           total+= gas[i]-cost[i];

           if (curr<0){
               curr=0;
               ans = (i+1)%n;
           }
        }


        return total>=0 ? ans : -1;
    }


}
