package Google.July;

import java.util.ArrayList;
import java.util.List;

public class Apply_Operations_to_Make_Two_Strings_Equal {

    public int minOperations(String s1, String s2, int x) {
        List<Integer> diff = new ArrayList<>();
        for (int i=0;i<s1.length();i++){
            if (s1.charAt(i)!=s2.charAt(i)){
                diff.add(i);
            }
        }

        int m = diff.size();
        if (m%2!=0){
            return -1;
        }
        Integer[][] dp = new Integer[m][m];
        return helper(0,m-1,diff,dp,x);

    }

    public int helper(int start,int end,List<Integer> list,Integer[][] dp,int x){


        if (end<=start){
            return 0;
        }

        if (dp[start][end]!=null){
            return dp[start][end];
        }

        int ans =Integer.MAX_VALUE;

        for (int i=start+1;i<=end;i+=2){
            ans = Math.min(ans, Math.min(x,list.get(i)-list.get(start))+helper(start+1,i-1,list,dp,x)+helper(i+1,end,list,dp,x)  );
        }


        return dp[start][end]=ans;
    }

}
