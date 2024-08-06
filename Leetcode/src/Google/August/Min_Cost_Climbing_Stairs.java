package Google.August;

public class Min_Cost_Climbing_Stairs {

    public int minCostClimbingStairs(int[] cost) {
        int a=cost[0];
        int b=cost[1];
        for (int i=2;i<cost.length;i++){
            int temp = b;
            b= cost[i]+Math.min(a,b);
            a = temp;
        }

        return Math.min(a,b);
    }

}
