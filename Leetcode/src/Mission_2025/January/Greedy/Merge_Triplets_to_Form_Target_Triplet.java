package Mission_2025.January.Greedy;

import java.util.ArrayList;
import java.util.List;

public class Merge_Triplets_to_Form_Target_Triplet {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int max_1= Integer.MIN_VALUE,max_2= Integer.MIN_VALUE,max_3= Integer.MIN_VALUE;
        for (int[] i:triplets){
            if (i[0]>target[0] || i[1]>target[1] || i[2]>target[2]){
                continue;
            }
            if (i[0]==target[0] || i[1]==target[1] || i[2]==target[2]){
                max_1 =Math.max(max_1,i[0]);
                max_2 =Math.max(max_2,i[1]);
                max_3 =Math.max(max_3,i[2]);
            }
        }

        return max_1==target[0] && max_2==target[1] && max_3==target[2];
    }

}
