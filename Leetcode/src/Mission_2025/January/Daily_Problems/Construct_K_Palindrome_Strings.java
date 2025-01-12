package Mission_2025.January.Daily_Problems;

public class Construct_K_Palindrome_Strings {

    public boolean canConstruct(String s, int k) {
        if (s.length()<k){
            return false;
        }

        int[] count = new int[26];
        for (char c:s.toCharArray()){
            count[c-'a']++;
        }

        int oddCount = 0;
        for (int i:count){
            if (i%2==1){
                oddCount++;
            }
        }

        if (oddCount>k){
            return false;
        }
        return true;
    }

}
