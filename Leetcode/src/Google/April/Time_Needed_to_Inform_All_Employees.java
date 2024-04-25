package Google.April;

import java.util.*;

public class Time_Needed_to_Inform_All_Employees {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int ans = 0;
        HashMap<Integer, List<int[]>> map = new HashMap<>();

        for (int i=0;i<manager.length;i++){
            if (i!=headID){
                map.putIfAbsent(manager[i],new ArrayList<>());
                map.get(manager[i]).add(new int[]{i,informTime[manager[i]]});
            }
        }

        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[]{headID,0});
        HashSet<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()){
            int[] curr = queue.poll();;
            ans = Math.max(ans,curr[1]);
            visited.add(curr[0]);
            for (int[] i:map.getOrDefault(curr[0],new ArrayList<>())){
                if (!visited.contains(i[0])){
                    queue.add(new int[]{i[0],i[1]+curr[1]});
                }
            }
        }




        return ans;
    }

}
