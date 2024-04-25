package Google.April;

public class Repeated_Substring_Pattern {

    public boolean repeatedSubstringPattern(String s) {
        int n  = s.length();
        for (int i=1;i<=n/2;i++){
            String curr= s.substring(0,i);
            if (checkCurr(s,curr)){
                return true;
            }
        }


        return false;

    }

    public boolean checkCurr(String s,String curr){
        int l = curr.length();
        int i=0;
        while (i<s.length()&& i+l<=s.length()){

            if (s.substring(i,i+l).equals(curr)){
                i+=l;
            }else {
                return false;
            }
        }
        return i==s.length();
    }

}
