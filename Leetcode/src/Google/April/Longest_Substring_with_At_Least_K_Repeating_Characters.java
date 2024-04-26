package Google.April;

import java.util.Arrays;

public class Longest_Substring_with_At_Least_K_Repeating_Characters {

    public int helper(int left,int right,String s,int k){

        if (right-left<k){
            return 0;
        }

        int[] count = new int[26];
        for (int i=left;i<right;i++){
            count[s.charAt(i)-'a']++;
        }

        for (int i=left;i<right;i++){
            if (count[s.charAt(i)-'a']>=k){
                continue;
            }

            return Math.max(helper(left,i,s,k),helper(i+1,right,s,k));
        }

        return right-left;

    }

    public int longestSubstring2(String s, int k) {

        return helper(0,s.length(),s,k);
    }
    public int check(int[] count,int k){

        for (int i=0;i<26;i++){
            if (count[i]>0 && count[i]<k){
                return i;
            }
        }
        return -1;

    }




    public int longestSubstring(String s, int k) {

        int ans =0;
        int[] count;

        if (s.length()==1){
            if (k==1){
                return 1;
            }
        }

        for (int i=0;i<s.length();i++){
            count = new int[26];
            count[s.charAt(i)-'a']++;
            for (int j=i+1;j<s.length();j++){
                count[s.charAt(j)-'a']++;
                if (check(count,k)==-1){
                    ans = Math.max(ans,j-i+1);
                }
            }
        }

        return ans;
    }
}
