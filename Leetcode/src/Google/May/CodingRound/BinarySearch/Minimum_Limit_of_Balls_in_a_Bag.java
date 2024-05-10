package Google.May.CodingRound.BinarySearch;

public class Minimum_Limit_of_Balls_in_a_Bag {


    public boolean opsCount(int[] nums,int bagSize,int maxOps){

        int count =0;
        for (int i=0;i<nums.length;i++){

                count+= Math.ceil(1.0*nums[i]/bagSize);
        }

        return count<=maxOps+nums.length;
    }

    public int minimumSize(int[] nums, int maxOperations) {

        int low =1;
        int high= Integer.MIN_VALUE;
        for (int i:nums){
            high = Math.max(high,i);
        }

        while (low<=high){

            int mid = low + (high-low)/2;
            if (opsCount(nums,mid,maxOperations)){
                high = mid-1;
            }else {
                low = mid+1;
            }

        }
        return low ;

    }

}
