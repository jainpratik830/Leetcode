package Google.May.Others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class The_Number_of_Beautiful_Subsets {

    public int beautifulSubsets(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);

        return countSubsets(nums,k,map,0)-1;
    }


    public int countSubsets(int[] nums, int k, Map<Integer,Integer> map,int i){
        if (i==nums.length){
            return 1;
        }

        int totalCount = countSubsets(nums,k,map,i+1);

        if (!map.containsKey(nums[i]-k)){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            totalCount+= countSubsets(nums,k,map,i+1);
            map.put(nums[i],map.get(nums[i])-1);

            if (map.get(nums[i])==0){
                map.remove(nums[i]);
            }
        }

        return totalCount;
    }

    public int generateBeautifulSubsets(int[] nums,int k,int index,int curr){

        if (index==nums.length){
            return curr> 0 ? 1: 0;
        }

        boolean isBeautiful =true;
        for (int j=0;j<index && isBeautiful;j++){
            isBeautiful = (( ((1<< j) & curr) ==0 ) || Math.abs(nums[index]-nums[j]) !=k);
        }

        int without =  generateBeautifulSubsets(nums,k,index+1,curr);
        int with = 0;
        if (isBeautiful){
            with = generateBeautifulSubsets(nums,k,index+1,(curr+(1<<index)));
        }

        return with+without;

    }

}
