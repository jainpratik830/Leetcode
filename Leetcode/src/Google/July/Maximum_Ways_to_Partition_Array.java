package Google.July;

import java.util.HashMap;
import java.util.Map;

public class Maximum_Ways_to_Partition_Array {


    public int waysToPartition(int[] nums, int k){

        int ans =0;
        int n =nums.length;
        long[] prefix = new long[nums.length];
        long total= 0;
        long[] arr = new long[n];
        for (int i=0;i<n;i++){
            arr[i]=(long)nums[i];
            total+= arr[i];
        }
        prefix[0]=arr[0];
        for (int i=1;i<n;i++){
            prefix[i]=arr[i]+prefix[i-1];
        }

        for (int i=1;i<n;i++){
            if (prefix[i-1]==(prefix[n-1]-prefix[i-1])){
                ans++;
            }
        }

        Map<Long,Integer> leftMap = new HashMap<>();
        Map<Long,Integer> rightMap = new HashMap<>();
        long temp=0;
        for (int i=n-1;i>0;i--){
            temp+=arr[i];
            rightMap.put(temp,rightMap.getOrDefault(temp,0)+1);
        }

        temp=0;
        long newSum = total + k - arr[0];
        if (newSum%2==0 && rightMap.containsKey(newSum/2) ){
            ans= Math.max(ans,rightMap.get(newSum/2));
        }

        for (int i=1;i<n;i++){
            temp+= arr[i-1];
            leftMap.put(temp,leftMap.getOrDefault(temp,0)+1);
            if (rightMap.containsKey(total-temp)){
                int freq = rightMap.get(total-temp);
                if (freq==1){
                    rightMap.remove(total-temp);
                }else {
                    rightMap.put(total-temp,freq-1);
                }
            }
            newSum = total + k - arr[i];
            if (newSum%2==0 ){
                ans= Math.max(ans,rightMap.getOrDefault(newSum/2,0)+leftMap.getOrDefault(newSum/2,0));
            }

        }


        return ans;
    }

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

    public int waysToPartition2(int[] nums, int k) {
        return changeElement(nums,k);
    }

}
