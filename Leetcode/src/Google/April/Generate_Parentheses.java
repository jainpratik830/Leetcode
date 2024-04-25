package Google.April;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Generate_Parentheses {

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        int i=0;

        while (i<s.length()){
            if (s.charAt(i)=='('){
                stack.push('(');
            }else {
                if (stack.isEmpty()){
                    return false;
                }else {
                    stack.pop();
                }
            }
            i++;
        }

        return stack.isEmpty();
    }

    public void generate(int open,int close,String curr,List<String> ans){

        if (open==0 && close==0){
            if (isValid(curr.toString())){
                ans.add(curr.toString());
            }

            return;
        }

        if (open>0){
            generate(open-1,close,curr+"(",ans);
        }

        if (close>0){
            generate(open,close-1,curr+")",ans);
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n,n,"",ans);
        return ans;
    }

}
