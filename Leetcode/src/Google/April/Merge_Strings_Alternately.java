package Google.April;

public class Merge_Strings_Alternately {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans =new StringBuilder();
        int left =0;
        int right =0;
        boolean first = true;
        while (left<word1.length() && right<word2.length()){
            if (first){
                ans.append(word1.charAt(left++));
                first= !first;
            }else {
                ans.append(word2.charAt(right++));
                first= !first;
            }
        }
        while (left<word1.length()){
            ans.append(word1.charAt(left++));
        }
        while (right<word2.length()){
            ans.append(word2.charAt(right++));
        }

        return ans.toString();
    }

}
