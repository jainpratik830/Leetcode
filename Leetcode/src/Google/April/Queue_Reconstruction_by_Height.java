package Google.April;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Queue_Reconstruction_by_Height {

    public int[][] reconstructQueue(int[][] people) {
       List<int[]> ans = new ArrayList<>();
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o2[0]-o1[0];
            }
        });

        for (int[] i:people){
            ans.add(i[1],i);
        }

        return ans.toArray(new int[people.length][2]);
    }

}
