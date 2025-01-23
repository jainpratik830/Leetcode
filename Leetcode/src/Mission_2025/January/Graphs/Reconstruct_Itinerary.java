package Mission_2025.January.Graphs;

import java.util.*;

public class Reconstruct_Itinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (List<String> ticket:tickets){
            map.putIfAbsent(ticket.get(0),new LinkedList<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }

        for (String key:map.keySet()){
            Collections.sort(map.get(key));
        }

        List<String> ans = new LinkedList<>();
        dfs(map,"JFK",ans);
        return ans;
    }

    public void dfs(HashMap<String,List<String>> map,String curr,List<String> ans){

        List<String> destination = map.getOrDefault(curr,new LinkedList<>());

        while (!destination.isEmpty()){
            String dest = destination.get(0);
            destination.remove(0);
            dfs(map,dest,ans);
        }

        ans.add(0,curr);
    }


}
