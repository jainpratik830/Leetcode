package Google.April;

import java.util.HashSet;

public class Find_Unique_Binary_String {
    public int converToInt(String s){
        int num = 0;
        int curr =1;
        for (int i=s.length()-1;i>=0;i--){
            num+= (int) (s.charAt(i)-'0')*curr;
            curr*=2;
        }

        return num;
    }


    public String findDifferentBinaryString(String[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (String s:nums){
            set.add(converToInt(s));
        }

        int max =(int) Math.pow(2,nums[0].length());
        for (int i=0;i<=max;i++){
            if (!set.contains(i)){
                String ans = Integer.toBinaryString(i);
                while (ans.length()<nums[0].length()){
                    ans = "0"+ans;
                }
               return ans;
            }
        }
        return "";
    }

}
