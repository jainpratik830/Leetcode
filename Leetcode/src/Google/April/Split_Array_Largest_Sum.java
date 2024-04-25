package Google.April;

public class Split_Array_Largest_Sum {

    public int splitArray(int[] nums, int k) {
        int ans =0;
        int min = Integer.MIN_VALUE;
        int max = 0;

        for (int i:nums){
            min = Math.max(i,min);
            max +=i;
        }


        int mid= 0;
        while (min<max){
            mid = min + (max-min)/2;
            int day = calcSplits(nums,mid);
            if (day>k){
                min  = mid+1;
            }else{
                max = mid;
            }
        }

        return min;
    }


    public int calcSplits(int[] weights,int i){
        int curr = 0;
        int sum = 0;
        for (int j=0;j<weights.length;j++){
            sum+=weights[j];
            // System.out.println(sum);
            if (sum>i){
                curr++;
                sum= weights[j];
            }

        }
        return curr+1;
    }

}
