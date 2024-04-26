package Google.April;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Group_Anagrams {

    public boolean isAnagram(int[] count,int[] count_new){

        for (int i=0;i<26;i++){
            if (count[i]!=count_new[i]){
                return false;
            }
        }
        return true;

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] done = new boolean[strs.length];

        HashMap<Integer,int[]> map = new HashMap<>();
        for (int i=0;i<strs.length;i++){
            int[] count=new int[26];
            for (char c:strs[i].toCharArray()){
                count[c-'a']++;
            }
            map.put(i,count);
        }

        for (int i=0;i<strs.length;i++){
            if (done[i]){
                continue;
            }else {
                String cur = strs[i];
                List<String> list = new ArrayList<>();
                list.add(cur);
                int[] count=map.get(i);
                for (int j=i+1;j<strs.length;j++){
                    if (isAnagram(count,map.get(j))){
                        list.add(strs[j]);
                        done[j]=true;
                    }
                }
                ans.add(list);
            }
        }

        return ans;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for (int i=0;i<strs.length;i++){
            int[] count=new int[26];
            for (char c:strs[i].toCharArray()){
                count[c-'a']++;
            }
            StringBuilder sb =new StringBuilder();
            for (int j:count){
                sb.append("#");
                sb.append(j);
            }
            map.putIfAbsent(sb.toString(),new ArrayList<>());
            map.get(sb.toString()).add(strs[i]);
        }



        return new ArrayList<>(map.values());
    }

}
