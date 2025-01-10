package Mission_2025.January.Daily_Problems;

import java.util.Arrays;

public class Shifting_Letters_II {

    public String shiftingLetters(String s, int[][] shifts) {
        int[] forward = new int[s.length()+1];
        int[] backward = new int[s.length()+1];

        for (int i=0;i<shifts.length;i++){
            if (shifts[i][2]==1){
                forward[shifts[i][0]]++;
                forward[shifts[i][1]+1]--;
            }else {
                backward[shifts[i][0]]++;
                backward[shifts[i][1]+1]--;
            }
        }
//        System.out.println(Arrays.toString(forward));
//        System.out.println(Arrays.toString(backward));
        char[] ans = s.toCharArray();
        int curr =0;
        for (int i=0;i<forward.length-1;i++){


            curr += (forward[i]-backward[i]+26)%26;

            int temp = (curr + (ans[i]-'a')+26)%26;
            ans[i]=(char) (temp+'a');


        }

        return new String(ans);
    }


}
