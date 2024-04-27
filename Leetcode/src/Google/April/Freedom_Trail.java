package Google.April;



import java.util.HashMap;
public class Freedom_Trail {
//    Map<Pair<Integer, Integer>, Integer> bestSteps;
    public int dfs(int i,String s,String k,int index){



        if (i==k.length()){
            return 0;
        }

//        if (bestSteps.containsKey(new Pair<>(index, i))) {
//            return bestSteps.get(new Pair<>(index, i));
//        }

        int curr = k.charAt(i);
        int ans = Integer.MAX_VALUE;
        int j=0;
        while (j<s.length()){
            int temp  =  (index+j)%s.length();
            if (s.charAt(temp)==curr){
                int stepsAround = s.length() - j;
                int step = Math.min(stepsAround,j);
                int count_steps = step+1+dfs(i+1,s,k,temp);
                ans = Math.min(count_steps,ans);
                // bestSteps.put(new Pair<>(index, i), ans);
                // break;
            }

            j++;
        }

        // System.out.println("ans="+ans + " i="+i);
//        bestSteps.put(new Pair<>(index, i), ans);
        return ans;
    }

    public int findRotateSteps(String ring, String key) {
//      bestSteps = new HashMap<>();
        return dfs(0,ring,key,0);
    }

}
