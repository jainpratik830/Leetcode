package Google.April;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {

    List<List<String>> ans;
    boolean[][] dp;


    public void partitionHelper(List<String> curr,int i,String s){

        if (i==s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int j=i;j<s.length();j++){
            if (s.charAt(j)==s.charAt(i) && (j-i<=2 || dp[i+1][j-1])){
                dp[i][j]=true;
                curr.add(s.substring(i,j+1));
                partitionHelper(curr,j+1,s);
                curr.remove(curr.size()-1);
            }
        }


    }

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        dp = new boolean[s.length()][s.length()];
        partitionHelper(new ArrayList<>(),0,s);

        return ans;
    }

}
