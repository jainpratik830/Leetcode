package Google.April;

import java.util.*;

public class Evaluate_Division {

    HashMap<String,List<String[]>> map;

    public double dfs (String target,String curr,double cost,HashSet<String> visited){
        if (curr == target){
            return cost;
        }

        if (!map.containsKey(curr)){
            return -1.0;
        }
        visited.add(curr);
        double ans =-1;
        for (String[] arr:map.get(curr)){
            if (!visited.contains(arr[0])) {
                double curr_cost = dfs(target, arr[0], cost * Double.parseDouble(arr[1]), visited);
                if (curr_cost != -1.0) {
                    ans = curr_cost;
                }
            }
        }
        return ans;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
         map = new HashMap<>();
        int i=0;
        for (List<String> list:equations){
            String a= list.get(0);
            String b = list.get(1);
            map.putIfAbsent(a,new ArrayList<>());
            map.get(a).add(new String[]{b,String.valueOf(values[i])});
            map.putIfAbsent(b,new ArrayList<>());
            map.get(b).add(new String[]{a,String.valueOf(1/values[i])});
            i++;
        }
        for (String key: map.keySet()){
            System.out.println("key="+key);
            for (String[] arr:map.get(key)){
                System.out.println(Arrays.toString(arr));
            }
        }
        i=0;
        Set<String> keys=map.keySet();
        HashSet<String> visited;
        for (List<String> query:queries){
            visited= new HashSet<>();
            if (!keys.contains(query.get(0)) || !keys.contains(query.get(1))) {
                ans[i++]=-1;
            }else{
                ans[i++]=dfs(query.get(1),query.get(0),1.0,visited);
            }

        }


        return ans;
    }

}
