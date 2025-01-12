package Mission_2025.January.Stack;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {

    int size;
    List<String> ans;
    public void generate(int openCount,int n,StringBuilder curr){
        if (openCount>size || n<0 || openCount<0 || curr.length()>2*size){
            return;
        }

        if (n==0 && openCount==0){
            ans.add(curr.toString());
            return;
        }

        generate(openCount + 1, n - 1, new StringBuilder(curr).append('('));
        generate(openCount - 1, n - 1, new StringBuilder(curr).append(')'));

    }

    public List<String> generateParenthesis(int n) {
        size=n;
        ans =new ArrayList<>();
        generate(0,2*n,new StringBuilder());
        return ans;
    }

}
