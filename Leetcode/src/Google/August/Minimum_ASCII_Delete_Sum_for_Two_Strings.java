package Google.August;

public class Minimum_ASCII_Delete_Sum_for_Two_Strings {

    Integer[][] dp;

    public int recurse(int i,int j,String text1, String text2){
        if (i==text1.length() && j==text2.length()){
            return 0;
        }

        if (i==text1.length()){
            int sum=0;
            for (int k=j;k<text2.length();k++){
                sum+= text2.charAt(k);
            }
            return sum;
        }

        if (j==text2.length()){
            int sum=0;
            for (int k=i;k<text1.length();k++){
                sum+= text1.charAt(k);
            }
            return sum;
        }

        if (dp[i][j]!=null){
            return dp[i][j];
        }

        if (text1.charAt(i)==text2.charAt(j)){
            dp[i][j]=recurse(i+1,j+1,text1,text2);
        }else {
            dp[i][j]=  Math.min(text1.charAt(i)+recurse(i+1,j,text1,text2),text2.charAt(j)+recurse(i,j+1,text1,text2));
        }

        return dp[i][j];

    }


    public int minimumDeleteSum(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        dp = new Integer[m][n];
        return recurse(0,0,text1,text2);
    }

}
