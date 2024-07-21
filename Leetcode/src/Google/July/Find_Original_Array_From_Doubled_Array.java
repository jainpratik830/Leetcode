package Google.July;

import java.util.Arrays;
import java.util.HashMap;

public class Find_Original_Array_From_Doubled_Array {

    public int[] findOriginalArray(int[] changed) {
        if (changed.length%2!=0){
            return new int[0];
        }

        int[] ans = new int[changed.length/2];

        HashMap<Integer,Integer> freq=new HashMap<>();
        for (int i:changed){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }

        Arrays.sort(changed);
        int index= 0;
        for (int i:changed){

            if (freq.get(i)>0){

                if (freq.containsKey(i*2)){
                    if (freq.get(i*2)>0){
                        freq.put(i*2,freq.get(i*2)-1 );
                        freq.put(i,freq.get(i)-1);
                        ans[index++]=i;
                    }else {
                        return new int[0];
                    }
                }else {
                    return new int[0];
                }

            }

        }

        return ans;
    }

}
