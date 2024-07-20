package Google.July;

import java.util.Arrays;
import java.util.Comparator;

public class Find_And_Replace_in_String {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        String ans = s;
        String[][] toChange = new String[indices.length][3];
        for (int i=0;i<indices.length;i++){
            toChange[i] = new String[]{Integer.toString(indices[i]), sources[i], targets[i]};
        }

        Arrays.sort(toChange, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.compare(Integer.parseInt(o2[0]),Integer.parseInt(o1[0]));
            }
        });
        int org_length = s.length();
        for (String[] curr:toChange){
            int index = Integer.parseInt(curr[0]);
            int length = curr[1].length();

            if (s.substring(index,Math.min(index+length,org_length)).equals(curr[1])){
                ans =ans.substring(0,index)+curr[2]+ans.substring(index+length);
            }

        }

        return ans;

    }

}
