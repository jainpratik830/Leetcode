package Google.July;

import java.util.*;

public class Find_All_Possible_Recipes_from_Given_Supplies {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans = new ArrayList<>();
        HashMap<String,List<String>> preReq = new HashMap<>();
        Set<String> avail = new HashSet<>();
        HashMap<String,Integer> index = new HashMap<>();

        for (int i=0;i<recipes.length;i++){
            index.put(recipes[i],i);
        }

        for (String s:supplies){
            avail.add(s);
        }
        int[] indegree= new int[recipes.length];

        for (int i=0;i<recipes.length;i++){

            for (String s: ingredients.get(i)){
                if (avail.contains(s)){
                    continue;
                }

                preReq.putIfAbsent(s,new ArrayList<>());
                preReq.get(s).add(recipes[i]);
                indegree[i]++;
            }

        }

        Queue<Integer> queue= new LinkedList<>();
        for (int i=0;i< recipes.length;i++){
            if (indegree[i]==0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int i= queue.poll();
            ans.add(recipes[i]);

            if(!preReq.containsKey(recipes[i])){
                continue;
            }

            for (String s:preReq.get(recipes[i])){

                indegree[index.get(s)]--;
                if (indegree[index.get(s)]==0){
                    queue.add(index.get(s));
                }

            }

        }




        return ans;
    }


}
