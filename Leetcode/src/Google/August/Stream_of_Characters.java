package Google.August;

import java.util.ArrayList;
import java.util.List;

public class Stream_of_Characters {

    public static class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    private TrieNode root;
    StringBuilder queries;

    public Stream_of_Characters(String[] words) {
        root = new TrieNode();
        for(String word: words) {
            insertWord(new StringBuilder(word).reverse().toString());
        }
        queries =new StringBuilder();
    }

    private void insertWord(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            int pos = (int) word.charAt(i) - 'a';
            if(curr.children[pos] == null) curr.children[pos] = new TrieNode();
            curr = curr.children[pos];
        }
        curr.isEnd = true;
    }

    public boolean query(char letter) {
        TrieNode curr = root;
        queries.append(letter);


        for (int i=queries.length()-1;i>=0 && curr!=null;i--){
            int currChar = queries.charAt(i)-'a';
            TrieNode node = curr.children[currChar];
            if (node!=null && node.isEnd){
                return true;
            }
            curr= node;
        }
        return false;

    }

}
