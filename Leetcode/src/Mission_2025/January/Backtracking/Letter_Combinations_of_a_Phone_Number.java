package Mission_2025.January.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number {

    List<String> ans;
    HashMap<Character,String> map;

    public void generateSets(String nums,int i,StringBuilder curr){
        if (i==nums.length()){
            ans.add(new String(curr));
            return;
        }

        for (char c:map.get(nums.charAt(i)).toCharArray()){
            curr.append(c);
            generateSets(nums,i+1,curr);
            curr.deleteCharAt(curr.length()-1);
        }

    }


    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if(digits.isEmpty()){
            return ans;
        }
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        generateSets(digits,0,new StringBuilder());
        return ans;
    }

}
