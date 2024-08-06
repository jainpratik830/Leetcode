package Google.August;

public class Delete_Operation_for_Two_Strings {

    Integer[][] dp;

    public int recurse(int i,int j,String text1, String text2){



        if (i==text1.length() && j==text2.length()){
            return 0;
        }

        if (i==text1.length()){
            return text2.length()-j;
        }

        if (j==text2.length()){
            return text1.length()-i;
        }

        if (dp[i][j]!=null){
            return dp[i][j];
        }

        if (text1.charAt(i)==text2.charAt(j)){
            dp[i][j]=recurse(i+1,j+1,text1,text2);
        }else {
            dp[i][j]= 1+ Math.min(recurse(i+1,j,text1,text2),recurse(i,j+1,text1,text2));
        }

        return dp[i][j];

    }

    public int minDistance(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        dp = new Integer[m][n];
        return recurse(0,0,text1,text2);
    }
}

 