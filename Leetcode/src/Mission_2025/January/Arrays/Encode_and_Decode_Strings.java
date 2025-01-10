package Mission_2025.January.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Encode_and_Decode_Strings {

    public String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();

        for (String s:strs){
            ans.append(s.length());
            ans.append('#');
            ans.append(s);
        }

        return ans.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        StringBuilder curr = new StringBuilder();
        int i=0;

        while (i<str.length()){
            if (str.charAt(i)=='#'){
                ans.add(str.substring(i+1,Integer.parseInt(curr.toString())+i+1));
                i += Integer.parseInt(curr.toString())+1;
                curr = new StringBuilder();
            }else {
                curr.append(str.charAt(i));
                i++;
            }
        }

        return ans;

    }

}
