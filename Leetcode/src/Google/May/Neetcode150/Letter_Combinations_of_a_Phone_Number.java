package Google.May.Neetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number {

    List<String> ans;
    HashMap<Character,String> map;

    public void generateStrings(StringBuilder curr,int index,String digits){

        if (index==digits.length()){
            ans.add(curr.toString());
            return;
        }

        char c = digits.charAt(index);
        for (char num:map.get(c).toCharArray()){
            curr.append(num);
            generateStrings(curr,index+1,digits);
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

        generateStrings(new StringBuilder(""),0,digits);
        return ans;
    }

}
