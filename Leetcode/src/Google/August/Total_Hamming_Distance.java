package Google.August;

public class Total_Hamming_Distance {

    public int totalHammingDistance(int[] nums) {

        int ans =0;

        for (int i=0;i<31;i++){
            int curr = 1<<i;
            int zero =0,ones =0;
            for (int j=0;j<nums.length;j++){
                if ((curr & nums[j])==0){
                    zero++;
                }else {
                    ones++;
                }
            }
            ans += zero*ones;
        }
        return ans;
    }

}
