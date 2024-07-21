package Google.July;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class The_Latest_Time_to_Catch_a_Bus {

    public int latestTimeCatchTheBus2(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int j=0;
        if (passengers[0]>buses[buses.length-1]){
            return buses[buses.length-1];
        }
        int ans =passengers[0]-1;
        int curr =0;
        for (int i=0;i<buses.length;i++){
            curr=0;
            while (j<passengers.length && passengers[j]<=buses[i] && curr<capacity){
                if (j>0 && passengers[j]-(passengers[j-1])>1){
                    ans = passengers[j]-1;
                }

                j++;
                curr++;
            }

            if (j > 0 && curr<capacity && passengers[j-1]!=buses[i]){
                ans=buses[i];
            }

        }

        return ans;
    }

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Set<Integer> visited = new HashSet<>();
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int j=0;
        int ans =0;
        int curr =0;
        for (int i=0;i<buses.length;i++){
            curr=0;
            while (j<passengers.length && passengers[j]<=buses[i] && curr<capacity){
                if (!visited.contains(passengers[j]-1)){
                    ans = passengers[j]-1;
                }

                visited.add(passengers[j]);
                j++;
                curr++;
            }

            if (curr<capacity && !visited.contains(buses[i])){
                ans=buses[i];
            }

        }

        return ans;
    }

}
