package Mission_2025.January.Daily_Problems;

public class Check_if_a_Parentheses_String_Can_Be_Valid {

    public boolean canBeValid(String s, String locked) {
        if (s.length()%2!=0){
            return false;
        }

        int balance  =0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='(' || locked.charAt(i)=='0'){
                balance++;
            }else if (s.charAt(i)==')'){
                balance--;
            }
            if (balance<0){
                return false;
            }

        }
        System.out.println(balance);
        balance  =0;
        for (int i=s.length()-1;i>=0;i--){
            if (s.charAt(i)==')' || locked.charAt(i)=='0'){
                balance++;
            }else if (s.charAt(i)=='('){
                balance--;
            }
            if (balance<0){
                return false;
            }
        }

        return true;
    }

}
