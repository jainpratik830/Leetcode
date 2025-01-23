package Mission_2025.January.DP;

public class Longest_Palindromic_Substring {

    public int findPalindrome(int i,int j,String s){
        int left = i;
        int right = j;

        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        return (right-1-(left+1)+1);
    }

    public String longestPalindrome(String s) {
        int n = s.length();

        int[] ans = {0,0};
        for (int i=0;i<n;i++){

            int odd = findPalindrome(i,i,s);
            if (ans[1]-ans[0]+1<odd){
                int dist = odd/2;
                ans[0]=i-dist;
                ans[1]=i+dist;
            }

            int even = findPalindrome(i,i+1,s);
            if (ans[1]-ans[0]+1<even){
                int dist = even/2-1;
                ans[0]=i-dist;
                ans[1]=i+1+dist;
            }


        }

        return s.substring(ans[0],ans[1]+1);
    }


    public String longestPalindrome2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
//        if(s.length()==1){
//            return s;
//        }
        for (int i=0;i<n;i++){
            dp[i][i]=true;
            ans=s.substring(i,i+1);
        }
        for (int length = 1;length<n;length++){
            for (int i=0;i<n-length;i++){
                int j= i+length;
                if(i==j-1 && s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
                    if (j-i+1>ans.length()){
                        ans = s.substring(i,j+1);
                    }
                    continue;
                }
                if (dp[i+1][j-1] && s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
                    if (j-i+1>ans.length()){
                        ans = s.substring(i,j+1);
                    }
                }
            }
        }

        return ans;
    }

}
