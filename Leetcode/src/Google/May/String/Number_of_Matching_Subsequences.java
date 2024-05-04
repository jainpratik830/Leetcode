package Google.May.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Number_of_Matching_Subsequences {

    class Node{

        int index;
        String word;

        public Node(String word,int index){
            this.word=word;
            this.index=index;
        }

    }

    public int numMatchingSubseq(String s, String[] words) {
        int ans =0;
        ArrayList<Node>[] map = new ArrayList[26];

        for (int i=0;i<26;i++){
            map[i]=new ArrayList<>();
        }
        for (String word:words){

            map[word.charAt(0)-'a'].add(new Node(word,0));

        }


        for (char c:s.toCharArray()){

            ArrayList<Node> old_list = map[c-'a'];
            map[c-'a']=new ArrayList<>();
            for (Node node:old_list){
                node.index++;
                if (node.index==node.word.length()){
                    ans++;
                    continue;
                }
                map[node.word.charAt(node.index)-'a'].add(node);
            }

            old_list.clear();


        }

        return ans;
    }

}
