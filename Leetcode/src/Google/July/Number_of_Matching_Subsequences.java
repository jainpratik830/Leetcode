package Google.July;

import java.util.ArrayList;
import java.util.List;

public class Number_of_Matching_Subsequences {

    class Node {

        int index;
        String word;

        public Node(int index,String word){
            this.index=index;
            this.word=word;
        }

    }

    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;
        List<Node>[] map = new List[26];

        for (int i=0;i<26;i++){
            map[i]=new ArrayList<>();
        }

        for (String word:words){
            map[word.charAt(0)-'a'].add(new Node(0,word));
        }


        for (char c:s.toCharArray()){

            List<Node> curr = map[c-'a'];
            map[c-'a']=new ArrayList<>();
            for (Node n:curr){
                n.index++;
                if (n.index==n.word.length()){
                    result++;
                    continue;
                }
                map[n.word.charAt(n.index)-'a'].add(n);
            }

        }

        return result;
    }

}
