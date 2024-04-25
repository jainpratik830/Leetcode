package Google.March;

import java.util.*;

public class Find_Number_of_Coins_to_Place_in_Tree_Nodes {

    public long[] placedCoins(int[][] edges, int[] cost) {
        long[] ans= new long[cost.length];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] i:edges){
            List<Integer> list = map.getOrDefault(i[0],new ArrayList<>());
            list.add(i[1]);
            map.put(i[0],list);

            List<Integer> list2 = map.getOrDefault(i[1],new ArrayList<>());
            list2.add(i[0]);
            map.put(i[1],list2);
        }
        Arrays.fill(ans,1);
        dfs(new boolean[cost.length],map,cost,ans,0);

        return ans;
    }

    public List<Integer> dfs(boolean[] visited,HashMap<Integer, List<Integer>> map,int[] cost,long[] ans,int curr){
        visited[curr] = true;

        List<Integer>temp = new ArrayList<>();


        for (int adj:map.getOrDefault(curr,new ArrayList<>())){
            if (!visited[adj]){
                temp.addAll(dfs(visited,map,cost,ans,adj));
            }
        }
        temp.add(cost[curr]);
        Collections.sort(temp);
        if (temp.size()>=3){
            long left = temp.get(0)* temp.get(1);
            long right = temp.get(temp.size()-3)* temp.get(temp.size()-2);
            ans[curr]=  ans[curr]=  Math.max(0,(Math.max(left,right)* temp.get(temp.size()-1)));
        }else{
            ans[curr]=1;
        }
        if(temp.size() <= 5) return temp;

        return Arrays.asList(temp.get(0),temp.get(1),temp.get(temp.size()-3),temp.get(temp.size()-2),temp.get(temp.size()-1));

    }

}
