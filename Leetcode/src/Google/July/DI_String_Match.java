package Google.July;

public class DI_String_Match {

    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] ans = new int[n+1];
        int start =0;
        int end  = n;

        for (int i=0;i<n;i++){
            if (s.charAt(i)=='D'){
                ans[i]=end--;
            }else {
                ans[i]=start++;
            }
        }
        ans[n]=start;


        return ans;

    }

}
