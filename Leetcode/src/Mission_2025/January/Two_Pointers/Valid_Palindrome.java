package Mission_2025.January.Two_Pointers;

public class Valid_Palindrome {


    public boolean isPalindrome(String s) {
        int i=0;
        int j =s.length()-1;
        while (i<=j){
            System.out.println(s.charAt(i));
            System.out.println(s.charAt(j));
            System.out.println(Character.isDigit(i));
            if ((s.charAt(i)>='a' && s.charAt(i)<='z') ||  (s.charAt(i)>='A' && s.charAt(i)<='Z') || ((s.charAt(i)>='0') && (s.charAt(i)<='9'))){

                if ((s.charAt(j)>='a' && s.charAt(j)<='z') ||  (s.charAt(j)>='A' && s.charAt(j)<='Z') || ((s.charAt(j)>='0') && (s.charAt(j)<='9'))){

                    if (( !Character.isDigit(s.charAt(i)) && !Character.isDigit(s.charAt(j))) &&  Character.toLowerCase(s.charAt(i)) ==  Character.toLowerCase(s.charAt(j)) ){
                        i++;
                        j--;
                    }else if (Character.isDigit(s.charAt(i)) && Character.isDigit(s.charAt(j)) && s.charAt(i)==s.charAt(j)){

                        i++;
                        j--;

                    }else {
                        return false;
                    }

                }else {
                    j--;
                }


            }else {
                i++;
            }

        }

        return true;

    }

}
