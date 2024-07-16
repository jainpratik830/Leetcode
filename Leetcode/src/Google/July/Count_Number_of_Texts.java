package Google.July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Count_Number_of_Texts {

    int mod=((int)Math.pow(10,9)+7);
    public int countTexts(String press) {
        int dp[]=new int[press.length()+1];
        Arrays.fill(dp,-1);
        return recur(0,press,dp);

    }
    int recur(int i,String press,int dp[]){
        if(i==press.length()){
            return 1;
        }
        if(dp[i]!=-1) return dp[i];
        int c=0;
        int o1=recur(i+1,press,dp);
        int o2=0;
        if(i<press.length()-1 &&  press.charAt(i)==press.charAt(i+1)){
            o2=recur(i+2,press,dp);
        }
        int o3=0;
        if(i<press.length()-2 &&  press.charAt(i)==press.charAt(i+1) &&  press.charAt(i)==press.charAt(i+2)){
            o3=recur(i+3,press,dp);
        }
        int o4=0;
        if(i+3<press.length() && (press.charAt(i)=='7' || press.charAt(i)=='9') && press.charAt(i)==press.charAt(i+1) &&  press.charAt(i)==press.charAt(i+2) && press.charAt(i)==press.charAt(i+3) ){
            o4=recur(i+4,press,dp);

        }
        c=(((((o1+o2)%mod)+o3)%mod)+o4)%mod;
        return dp[i]=c;
    }

}
