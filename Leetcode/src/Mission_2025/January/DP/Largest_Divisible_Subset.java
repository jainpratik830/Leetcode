package Mission_2025.January.DP;

import java.util.*;

public class Largest_Divisible_Subset {

    List<Integer> ans;
    List<Integer> resp;

    public void helper(int[] nums,int i){

        if (i==nums.length){
            if (ans.size()> resp.size()) {
                resp = new ArrayList<>(ans);
            }
            return;
        }


        if (ans.size()==0 ||  (ans.size()>0 && (nums[i]%ans.get(ans.size()-1)==0))){
            ans.add(nums[i]);
            helper(nums,i+1);
            ans.remove(ans.size()-1);

            // }else{

        }
        helper(nums,i+1);


    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        ans=  new ArrayList<>();
        resp = new ArrayList<>();
        helper(nums,0);
        return resp;
    }

    public List<Integer> largestDivisibleSubset2(int[] nums) {
        Arrays.sort(nums);
        List<Integer> resp = new ArrayList<>();
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int maxSize =1;
        int maxIndex =0;
        for (int i=1;i<nums.length;i++){
            for (int j=0;j<i;j++){

                if (nums[i]%nums[j]==0){
                    dp[i]= Math.max(dp[i],dp[j]+1);
                }
                if (dp[i]>maxSize){
                    maxIndex=i;
                    maxSize=dp[i];
                }
            }
        }

        for (int i=maxIndex;i>=0;i--){
            if (nums[maxIndex]%nums[i]==0 && dp[i]==maxSize){
                resp.add(nums[i]);
                maxIndex=i;
                maxSize--;
            }
        }
//        Collections.sort(resp);
        return resp;
    }

}
