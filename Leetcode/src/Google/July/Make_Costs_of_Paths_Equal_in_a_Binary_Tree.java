package Google.July;

public class Make_Costs_of_Paths_Equal_in_a_Binary_Tree {

    int ans;

    public int minIncrements(int n, int[] cost) {
        ans=0;
        solve(cost,n,0);
        return ans;
    }

    public int solve(int[] cost,int n,int i){

        if (i>=n){
            return 0;
        }

        int l = solve(cost,n,2*i+1);
        int r = solve(cost,n,2*i+2);

        ans+= Math.abs(l-r);

        return cost[i]+Math.max(l,r);

    }

}
