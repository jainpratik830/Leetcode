package Google.May.Array;

import java.util.*;

public class Maximum_Profit_in_Job_Scheduling {
    int[] dp;

    public int maxProfit(List<List<Integer>> list,int[] startTime,int index,int n){

        if (index==n){
            return 0;
        }

        if (dp[index]!=-1){
            return dp[index];
        }
//        int next =  binarySearch(startTime,list.get(index).get(1));
        int next=  binarySearch(startTime,list.get(index).get(1));
        // if (next >= 0) {
        //     // Element found, insertion index is the same as the found index
        //     next = next;
        // } else {
        //     // Element not found, calculate insertion index
        //     next = -next - 1;
        // }
        int ans = Math.max(maxProfit(list,startTime,index+1,n), list.get(index).get(2)+maxProfit(list,startTime,next,n)  );

        return dp[index]=ans;

    }

    public int binarySearch(int[] startTime,int lastEnd){
        int left = 0;
        int right = startTime.length;

        while (left<=right){
            int mid  = left + (right-left)/2;
            if (startTime[mid]<lastEnd){

                left = mid+1;


            }else{
                right = mid-1;
            }
        }
        return left;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int ans =0;
        dp = new int[startTime.length];
        Arrays.fill(dp,-1);
        List<List<Integer>> list= new ArrayList<>();


        for (int i=0;i<startTime.length;i++){

            List<Integer> temp= new ArrayList<>();
            temp.add(startTime[i]);
            temp.add(endTime[i]);
            temp.add(profit[i]);
            list.add(temp);
        }

        list.sort(Comparator.comparingInt(a -> a.get(0)));

        for (int i=0;i<startTime.length;i++){
            startTime[i]=list.get(i).get(0);
        }




        return maxProfit(list,startTime,0,startTime.length);
    }


}
