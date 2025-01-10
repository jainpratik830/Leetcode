package Google.August;

import java.util.Arrays;

public class Number_of_Substrings_Containing_All_Three {


    public int numberOfSubstrings(String s) {
        int[] index = new int[3];
        Arrays.fill(index,-1);
        int ans =0;
        for (int i=0;i<s.length();i++){

            index[s.charAt(i)-'a']=i;
            int curr = Math.min(index[0],Math.min(index[1],index[2]));
            if (curr!=-1){
                ans+= curr+1;
            }

        }

        return ans;
    }


}
