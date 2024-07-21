package Google.July;

import java.util.*;

public class Sum_of_Prefix_Scores_of_Strings {

    public class Trie {


        HashMap<Character,Trie> map=new HashMap<>();
        int count=0;

    }

    public int count(String word,Trie root,int index){
        Trie temp = root;
        if(index==word.length()){
            return 0;
        }

        if (!temp.map.containsKey(word.charAt(index))){
            return 0;
        }

        return temp.map.get(word.charAt(index)).count+count(word,temp.map.get(word.charAt(index)),index+1);

    }

    public void add(String str,Trie trie){
        Trie temp = trie;

        for (int i=0;i<str.length();i++){

            if (!temp.map.containsKey(str.charAt(i))){
                temp.map.put(str.charAt(i),new Trie());
            }

            temp  = temp.map.get(str.charAt(i));
            temp.count+=1;

        }
    }

    public int[] sumPrefixScores(String[] words) {

        Trie root = new Trie();

        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i=0;i<words.length;i++){
            add(words[i],root);
        }
       int[] ans = new int[words.length];

        for (int i=0;i<words.length;i++){
            ans[i]=count(words[i],root,0);

        }
        return ans;
    }

}
