package Google.May.Neetcode150;

public class Valid_Palindrome {

    public boolean isValid(Character c){
        if ((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0') && (c<='9')){
            return true;
        }

        return false;
    }

    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        s=s.toLowerCase();
        while (i<j){
            if (!isValid(s.charAt(i))){
                i++;
                continue;
            }
            if (!isValid(s.charAt(j))){
                j--;
                continue;
            }
            if (s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;


    }

}
