package Google.May.Array;

import java.util.Collections;
import java.util.TreeMap;

public class Relative_Ranks {

    public String[] findRelativeRanks(int[] score) {
        TreeMap<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i=0;i<score.length;i++){
            map.put(score[i],i);
        }

        String[] ranks = new String[score.length];
        int rank = 1;
        for (int i: map.keySet()){
            int curr = map.get(i);
            if (rank==1){
                ranks[curr]="Gold Medal";
                rank++;
            }
            else if (rank==2){
                ranks[curr]="Silver Medal";
                rank++;
            }
            else if (rank==3){
                ranks[curr]="Bronze Medal";
                rank++;
            }else{
                ranks[curr]=String.valueOf(rank);
                rank++;
            }
        }
        return ranks;
    }

}
