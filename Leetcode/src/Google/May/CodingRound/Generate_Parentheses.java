package Google.May.CodingRound;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {


    List<String> ans;

    public void generate(int open,int closed,StringBuilder curr){
        if (open==0 && closed==0){
            ans.add(curr.toString());
        }

        if (open>0){
            curr.append("(");
            generate(open-1,closed,curr);
            curr.deleteCharAt(curr.length()-1);
        }

        if (open<closed && closed>0){

            curr.append(")");
            generate(open,closed-1,curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();

        generate(n,n,new StringBuilder());
        return ans;
    }

}
