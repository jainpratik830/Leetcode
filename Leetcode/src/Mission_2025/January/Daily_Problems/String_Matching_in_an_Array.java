package Mission_2025.January.Daily_Problems;

import java.util.*;

public class String_Matching_in_an_Array {

    public class TrieNode {

        int frequency;
        TrieNode[] map;

        TrieNode(){
            frequency=0;
            map = new TrieNode[26];
        }

    }

    public void insertWord(String word,TrieNode root){
        TrieNode curr = root;
        for (char c:word.toCharArray()){

            if (curr.map[c-'a']==null){
                curr.map[c-'a']=new TrieNode();
            }
            curr= curr.map[c-'a'];
            curr.frequency++;
        }
    }


    public boolean isMatching(String word,TrieNode root){
        TrieNode curr = root;
        for (char c:word.toCharArray()){
            curr= curr.map[c-'a'];
        }

        return curr.frequency>1;
    }


    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (int i=0;i<words.length;i++){
            String curr = words[i];
            for (int j=0;j<curr.length();j++){
                insertWord(curr.substring(j),root);
            }
        }

        for (int i=0;i<words.length;i++) {
            String curr = words[i];
            if (isMatching(curr,root)){
                ans.add(words[i]);
            }
        }
        return ans;

    }


    public List<String> stringMatching2(String[] words) {
        List<String> ans = new ArrayList<>();

        for (int i=0;i<words.length;i++){
            String curr = words[i];
            for (int j=0;j<words.length;j++){
                if (i!=j && words[j].indexOf(curr)!=-1){
                    ans.add(curr);
                    break;
                }
            }
        }
        return ans;

    }

}
