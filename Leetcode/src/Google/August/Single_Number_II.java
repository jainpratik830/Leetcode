package Google.August;

public class Single_Number_II {

    public int singleNumber(int[] nums) {
        int ans = 0;

        for (int i=0;i<32;i++){
            int curr = 1<<i;
            int count =0;
            for (int j=0;j<nums.length;j++){
                if ((curr & Math.abs(nums[j]))!=0){
                    count++;
                }
            }

            if (count%3!=0){
                ans+=curr;
            }
        }

        int coun = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==ans){
                coun++;
            }
        }
        return coun==1 ? ans : -ans;
    }

}
