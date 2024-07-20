package Google.July;

import java.util.Arrays;
import java.util.HashMap;

public class Find_the_Sum_of_Subsequence_Powers {

    static int mod = 1000000007;
    HashMap<String,Integer> dp;

    public int recusrion(int curr_index,int prev,int i1,int i2,int k,int[] nums){

        if (k==0){
            return Math.abs(nums[i1]-nums[i2]);
        }

        if (curr_index== nums.length){
            return 0;
        }

        String key = curr_index+"_"+prev+"_"+i1+"_"+i2+"_"+k;
        if (dp.containsKey(key)){
            return dp.get(key);
        }

        int t1= i1;
        int t2= i2;

        if (prev!=-1 && (i1==-1 || i2==-1 ||  Math.abs(nums[i1]-nums[i2]) > Math.abs(nums[prev]-nums[curr_index]) )){
            t1= curr_index;
            t2=prev;
        }

        int take = recusrion(curr_index+1,curr_index,t1,t2,k-1,nums)%mod;
        int not_take = recusrion(curr_index+1,prev,i1,i2,k,nums)%mod;

        int result = (take + not_take) % mod;
        dp.put(key, result);
        return result;
    }

    public int sumOfPowers(int[] nums, int k) {
        dp = new HashMap<>();
        Arrays.sort(nums);

        return recusrion(0,-1,-1,-1,k,nums);
    }

}
