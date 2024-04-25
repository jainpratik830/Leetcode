package Google.April;

public class Make_The_String_Great {

    public String makeGood(String s) {
        int i=0;
        while (i<s.length()-1){
            int a1 = s.charAt(i + 1) - 'A';
            int a2 = s.charAt(i + 1) - 'a';
            int b1 = s.charAt(i) - 'A';
            int b2 = s.charAt(i) - 'a';
            if (a1==b2 || a2==b1){
                s =s.substring(0,i)+s.substring(i+2);
                i--;
                if(i<0){
                    i=0;
                }
            }else{
                i++;
            }

        }
        return s;
    }

}
