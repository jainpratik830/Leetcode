package Google.May.Others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Word_Break_II {

    List<String> ans;
    HashSet<String> set;

    public void generate(StringBuilder curr,StringBuilder currWord,int index,String s){
        if (index==s.length()){
            if (currWord.isEmpty()){

                ans.add(curr.toString().trim());
                // }else if (set.contains(currWord.toString())){
                //     curr.append(currWord);
                //     // ans.add(curr.toString());
            }
            return;
        }

        char c = s.charAt(index);
        currWord.append(c);
        if (set.contains(currWord.toString())){
            // set.remove(currWord.toString());
            String currOrg = curr.toString();
            // System.out.println("indexx="+index+" currWord="+currWord);
            // System.out.println(currWord);
            curr.append(" ");
            curr.append(currWord);

            generate(curr,new StringBuilder(),index+1,s);
            curr=new StringBuilder(currOrg);
            // set.add(currWord.toString());
        }
        generate(curr,currWord,index+1,s);


    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        set= new HashSet<>(wordDict);
        generate(new StringBuilder(),new StringBuilder(),0,s);
        return ans;
    }

}
