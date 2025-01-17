package Mission_2025.January.Trie;

public class Implement_Trie {


    class Trie {

        class TrieNode {

            TrieNode[] root;
            int n;
            boolean isEnd;

            public TrieNode(){
                n =26;

                root=  new TrieNode[n];
            }

        }

        TrieNode root;

        public Trie() {
            root=new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr=  root;
            for (char c:word.toCharArray()){
                if (curr.root[c-'a']==null){
                    curr.root[c-'a']= new TrieNode();
                }
                curr= curr.root[c-'a'];
            }
            curr.isEnd=true;
        }

        public boolean search(String word) {
            TrieNode curr=  root;
            for (char c:word.toCharArray()){
                if (curr.root[c-'a']==null){
                    return false;
                }
                curr= curr.root[c-'a'];
            }
            return curr.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode curr=  root;
            for (char c:prefix.toCharArray()){
                if (curr.root[c-'a']==null){
                    return false;
                }
                curr= curr.root[c-'a'];
            }

            return curr!=null;
        }
    }


}
