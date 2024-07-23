package Google.July;

public class Longest_Repeating_Character_Replacement {

    public int characterReplacement(String s, int k) {
        int ans =k;
        int i=0;
        int j=0;
        int[] count =new int[26];
        int max = 0;
        while (j<s.length()){
            count[s.charAt(j)-'A']++;
            max = Math.max(count[s.charAt(j)-'A'],max);
            if (j-i-max+1>k){
                count[s.charAt(i)-'A']--;
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }

}
