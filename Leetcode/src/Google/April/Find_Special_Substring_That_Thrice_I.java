package Google.April;

public class Find_Special_Substring_That_Thrice_I {

    public boolean check(String s,String c){
        for (int i=1;i<c.length();i++){
            if (c.charAt(i)!=c.charAt(0)){
                return false;
            }
        }

        int count =0;

        for (int i=0;i<=s.length()-c.length();i++){
            if (s.substring(i,i+c.length()).equals(c)){
                count++;
            }
            if (count>=3){
                return true;
            }
        }

        return false;
    }

    public int maximumLength(String s) {
        int ans =-1;
        for (int i=0;i<s.length();i++){
            for (int j=i+1;j<=s.length();j++){
                String curr = s.substring(i,j);

                if (check(s,curr)){
                    ans = Math.max(ans,curr.length());
                }
            }
        }
        return ans;
    }


}
