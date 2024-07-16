package Google.July;

public class Count_of_Integers {

    Integer[][][] dp;
    int modulo = (int) (Math.pow(10,9)+7);
    int min_sum,max_sum;

    public int solve(String n,int index,int tight,int sum){

        if(index==n.length()){
            // System.out.println(sum);
            if(min_sum<=sum&&sum<=max_sum){
                // System.out.println(sum);
                return 1;
            }
            else return 0;
        }

        if (dp[index][tight][sum]!= -1){
            return dp[index][tight][sum]%modulo;
        }

        int ans =0;
        int limit= ((tight==1) ? n.charAt(index)-'0' : 9);
        for (int i=0;i<=(limit);i++){
            // if ((sum+i)>=min_sum && (sum+i)<=max_sum){
            int updatedCount = sum+i;
            int newDecider = ((i < limit) ? 0 : tight);
            ans += solve(n,index+1,newDecider,updatedCount);
            ans = ans%modulo;
            // }else {
            // continue;
            // }
        }
        // System.out.println("index="+index+" tight="+tight+" sum="+sum+" ans="+ans);
        return dp[index][tight][sum]=ans;
    }


    public int count(String num1, String num2, int min_sum, int max_sum) {
        dp = new Integer[23][2][401];
        for(int i=0;i<23;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<401;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        this.min_sum=min_sum;
        this.max_sum= max_sum;
        int two = solve((num2),0,1,0)%modulo;;
        int num1Sum=0;

        for(int i=0;i<23;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<401;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        int one = solve(num1,0,1,0)%modulo;
        for(int i=0;i<num1.length();i++){
            num1Sum+=num1.charAt(i)-'0';
        }
        if(min_sum<=num1Sum&&num1Sum<=max_sum){
            return (two-one+1+modulo)%modulo;
        }
        else return (two-one+modulo)%modulo;

    }

}
