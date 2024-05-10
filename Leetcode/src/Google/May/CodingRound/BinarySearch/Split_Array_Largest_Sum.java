package Google.May.CodingRound.BinarySearch;

public class Split_Array_Largest_Sum {

    public int splitArray(int[] nums, int k) {

        int low =0;
        int high =0;

        for (int i:nums){
            low = Math.max(low,i);
            high+=i;
        }

        while (low<=high){

            int mid  = (low + (high-low)/2);

            if (numOfSplits(nums,mid)>k){
                low=mid+1;
            }else {
                high=mid-1;
            }

        }

        return low;
    }

    public int numOfSplits(int[] nums,int sum){

        int count =0;
        int curr =0;
        for (int i:nums){
            if (curr+i>sum){
                count++;
                curr=i;
            }else {
                curr+=i;
            }
        }

        return count+1;

    }

}
