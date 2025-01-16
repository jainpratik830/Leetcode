package Mission_2025.January.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palindrome_Partitioning {

    List<List<String>> ans;
    boolean[][] dp;

    public boolean isValid(String s,int l,int r){

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public void generateSets(String s,int i,List<String> curr){


        if (i==s.length()){
            // curr.add(currString.toString());
            ans.add(new ArrayList<>(curr));
            return;
        }


        for (int j=i;j<s.length();j++){
            if (dp[i][j]){
                curr.add(s.substring(i,j+1));
                generateSets(s,j+1,curr);
                curr.remove(curr.size()-1);
            }
        }

    }

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        dp = new boolean[s.length()][s.length()];
        for (int length =1;length<=s.length();length++){
            for (int i=0;i+length<=s.length();i++){
                int j = i+length-1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (length == 1 || length == 2) || dp[i + 1][j - 1];
                }
            }
        }
        generateSets(s,0,new ArrayList<>());
        return ans;
    }

}
