package Google.March;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwentyFour_Game {

    public List<Double> possible(double a, double b){
        return Arrays.asList(a+b,a-b,b-a,a*b,b/a,a/b);
    }
    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int i:cards){
            list.add((double) i);
        }


        return dfs(list);
    }

    public boolean dfs(List<Double> list ){
        if (list.size()==1){
            return  Math.abs(list.get(0) - 24)<0.001;
        }

        for (int i=0;i<list.size();i++){
            for (int j=i+1;j<list.size();j++){
                List<Double> next = possible(list.get(i),list.get(j));
                for (double k:next){
                    List<Double> nextRound = new ArrayList<>();
                    nextRound.add(k);
                    for (int l=0;l< list.size();l++){
                        if (l!=i && l!=j){
                            nextRound.add(list.get(l));
                        }


                    }
                    if (dfs(nextRound)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
