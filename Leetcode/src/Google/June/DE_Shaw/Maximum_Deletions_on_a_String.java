package Google.June.DE_Shaw;

import java.util.HashMap;

public class Maximum_Deletions_on_a_String {

    public int deleteChars(String s,int[] dp,int index){
        if (index>=s.length()){
            return 0;
        }

        if (dp[index] != 0) return dp[index];

        int res = 1;
        for (int i=index;i<index+(s.length()-index)/2;i++){
            if (dp[i]==0 && (s.substring(index,i+1).equals(s.substring(i+1,i+1+i+1-index )))){
                res =Math.max(res,1+deleteChars(s,dp,i+1));
            }

        }
        dp[index]=res;

        return dp[index];
    }

    public int deleteString(String s) {
        int[] dp= new int[s.length()];
        return deleteChars(s,dp,0);

    }

}
