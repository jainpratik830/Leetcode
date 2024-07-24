package Google.July;

import java.util.*;

public class Maximum_Profit_in_Job_Scheduling {

    int[] dp;

    public int binarySearch(int[] time,int target,int start){
        int left = start;
        int right = time.length-1;
        int ans =time.length;
        while (left<=right){
            int mid = (left+right)/2;

            if (time[mid]>=target){
                ans = mid;
                right= mid-1;
            }else {
                left=mid-1;
            }
        }
        return ans;

    }
    public int solve(List<int[]> jobs,int[] startTime,int index){

        if (index==startTime.length){
            return 0;
        }

        if (dp[index]!=-1){
            return dp[index];
        }

        int nextIndex = binarySearch(startTime,jobs.get(index)[1],index);

        int ans = Math.max(solve(jobs,startTime,index+1), jobs.get(index)[2]+solve(jobs,startTime,nextIndex) );

        return dp[index]=ans;

    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<int[]> jobs =new ArrayList<>();

        int n=startTime.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        for (int i=0;i<n;i++){
            int[] temp = new int[]{startTime[i],endTime[i],profit[i]};
            jobs.add(temp);
        }

        Collections.sort(jobs, Comparator.comparingInt(a->a[0]));
        for (int i=0;i<n;i++){
            startTime[i]=jobs.get(i)[0];
        }

        return solve(jobs,startTime,0);
    }

}
