package Google.April;

import java.util.HashMap;

public class Longest_Absolute_File_Path {


    public int lengthLongestPath(String input) {
        int ans =0;
        String[] lines = input.split("\n");
        HashMap<Integer,Integer> path = new HashMap<>();

        for (String line :lines){
            String name = line.replaceAll("\t","");
            int depth = line.length()-name.length();

            boolean isFile = name.contains(".");

            if (isFile){
                ans = Math.max(ans,path.getOrDefault(depth,0)+name.length());
            }else{
                path.put(depth+1,path.getOrDefault(depth,0)+name.length()+1);
            }
            System.out.println(path);
        }
        return ans;
    }

}
