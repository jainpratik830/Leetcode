package Google.July;

public class Number_of_Digit_One {

    Integer[][][] dp;
    public int countDigitOne(int n) {

        dp = new Integer[10][2][10];

        return solve(String.valueOf(n),0,1,0);
    }
    public int solve(String n,int index,int tight,int sum){

        if (index==n.length()){
            return sum;
        }

        if (dp[index][tight][sum]!=null){
            return dp[index][tight][sum];
        }

        int ans =0;

        int limit= ((tight==1) ? n.charAt(index)-'0' : 9);

        for (int i=0;i<=limit;i++){

            int newSum = sum+ ( (i==1) ? 1: 0);
            int newLimit = (i==limit) ? tight : 0;
            ans += solve(n,index+1,newLimit,newSum);
        }


        dp[index][tight][sum]=ans;
        return ans;
    }


//    Integer[][][] dp;
//
//    public int solve(String n,int index,int tight,int cnt){
//
//        if (index==n.length()){
//            return cnt;
//        }
//
//        if (dp[index][tight][cnt]!= null){
//            return dp[index][tight][cnt];
//        }
//
//        int ans =0;
//        int limit= tight==1 ? n.charAt(index)-'0' : 9;
//        for (int i=0;i<=(limit);i++){
//            int updatedCount = cnt+ (i==1 ? 1: 0);
//            int newDecider = i < limit ? 0 : tight;
//            ans += solve(n,index+1,newDecider,updatedCount);
//        }
//
//        return dp[index][tight][cnt]=ans;
//    }
//
//    public int countDigitOne(int n) {
//        dp = new Integer[10][2][10];
//
//        int ans = solve(String.valueOf(n),0,1,0);
//
//        return ans;
//
//    }

}
