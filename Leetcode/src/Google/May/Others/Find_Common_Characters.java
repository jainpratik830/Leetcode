package Google.May.Others;

import java.util.ArrayList;
import java.util.List;

public class Find_Common_Characters {

    public List<String> commonChars(String[] words) {
        List<String> list = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();
        for (String s:words){
            int[] curr = new int[26];
            for (char c:s.toCharArray()){
                curr[c-'a']++;
            }
            // System.out.println(Arrays.toString(curr));
            list2.add(curr);
        }

        for (int i=0;i<26;i++){
            int curr = 101;
            for (int[] cars:list2){
                curr = Math.min(curr,cars[i]);
            }
            // System.out.println("i="+i+" count="+curr+" curr= "+(char) (i+'a'));
            for (int j=0;j<curr;j++){
                list.add((char) (i+'a')+"");
            }
        }

        return list;
    }
}
