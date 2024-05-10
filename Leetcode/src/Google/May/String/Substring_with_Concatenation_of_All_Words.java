package Google.May.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Substring_with_Concatenation_of_All_Words {


//    static HashSet<String> concat;
//
//    public static void  generate(String[] words,HashSet<Integer> set,StringBuilder curr){
//
//        if (set.size()==words.length){
//            concat.add(curr.toString());
//            return;
//        }
//
//        for (int i=0;i<words.length;i++){
//            if (set.contains(i)){
//                continue;
//            }
//
//
//            curr.append(words[i]);
//            set.add(i);
//            generate(words,set,curr);
//            set.remove(i);
//            curr.delete(curr.length()-words[i].length(),curr.length());
//        }
//
//
//    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
//        concat= new HashSet<>();
//        generate(words,new HashSet<>(),new StringBuilder());
        int length = words.length*words[0].length();
        HashMap<String,Integer> map = new HashMap<>();

        for (String a:words){
            map.put(a,map.getOrDefault(a,0)+1);
        }



        for (int i=0;i<s.length()-length+1;i++){
            HashMap<String, Integer> remaining = new HashMap<>(map);
            int wordsUsed = 0;
//            System.out.println(s.substring(i,i+length));
            for (int j=i;j<i+length;j=j+words[0].length()){
                String curr = s.substring(j,j+words[0].length());
                if (remaining.getOrDefault(curr,0)!=0){
                    remaining.put(curr,remaining.get(curr)-1);
                    wordsUsed++;
                }else{
                    break;
                }
            }
            if (wordsUsed==words.length){
                ans.add(i);
            }
        }
        // System.out.println(ans);



        return ans;

    }

    public static void main(String[] args){
        String[] words = {"abc","def","ghi"};
        String s = "abcdefghi";
        findSubstring(s,words);
    }

}
