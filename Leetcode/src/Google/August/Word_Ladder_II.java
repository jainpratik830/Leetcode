package Google.August;

import java.util.*;

public class Word_Ladder_II {

    public boolean isValid(String a,String b){
        int diff =0;
        for (int i=0;i<a.length();i++){
            if (a.charAt(i)!=b.charAt(i)){
                diff++;
            }
        }

        return diff==1;

    }

    public List<String> getFriends(String word,List<String> wordList,int index){
        List<String> ans = new ArrayList<>();
        for(int i=index;i< wordList.size();i++){
            if (isValid(word,wordList.get(i))){
                ans.add(wordList.get(i));
            }
        }
        return ans;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        wordList.add(0,beginWord);
        HashMap<String,List<String>> map = new HashMap<>();
        Set<String> seen = new HashSet<>();
        for(int i=0;i< wordList.size();i++){
            map.put(wordList.get(i),getFriends(wordList.get(i),wordList,0));
        }
        System.out.println(map);
        Queue<List<String>> queue= new LinkedList<>();
        List<String> curr  = new ArrayList<>();
        curr.add(beginWord);
        queue.add(curr);
        while (!queue.isEmpty()){

            List<String> path = queue.poll();
            String last = path.get(path.size()-1);
            seen.add(last);
            if (last.equals(endWord)){
                if (ans.size()==0 || ans.get(ans.size()-1).size()>= path.size()){
                    ans.add(path);
                }
            }
            List<String> friend = map.get(last);

            for (String s:friend){
                if (!seen.contains(s)){
                    List<String> newList = new ArrayList<>(path);
                    newList.add(s);
                    queue.add(newList);
                }
            }

        }

        return ans;

    }

}

