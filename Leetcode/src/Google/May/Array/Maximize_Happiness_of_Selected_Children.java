package Google.May.Array;

import java.util.Arrays;
import java.util.Comparator;

public class Maximize_Happiness_of_Selected_Children {

    public long maximumHappinessSum(int[] happiness, int k) {
        long ans =0;
        happiness = Arrays.stream(happiness).
                boxed().
                sorted(Comparator.reverseOrder()). // sort descending
                        mapToInt(i -> i).
                toArray();

        for (int i=0;i<=Math.min(k,happiness.length-1);i++){
            if (happiness[i]-i<=0){
                break;
            }else {
                ans+= happiness[i]-i;
            }
        }

        return ans;
    }

}
