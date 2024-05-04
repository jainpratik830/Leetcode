package Google.May.Array;

import java.util.*;

public class Verbal_Arithmetic_Puzzle {

    String[] words;
    String result;
    Set<Character> first_letter_of_all_words_set;
    public boolean check(HashMap<Character,Integer> map){

        long left_count = 0;
        for (String word:words){
            long curr = 0;
            for (char c:word.toCharArray()){
                curr = curr*10+map.get(c);
            }
            left_count+= curr;
        }
        long right_count = 0;
        long curr = 0;
        for (char c:result.toCharArray()){
            curr = curr*10+map.get(c);

        }
        right_count+=curr;
        return left_count==right_count;

    }
    public boolean backTrack(List<Character> list, boolean[] avail, int curr, HashMap<Character,Integer> map){


        if (curr>=list.size()){
            return check(map);
        }

        char curr_char = list.get(curr);
        boolean ans = false;
        for (int i=0;i<=9;i++){

            if (!avail[i] ){
                continue;
            }

            if ( i==0 && first_letter_of_all_words_set.contains(curr_char)) {
                continue;
            }


            map.put(curr_char,i);
            avail[i]=false;
            if (backTrack(list,avail,curr+1,map)){
                return true;
            }
            avail[i]=true;
            map.put(curr_char,0);



        }

        return false;

    }

    public boolean isSolvable(String[] words, String result) {
        this.words= words;
        this.result= result;
        first_letter_of_all_words_set = new HashSet<>();
        HashSet<Character> set = new HashSet<>();
        boolean first =true;
        for (String word:words){

            for (char c:word.toCharArray()){
                if(first){
                    first_letter_of_all_words_set.add(c);
                    first=false;
                }
                set.add(c);
            }
        }
        first =true;
        for (char c:result.toCharArray()){

            if(first){
                first_letter_of_all_words_set.add(c);
                first=false;
            }
            set.add(c);
        }
        List<Character> list = new ArrayList<>(set);
        HashSet<Integer> avail = new HashSet<>();
        for (int i=0;i<=9;i++){
            avail.add(i);
        }
        return backTrack(list,new boolean[10],0,new HashMap<>());
    }

}
