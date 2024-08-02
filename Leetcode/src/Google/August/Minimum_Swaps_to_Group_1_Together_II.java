package Google.August;

public class Minimum_Swaps_to_Group_1_Together_II {

    public int minSwaps(int[] nums) {
        int count=0;
        for (int i:nums){
            if (i==1){
                count++;
            }
        }

        if (count==0 || count== nums.length){
            return 0;
        }

        int left =0;
        int right =0;
        int window_count=0;
        int ans =nums.length;
        while (right<nums.length){

            if (right-left+1>count){
                if (nums[left]==1){
                    window_count--;
                }
                left++;
            }
            if (nums[right]==1){
                window_count++;
            }
            right++;
            ans = Math.min(ans,count-window_count);
        }


        int zero_count = nums.length-count;
        left =0;
        right =0;
        window_count=0;
        while (right<nums.length){

            if (right-left+1>zero_count){
                if (nums[left]==0){
                    window_count--;
                }
                left++;
            }
            if (nums[right]==0){
                window_count++;
            }
            right++;
            ans = Math.min(ans,zero_count-window_count);
        }

        return ans;
    }

}
