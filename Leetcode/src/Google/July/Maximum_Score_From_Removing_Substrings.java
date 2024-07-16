package Google.July;

import java.util.ArrayList;
import java.util.Stack;

public class Maximum_Score_From_Removing_Substrings {

    int ans =0;

    public String removeAb(String s,int score){
        StringBuilder stringBuilder= new StringBuilder();
        Stack<Character> stack= new Stack<Character>();
        int i=0;
        while (i<s.length()){
            if (!stack.isEmpty() && stack.peek()=='a' && s.charAt(i)=='b'){
                stack.pop();
                i++;
                ans+=score;
            }else {
                stack.push(s.charAt(i));
                i++;
            }
        }

        for (Character c:stack){
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

    public String removeBa(String s,int score){
        StringBuilder stringBuilder= new StringBuilder();
        Stack<Character> stack= new Stack<Character>();
        int i=0;
        while (i<s.length()){
            if (!stack.isEmpty() && stack.peek()=='b' && s.charAt(i)=='a'){
                stack.pop();
                i++;
                ans+=score;
            }else {
                stack.push(s.charAt(i));
                i++;
            }
        }

        for (Character c:stack){
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

    public int maximumGain(String s, int x, int y) {
        if (x>y){
            String newS =removeAb(s,x);
            removeBa(newS,y);
        }else {
            String newS =removeBa(s,y);
            removeAb(newS,x);
        }

        return ans;
    }

}
