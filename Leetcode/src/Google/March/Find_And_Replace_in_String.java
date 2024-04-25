package Google.March;

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
                if (o1[0]==o2[0]){
                    return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
                }
                return Integer.parseInt(o2[0])-Integer.parseInt(o1[0]);
            }
        });

        for (String[] cur:toChange){
            System.out.println(Arrays.toString(cur));
            if (s.substring(Integer.parseInt(cur[0])).startsWith(cur[1])){
                ans = ans.substring(0,Integer.parseInt(cur[0]))+cur[2]+ans.substring(Integer.parseInt(cur[0])+cur[1].length());
            }
        }
        return ans;
    }

}
