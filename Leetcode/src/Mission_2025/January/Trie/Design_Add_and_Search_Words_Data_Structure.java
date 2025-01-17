package Mission_2025.January.Trie;

public class Design_Add_and_Search_Words_Data_Structure {


    class WordDictionary {

        class TrieNode {

            TrieNode[] root;
            int n;
            boolean isEnd;

            public TrieNode() {
                n = 26;

                root = new TrieNode[n];
            }

        }

        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.root[c - 'a'] == null) {
                    curr.root[c - 'a'] = new TrieNode();
                }
                curr = curr.root[c - 'a'];
            }
            curr.isEnd = true;
        }

        public boolean searchWord(String word, TrieNode root) {
            System.out.println("Current word="+word);
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c == '.') {
                    boolean found = false;
                    for (TrieNode child : curr.root) {

                        if (child != null) {
                            System.out.println(child.isEnd);
                            found = found ||  this.searchWord(word.substring(i + 1), child);
                        }
                    }
                    return found;
                } else {
                    if (curr.root[c - 'a'] == null) {
                        return false;
                    }

                    curr = curr.root[c - 'a'];
                }
            }
            return curr.isEnd;
        }

        public boolean search(String word) {
            return searchWord(word, root);
        }
    }
    
}
