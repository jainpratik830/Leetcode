package Google.August;

import java.util.HashSet;
import java.util.Set;

public class Vowels_of_All_Substrings {

    public long countVowels(String word) {
        long ans = 0;
        Set<Character> vowels = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));
        int n = word.length();
        for (int i=0;i<n;i++){
            if (vowels.contains(word.charAt(i))){
                ans+= ((long)(i+1))*((long)(n-i));
            }
        }

        return ans;

    }

}
