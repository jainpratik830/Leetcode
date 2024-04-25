package Google.April;

import java.util.ArrayList;
import java.util.List;

public class Longest_Increasing_Subsequence {


    public int lengthOfLIS2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i=1;i<nums.length;i++){
            if (list.get(list.size()-1)<nums[i]){
                list.add(nums[i]);
            }else{
                int index = binarySearch(list,nums[i]);
                list.set(index,nums[i]);
            }

        }

        return list.size();
    }

    public int binarySearch(List<Integer> list,int target){
        int l = 0;
        int h= list.size();
        int answer = list.size();
        while (l<h){
            int mid = (l+h)/2;
            if (list.get(mid)<target){
                l=mid+1;
            }else{
                answer = mid;
                h = mid;
            }
        }

        return answer;

    }

    public int lengthOfLIS(int[] nums) {
        int ans =1;

        int[] dp =new int[nums.length];
        dp[0]=1;
        for (int i=1;i<nums.length;i++){
            dp[i]=1;
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j])
                    dp[i]   = Math.max(dp[j]+1,dp[i]);
            }
            ans= Math.max(ans,dp[i]);
        }

        return ans;
    }

}
