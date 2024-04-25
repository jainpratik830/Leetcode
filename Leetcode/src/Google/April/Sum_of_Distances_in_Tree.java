package Google.April;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Sum_of_Distances_in_Tree {

    HashMap<Integer, ArrayList<Integer>> map;
    int[][] dp;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] ans = new int[n];
        dp = new int[n][n];
        map = new HashMap<>();

        for (int[] edge:edges){
            map.putIfAbsent(edge[0],new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.putIfAbsent(edge[1],new ArrayList<>());
            map.get(edge[1]).add(edge[0]);
        }

        for (int i=0;i<n;i++){
            dfs(i,0,i,new boolean[n]);
        }

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                ans[i] += dp[i][j];
            }
//            ans[i] = Arrays.asList(dp[i]).stream().collect((a,b)->(a+b));
            System.out.println(Arrays.toString(dp[i]));
        }
        return ans;
    }

    public void dfs(int curr,int currSum,int index,boolean[] visited){

        if (dp[index][curr]!=0){
            return;
        }

        if (visited[curr]){
            return;
        }
        visited[curr]=true;
        for (int i:map.getOrDefault(curr,new ArrayList<>())){
            if(!visited[i])
                dfs(i,currSum+1,index,visited);
        }

        dp[index][curr] = currSum;

        dp[curr][index] = currSum;
        return;

    }

}
