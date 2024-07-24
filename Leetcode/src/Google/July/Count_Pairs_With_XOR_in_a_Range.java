package Google.July;

public class Count_Pairs_With_XOR_in_a_Range {

    public class TrieNode{

        TrieNode[] children = new TrieNode[2];
        int count;

    }

    class Trie{
        TrieNode root;

        public Trie(){
            root= new TrieNode();
        }

        public void insert(int num){
            TrieNode curr = root;
            for (int i=31;i>=0;i--){
                int bit = (num>>i) & 1;
                if (curr.children[bit]==null){
                    curr.children[bit]=new TrieNode();
                }
                curr = curr.children[bit];
                curr.count++;
            }
        }

        public int countLessThen(int num,int limit){
            TrieNode curr = root;
            int count =0;
            for (int i=31;i>=0;i--){
                if (curr==null){
                    break;
                }
                int numBit = (num>>i)&1;
                int limitBit = (limit>>i)&1;

                if (limitBit==1){
                    if (curr.children[numBit]!=null){
                        count+= curr.children[numBit].count;
                    }
                    curr=curr.children[1-numBit];
                }else {
                    curr=curr.children[numBit];
                }
            }
            if (curr!=null){
                count+=curr.count;
            }
            return  count;

        }
    }



    public int countPairs(int[] nums, int low, int high) {
        Trie node= new Trie();
        int ans =0;

        for (int i:nums){
            ans+= node.countLessThen(i,high)-node.countLessThen(i,low-1);
            node.insert(i);
        }
        return ans;
    }

}
