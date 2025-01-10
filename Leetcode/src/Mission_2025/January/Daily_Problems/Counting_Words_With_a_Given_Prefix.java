package Mission_2025.January.Daily_Problems;

public class Counting_Words_With_a_Given_Prefix {

    public int prefixCount(String[] words, String pref) {
        int ans =0;

        for (String word:words){
            if (word.startsWith(pref)){
                ans++;
            }
        }
        return ans;
    }

}
