package Google.July;

public class Maximum_Ways_to_Partition_Array {

    public int changeElement(int[] nums,int k){

        int[] temp = nums.clone();
        int ans = calWays(nums,k);
        for (int i=0;i<temp.length;i++){
            int cache = temp[i];
            temp[i]=k;
            ans= Math.max(ans,calWays(temp,k));
            temp[i]=cache;
        }

        return ans;

    }

    public int calWays(int[] nums, int k){
        int n =nums.length;
        int[] prefix = new int[nums.length];
        int[] sufix = new int[n];
        prefix[0]=nums[0];
        sufix[n-1]=nums[n-1];
        for (int i=1;i<n;i++){
            prefix[i]=nums[i]+prefix[i-1];
        }

        for (int i=n-2;i>=0;i--){
            sufix[i]=sufix[i+1]+nums[i];
        }

        int ans =0;

        for (int i=1;i<nums.length;i++){
            if (prefix[i-1]==sufix[i]){
                ans++;
            }

        }

        return ans;
    }

    public int waysToPartition(int[] nums, int k) {
        return changeElement(nums,k);
    }

}
