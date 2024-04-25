package Google.April;

import java.util.*;

public class Design_Search_Autocomplete_System {

    HashMap<String,Integer> map ;
    Trie root;
    Trie curr;
    StringBuilder sb;

    class AutocompleteSystem {

        public AutocompleteSystem(String[] sentences, int[] times) {
            map = new HashMap<>();
            root = new Trie();
            curr = root;
            sb =new StringBuilder();
            for (int i=0;i<sentences.length;i++){
                map.put(sentences[i],times[i]);
            }

        }

        public List<String> input(char c) {
            if (c=='#'){
                String s = sb.toString();
                map.put(s,map.getOrDefault(s,0)+1);
                root.add(s,0);
                sb = new StringBuilder();
                curr= root;
                return new ArrayList<>();
            }
            sb.append(c);
            curr = curr.getIndex(c);
            return curr.top3;
        }
    }

    class Trie {

        List<String> top3;
        Trie[] children;

        public Trie(){
            top3 = new ArrayList<>();
            children = new Trie[27];
        }

        public Trie getIndex(char c){
            int index = c==' ' ? 26: c-'a';
            if (children[index]==null){
                return new Trie();
            }
            return children[index];

        }

        public void add(String s,int index){

            if (!top3.contains(s)){
                top3.add(s);
            }

            Collections.sort(top3, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (map.get(o1)== map.get(o2)){
                        return o1.compareTo(o2);
                    }
                    return map.get(o2)-map.get(o1);
                }
            });

            if (top3.size()>3){
                top3.remove(top3.size()-1);
            }
            if (index==s.length()){
                return;
            }
            getIndex(s.charAt(index)).add(s,index+1);

        }

    }

}
