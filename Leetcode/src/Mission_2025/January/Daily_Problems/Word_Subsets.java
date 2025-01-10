package Mission_2025.January.Daily_Problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Word_Subsets {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();

        int[] count = new int[26];

        for (String s:words2){
            int[] curr = new int[26];
            for (char c:s.toCharArray()){
                curr[c-'a']++;
            }

            for (int i=0;i<26;i++){
                count[i]= Math.max(count[i],curr[i]);
            }
        }

        for (String s:words1){
            int[] curr = new int[26];
            for (char c:s.toCharArray()){
                curr[c-'a']++;
            }

            boolean isUniversal = true;
            for (int i=0;i<26;i++){
                if (curr[i]<count[i]){
                    isUniversal=false;
                }
            }

            if (isUniversal){
                ans.add(s);
            }

        }


        return ans;
    }

}
