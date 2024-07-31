package Google.July;

public class Minimum_Deletions_to_Make_String_Balanced {

    public int minimumDeletions(String s) {
        int a_count=0;
        int b_count=0;


        for (char i:s.toCharArray()){
            if (i=='a'){
                a_count++;
            }
        }
        int ans =s.length();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='a'){
                a_count--;
            }
            // }else {
            // a_count--;
            ans= Math.min(ans,a_count+b_count);
            // }
            if (s.charAt(i)=='b'){
                b_count++;
            }
        }

        return ans;
    }

}
