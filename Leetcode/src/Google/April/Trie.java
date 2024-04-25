package Google.April;




public class Trie {

    public class TrieNode {

        TrieNode[] root;
        int n=26;
        boolean isEnd;

        public TrieNode(){
            root= new TrieNode[n];
        }

        public boolean containsKey(char ch){
            return root[ch-'a']!=null;
        }

        public TrieNode get(char ch){
            return root[ch-'a'];
        }

        public void put(char ch,TrieNode node){
            root[ch-'a']=node;
        }

        public void setEnd(){
            isEnd = true;
        }

        public boolean isEnd(){
            return isEnd;
        }

    }

    TrieNode node;

    public Trie() {
        node = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = node;
        for (int i=0;i<word.length();i++){
            char currChar = word.charAt(i);
            if (!curr.containsKey(currChar)){
                curr.put(currChar,new TrieNode());
            }
            curr = curr.get(currChar);
        }

        curr.setEnd();
    }

    public boolean search(String word) {
        TrieNode curr = node;
        for (int i=0;i<word.length();i++){
            char currChar = word.charAt(i);
            if (!curr.containsKey(currChar)){
                return false;
            }
            curr = curr.get(currChar);
        }
        return curr.isEnd();
    }



    public boolean startsWith(String prefix) {
        TrieNode curr = node;
        for (int i=0;i<prefix.length();i++){
            char currChar = prefix.charAt(i);
            if (!curr.containsKey(currChar)){
                return false;
            }
            curr = curr.get(currChar);
        }
        return true;

    }

}
