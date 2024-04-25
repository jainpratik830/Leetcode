package Google.March;

import java.util.Stack;

public class Check_if_a_Parentheses_String_Can_Be_Valid {


    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (s.length()%2!=0){
            return false;
        }

        int balance = 0;

        for(int i=0; i<n; i++) {

            if(locked.charAt(i) == '0' || s.charAt(i) == '(') balance++;
            else{
                balance--;
            }
            if(balance < 0) return false;
        }

        balance = 0;

        for(int i=n-1;i>=0;i--){
            if(locked.charAt(i)=='0' || s.charAt(i)==')') balance++;
            else{
                balance--;
            }
            if(balance < 0) return false;
        }

        return true;
    }


    public boolean canBeValid2(String s, String locked) {
        if (s.length()%2!=0){
            return false;
        }
        Stack<Character[]> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                stack.push(new Character[]{'(',locked.charAt(i)});
            }else{

                if (!stack.isEmpty() && stack.peek()[0]=='('){
                    stack.pop();
                }else{
                    if (stack.isEmpty() && locked.charAt(i)=='0'){
                        stack.push(new Character[]{'(',locked.charAt(i)});
                    }else{
                        return false;
                    }
                }
            }
        }
        while (!stack.isEmpty() && stack.size()%2==0){
            if (stack.peek()[1]=='0'){
                stack.pop();
                stack.pop();
            }else{
                break;
            }
        }
        return stack.isEmpty();
    }



}
