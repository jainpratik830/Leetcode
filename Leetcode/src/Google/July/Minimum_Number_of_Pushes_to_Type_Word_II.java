package Google.July;

import java.util.Arrays;
import java.util.Comparator;

public class Minimum_Number_of_Pushes_to_Type_Word_II {
    public int minimumPushes(String word) {
        int[] arr=  new int [26];
        for (char c:word.toCharArray()){
            arr[c-'a']++;
        }
        Arrays.sort(arr);
        int ans =0;
        int count =0;
        for (int i=arr.length-1;i>=0;i--){
//            count++;
            ans+= arr[i]*(count/8+1);
            count++;
        }

        return ans;

    }

}
