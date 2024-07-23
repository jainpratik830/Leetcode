package Google.July;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Candy {

    public int candy(int[] ratings) {
        int peak = 0 , valley = 0 , size = ratings.length,candy_count = size ;
        for(int i = 1 ; i< size ;){
            if(ratings[i] == ratings[i-1]){ i++ ; continue;}
            peak = 0 ;
            valley = 0;
            while( i< size && ratings[i] > ratings[i-1]){
                peak++;
                i++;
                candy_count += peak;
            }


            while(i<size && ratings[i] < ratings[i-1]){
                valley++;
                i++;
                candy_count += valley;
            }

            candy_count -= Math.min(peak,valley);
        }
        return candy_count;
    }


}
