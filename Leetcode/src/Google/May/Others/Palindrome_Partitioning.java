package Google.May.Others;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {

    List<List<String>> ans;

    public void helper(String s,int curr,boolean[][] dp,List<String> currList){

        if (curr==s.length()){
            ans.add(new ArrayList<>(currList));
            return;
        }

        for (int i=curr;i<s.length();i++){
            if (s.charAt(i)==s.charAt(curr) && (i-curr<=2 || dp[curr+1][i-1])){
                dp[curr][i]=true;
                currList.add(s.substring(curr,i+1));
                helper(s,i+1,dp,currList);
                currList.remove(currList.size()-1);
            }
        }

    }


    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        helper(s,0,dp,new ArrayList<>());

        return ans;
    }

}
