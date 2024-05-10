package Google.May.CodingRound.BinarySearch;

public class Minimized_Maximum_of_Products_Distributed {


    public boolean isPossible(int[] quanities,int n,int mid){
        int cnt = 0 ;
        for(int i: quanities){
            cnt += (i / mid) ;
            if(i % mid != 0){
                cnt++ ;
            }
        }
        return cnt <= n ;

    }

    public int minimizedMaximum(int n, int[] quantities) {

        int low = 1;
        int high = Integer.MIN_VALUE;

        for (int i:quantities){
            high= Math.max(high,i);
        }

        while (low<=high){

            int mid = low + (high-low)/2;
            if (isPossible(quantities,n,mid)){
                high = mid-1;
            }else {
                low = mid+1;
            }

        }
        return low ;
    }

}
