package Google.August;

public class Single_Number_III {

    public int[] singleNumber(int[] nums) {
        int ans =0;

        for (int i:nums){
            ans = ans^i;
        }

        int one = 0;

        for (int i=0;i<32;i++){
            if (((1<<i) & ans) !=0){
                one = (1<<i);
            }
        }
        int left = 0;
        for (int i:nums){
            if ((one & i) !=0){
                left = left^i;
            }
        }

        return new int[]{left,ans^left};
    }

}
