package Google.July;

public class Number_of_Ways_to_Build_Sturdy_Brick_Wall {

    int MOD = 1000000007;

    public int buildWall(int height, int width, int[] bricks) {
        Integer[][] dp = new Integer[height+1][1<< width];
        return solve(height,width,0,0,dp,bricks,0);
    }

    public int solve(int h,int w,int prev,int curr,Integer[][] dp,int[] bricks,int currWidth){

        if (dp[h][prev]!=null){
            return dp[h][prev];
        }

        if (h==0){
            return 1;
        }

        if (currWidth==w){
            return solve(h-1,w,curr,0,dp,bricks,0);
        }
        int count =0;
        for (int b:bricks){

            int newSum = currWidth+b;
            int newConfig = newSum > w ? curr : (curr | (1<< newSum));
            if (newSum>w || (newConfig & prev) >0){
                continue;
            }

            count = (count+solve(h,w,prev,newConfig,dp,bricks,newSum))%MOD;
        }

        return curr==0 ? dp[h][prev]=count : count;

    }

}
