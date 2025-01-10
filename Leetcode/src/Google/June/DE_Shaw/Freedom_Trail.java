package Google.June.DE_Shaw;

import java.util.Arrays;
import java.util.HashSet;

public class Freedom_Trail {

    public int recurse(String ring,String key,int index,int ringCurr,int[][] dp){

        if (index==key.length()){
            return 0;
        }

        if (dp[ringCurr][index]!=0){
            return dp[ringCurr][index];
        }
        int ans = Integer.MAX_VALUE;
        // System.out.println("index="+index+" ring="+ringCurr);
        for (int i=0;i<ring.length();i++){

            int idx =( i+ringCurr)%ring.length();
            if (ring.charAt(idx)==key.charAt(index)){
                int clockwise  =Math.abs(idx-ringCurr);
                int anti = Math.abs(ring.length()-clockwise);
                int count =Math.min(anti,clockwise);
                // System.out.println("clockwise="+clockwise+" anticlockwise="+anti);
                ans= Math.min(ans,1+count+recurse(ring,key,index+1,idx,dp));
            }
        }

        return dp[ringCurr][index]=ans;

    }

    public int findRotateSteps(String ring, String key) {

        int[][] dp = new int[ring.length()][key.length()];
        return recurse(ring,key,0,0,dp);
    }

}
