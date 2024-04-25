package Google.April;

public class Minimum_Remove_to_Make_Valid_Parentheses {

    public String minRemoveToMakeValid(String s) {
        int count = 0;
        String ans = "";
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                ans += s.charAt(i);
                count++;
            }
            else if (s.charAt(i)==')'){
                count--;
                if (count>=0){
                    ans += s.charAt(i);
                }else {
                    count=0;
                }
            }else{
                ans += s.charAt(i);
            }
        }
        // System.out.println(ans);
        count=0;
        String newAns = "";
        for (int i=ans.length()-1;i>=0;i--){
            if (ans.charAt(i)==')'){
                newAns = ans.charAt(i)+newAns;
                count++;
            }
            else if (ans.charAt(i)=='('){
                count--;
                if (count>=0){
                    newAns = ans.charAt(i)+newAns;
                }else {
                    count=0;
                }
            }else{
                newAns = ans.charAt(i)+newAns;
            }
        }
        return newAns;
    }

}
