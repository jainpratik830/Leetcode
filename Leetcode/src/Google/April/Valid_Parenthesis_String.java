package Google.April;

public class Valid_Parenthesis_String {

    public boolean checkValidString(String s) {

        int left = 0;
        for (char c:s.toCharArray()){
            // System.out.println(left);
            if (c=='(' || c=='*'){
                left++;
            }else {
                left--;
                if (left<0){
                    return false;
                }
            }
        }

        int right = 0;
        StringBuilder input1 = new StringBuilder();
        input1.append(s);
        input1.reverse();
        // System.out.println(input1);
        for (char c:input1.toString().toCharArray()){
            // System.out.println(right);
            if (c==')' || c=='*'){
                right++;
            }else {
                right--;
                if (right<0){
                    return false;
                }
            }
        }

        return true;


    }


}
