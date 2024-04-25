package Google.April;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Accounts_Merge {

    public void dfs(HashMap<String,List<String>> adj ,HashMap<String,Boolean> visited,String curr,List<String> account){
        if (visited.getOrDefault(curr,true)){
            return;
        }
        account.add(curr);
        visited.put(curr,true);
        for (String s: adj.getOrDefault(curr,new ArrayList<>())){
            if (!visited.getOrDefault(s,true)){
                dfs(adj,visited,s,account);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<String>> adj = new HashMap<>();
        HashMap<String,Boolean> visited = new HashMap<>();
        for (List<String> account:accounts){
            String name = account.get(0);
            String first = account.get(1);
            adj.putIfAbsent(first,new ArrayList<>());
            visited.put(first,false);
            for (int i=2;i<account.size();i++){
                adj.get(first).add(account.get(i));
                adj.putIfAbsent(account.get(i),new ArrayList<>());
                adj.get(account.get(i)).add(first);
                visited.put(account.get(i),false);
            }
        }

        for (List<String> account:accounts){
            String name = account.get(0);
            String first = account.get(1);
            if (!visited.getOrDefault(first,true)){
                List<String> list = new ArrayList<>();
                list.add(name);
                dfs(adj,visited,first,list);

                Collections.sort(list.subList(1, list.size()));
                ans.add(list);
            }

        }

        return ans;
    }

}
