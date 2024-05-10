package Google.May.CodingRound.BinarySearch;

public class Minimum_Time_to_Complete_Trips {

    public boolean isPossible(int[] time,int n,long mid){

        long count =0;
        for (int i=0;i<time.length;i++){
            count += mid/time[i];
        }
        // System.out.println(mid+" count="+count);
        return count >=n;

    }


    public long minimumTime(int[] time, int totalTrips) {

        long low =   Integer.MAX_VALUE;
        long high = Integer.MIN_VALUE;

        for (int i:time){
            low = Math.min(low,i);
            high= Math.max(high,i);
        }

        low  = 1;
        high  = totalTrips*high;

        while (low<=high){


            long mid = low + (high-low)/2;

            if (isPossible(time,totalTrips,mid)){
                high = mid-1;
            }else {
                low = mid+1;
            }

        }

        return low;
    }

}
