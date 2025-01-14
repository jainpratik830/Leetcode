package Mission_2025.January.Daily_Problems;

public class Minimum_Length_of_String_After_Operations {

    public int minimumLength(String s) {
        int[] count = new int[26];
        for (char c:s.toCharArray()){
            count[c-'a']++;
        }
        int ans =0;
        for (int i=0;i<26;i++){
            if (count[i]!=0) {
                if (count[i] % 2 == 0) {
                    count[i] = 2;
                } else {
                    count[i] = 1;
                }
            }
            ans+= count[i];
        }
        return ans;
    }

}
