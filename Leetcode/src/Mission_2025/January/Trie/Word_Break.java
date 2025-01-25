package Mission_2025.January.Trie;

import java.util.List;

public class Word_Break {

    public class Trie{

        boolean isEnd;
        Trie[] children;

        public Trie(){
            children = new Trie[26];
            isEnd =false;
        }

        public void insert(String word,int index){
            if (index==word.length()){
                System.out.println("Inserted word="+word);
                isEnd=true;
                return;
            }
            if (children[word.charAt(index)-'a']==null){
                children[word.charAt(index)-'a']=new Trie();
            }
            children[word.charAt(index)-'a'].insert(word,index+1);

        }

        public boolean search(String word,int index,int end){


            if (index==end){
                return isEnd;
            }
            if (children[word.charAt(index)-'a']==null){
                return false;
            }
            return children[word.charAt(index)-'a'].search(word,index+1,end);
        }

    }

    Trie root;
    Boolean[] memo;

    public boolean searchWord(String s,int start){
        System.out.println("curr word="+s.substring(start));
        if (start==s.length()){
            return true;
        }
        if (memo[start]!=null){
            return memo[start];
        }

        boolean found =false;
        for (int i=start+1;i<=s.length();i++){
            if (root.search(s,start,i) && searchWord(s,i)){
                return memo[start] =  true;
            }
        }

        return memo[start]=false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        root = new Trie();
        for (String word:wordDict){
            root.insert(word,0);
        }
        memo = new Boolean[s.length()];
        return searchWord(s,0);
    }

    /*
    Analyzing the time complexity of this optimized solution involves examining the operations performed in the key parts of the algorithm. Let’s break it down step by step:

---

### **Key Components**
1. **Trie Construction**
   - For each word in `wordDict`, you insert it into the Trie.
   - Each insertion takes \(O(L)\), where \(L\) is the average length of a word.
   - If there are \(N\) words in the dictionary, the total time for constructing the Trie is:
     \[
     O(N \cdot L)
     \]

2. **Recursive Search (`searchWord`)**
   - For each starting index in the string `s`, you try all possible ending indices to check for valid words in the Trie.
   - The `search` method for the Trie runs in \(O(L)\), where \(L\) is the maximum length of a word.

3. **Memoization**
   - Each starting index is processed only once, as results are cached in the `memo` array.
   - There are \(M\) possible starting indices, where \(M\) is the length of `s`.

4. **Overall Recursive Work**
   - At each starting index, you check up to \(M - \text{start}\) substrings (the length of the remaining string).
   - For each substring, you perform a Trie search in \(O(L)\).
   - In the worst case, this gives:
     \[
     O(M \cdot L)
     \]

---

### **Total Time Complexity**

The total time complexity is the sum of the Trie construction and the recursive search:
\[
O(N \cdot L + M \cdot L)
\]
- \(O(N \cdot L)\): Time to build the Trie.
- \(O(M \cdot L)\): Time to process the string `s`.

---

### **Space Complexity**

1. **Trie Storage**
   - Each word contributes \(O(L)\) space, and there are \(N\) words.
   - Total space for the Trie is:
     \[
     O(N \cdot L)
     \]

2. **Memoization**
   - The `memo` array stores \(M\) boolean values.
   - Space required is:
     \[
     O(M)
     \]

3. **Recursive Stack**
   - The recursion depth can go up to \(M\) (the length of `s`).
   - Space required is:
     \[
     O(M)
     \]

Total space complexity:
\[
O(N \cdot L + M)
\]

---

### **Optimized Analysis**

In practical scenarios:
- \(L\) (the average word length) is much smaller than \(M\) (length of `s`).
- Therefore, the time complexity can be approximated as \(O(M \cdot L)\) for larger inputs.
     */
}
