package Google.April;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Maximum_Profit_in_Job_Scheduling {


    int[] dp;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();
        dp = new int[startTime.length];
        Arrays.fill(dp, -1);
        int length = profit.length;
        for (int i = 0; i < length; i++) {
            ArrayList<Integer> currJob = new ArrayList<>();
            currJob.add(startTime[i]);
            currJob.add(endTime[i]);
            currJob.add(profit[i]);
            jobs.add(currJob);
        }
        jobs.sort(Comparator.comparingInt(a -> a.get(0)));
        for (int i = 0; i < length; i++) {
            startTime[i] = jobs.get(i).get(0);
        }

        return findMaxProfit(jobs, startTime, length, 0);
    }

    public int binarySearch(int[] startTime,int lastEnd){
        int left = 0;
        int right = startTime.length;

        while (left<right){
            int mid  = left + (right-left)/2;
            if (startTime[mid]>=lastEnd){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public int findMaxProfit(List<List<Integer>> jobs,int[] startTime,int n,int index){

        if (index==n){
            return 0;
        }

        if (dp[index]!=-1){
            return dp[index];
        }

        int next = binarySearch(startTime,jobs.get(index).get(1));

        dp[index] = Math.max(findMaxProfit(jobs,startTime,n,index+1),jobs.get(index).get(2)+findMaxProfit(jobs,startTime,n,next));

        return dp[index];

    }

}
