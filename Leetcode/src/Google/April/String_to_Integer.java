package Google.April;

public class String_to_Integer {

    public int myAtoi(String s) {
        int ans = 0;
        s= s.trim();
        if (s==null || s.isEmpty()){
            return 0;
        }
        int i=0;
        int sign=1;
        if (s.charAt(0)=='-'){
            sign = -1;
            i++;
        }else if (s.charAt(0)=='+'){
            i++;
        }


        while (i<s.length()){
            if (Character.isDigit(s.charAt(i))){
                if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && (s.charAt(i)-'0') > Integer.MAX_VALUE % 10)) {
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }

                ans = ans*10 + (s.charAt(i)-'0');
                i++;
            }else{
                break;
            }
        }

        ans = ans*sign;



        return ans;
    }

}
