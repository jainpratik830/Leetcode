package Google.April;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Arithmetic_Subarrays {


    public boolean check(List<Integer> list){
        int diff = list.get(1)-list.get(0);
        boolean isArt = true;
        for (int j=2;j<list.size();j++){
            if (list.get(j)-list.get(j-1)!=diff){
                isArt = false;
                break;
            }
        }
        return isArt;
    }

    public boolean check2(List<Integer> list){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int num:list){
            set.add(num);
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        int n  = list.size();
        if ((max-min)%(n-1)!=0){
            return false;
        }

        int diff= (max-min)/(n-1);
        int curr = min +diff;
        while (curr<max){
            if (!set.contains(curr)){
                return false;
            }
            curr+=diff;
        }
        return true;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();

        for(int i=0;i<l.length;i++){
            if (r[i]-l[i]<1){
                ans.add(false);
                continue;
            }
            List<Integer> list =new ArrayList<>();
            for (int j=l[i];j<=r[i];j++){
                list.add(nums[j]);
            }
            Collections.sort(list);
            // System.out.println("for l="+l[i]+" r="+r[i]);
            // System.out.println(list);

            ans.add(check(list));

        }
        return ans;
    }

}
