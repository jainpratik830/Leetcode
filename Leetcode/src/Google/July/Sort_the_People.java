package Google.July;

import java.util.Arrays;
import java.util.Comparator;

public class Sort_the_People {

    public String[] sortPeople(String[] names, int[] heights) {
        String[] ans = new String[names.length];
        String[][] obj  = new String[names.length][2];
        for (int i=0;i<names.length;i++){
            obj[i]= new String[]{names[i],String.valueOf(heights[i])};
        }

        Arrays.sort(obj, Comparator.comparingInt(a->-1*Integer.parseInt(a[1])));
        for (int i=0;i<names.length;i++){
            ans[i]= obj[i][0];
        }
        return ans;
    }
}
