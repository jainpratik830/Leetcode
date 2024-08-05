package Google.August;

import java.util.LinkedHashMap;

public class Kth_Distinct_String_in_an_Array {

    public String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        for (String s:arr){
            map.put(s,map.getOrDefault(s,0)+1);
        }

        for (String s: map.keySet()){
            if (map.get(s)>1){
                continue;
            }else {
                if (k==1){
                    return s;
                }
                k--;
            }
        }

        return "";
    }



}
