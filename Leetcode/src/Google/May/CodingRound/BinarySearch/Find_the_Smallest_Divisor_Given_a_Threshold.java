package Google.May.CodingRound.BinarySearch;

public class Find_the_Smallest_Divisor_Given_a_Threshold {

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int i:nums){
            high = Math.max(i,high);
        }

        while (low<=high){

            int mid = (low + (high-low)/2);

            if (sum(nums,mid)<=threshold){
                high=mid-1;
            }else {
                low= mid+1;
            }

        }

        return low;
    }


    public int sum(int[] nums,int divisor){

        int ans =0 ;
        for (int i=0;i<nums.length;i++){
            ans += Math.ceil((1.0*nums[i]/divisor));
        }

        return ans;

    }
}
