package Google.May.Array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Boats_to_Save_People {

    public int numRescueBoats(int[] people, int limit) {
        int count =0;
        Arrays.sort(people);
        int low = 0;
        int high = people.length-1;

        while (low<high){
            int curr = people[low]+people[high];
            if (curr>limit){
                count++;
                high--;
            }else {
                count++;
                high--;
                low++;
            }
        }

        if (low == high){
            count++;
        }
        return count;
    }

}
