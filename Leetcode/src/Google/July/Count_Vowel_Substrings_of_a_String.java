package Google.July;

import java.util.HashMap;

public class Count_Vowel_Substrings_of_a_String {

    public int countVowelSubstrings(String word) {
        return countVowelSubstringsUtil(word,5)-countVowelSubstringsUtil(word,4);
    }

    public int countVowelSubstringsUtil(String word,int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int ans =0;
        int left=0,right=0;
        for (right=0;right<word.length();right++){
            if (!isVowel(word.charAt(right))){
                map.clear();;
                left=right+1;
                continue;
            }
            map.put(word.charAt(right),map.getOrDefault(word.charAt(right),0)+1);
            while (map.size()>k){
                char c = word.charAt(left);
                if(map.get(c)==1){
                    map.remove(c);
                }else {
                    map.put(c,map.get(c)-1);
                }
                left++;
            }
            ans+= right-left+1;

        }
        return ans;
    }

    public boolean isVowel(Character c){
        return c=='a' || c=='i' || c=='o' || c=='u' || c=='e';
    }
}
