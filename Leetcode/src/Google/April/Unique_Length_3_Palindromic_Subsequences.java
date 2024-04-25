package Google.April;

import java.util.HashSet;
import java.util.Set;

public class Unique_Length_3_Palindromic_Subsequences {

    public int countPalindromicSubsequence(String s) {

        int ans =0;
        boolean[] done = new boolean[26];

        for (int i=0;i<s.length();i++){

            int curr  = s.charAt(i);
            if (done[curr-'a']){
                continue;
            }else{
                for (int j=s.length()-1;j>i+1;j--){
                    if(s.charAt(j)==curr){
                        System.out.println("i="+i);
                        Set<Character> set = new HashSet<>();
                        for (int k=i+1;k<j;k++){
                            set.add(s.charAt(k));
                        }
                        ans+=set.size();
                        break;
                    }
                }
            }
            done[curr-'a']=true;

        }
        return ans;

    }


}
