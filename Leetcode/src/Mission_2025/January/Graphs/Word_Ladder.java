package Mission_2025.January.Graphs;

import java.util.*;

public class Word_Ladder {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord) || beginWord.equals(endWord)) {
                return 0;
            }
            Set<String> words = new HashSet<>(wordList);
            HashMap<String,Set<String>> map =new HashMap<>();
            int size = wordList.get(0).length();
            for (int i=0;i<wordList.size();i++){
                String currWord = wordList.get(i);
                for (int j=0;j<size;j++){

                    int index = j;
                    for (int c=0;c<26;c++){

                        char curr = (char) (c+'a');
                        if (curr==currWord.charAt(j)){
                            continue;
                        }
                        String word = currWord.substring(0,j)+curr+currWord.substring(j+1);
                        if (words.contains(word)){
                            map.putIfAbsent(currWord,new HashSet<>());
                            map.putIfAbsent(word,new HashSet<>());
                            map.get(currWord).add(word);
                            map.get(word).add(currWord);
                        }
                    }
                }
            }
            // System.out.println(map);
            Queue<String> queue= new LinkedList<>();
            Set<String> visited = new HashSet<>();
            for (int j=0;j<size;j++){

                int index = j;
                for (int c=0;c<26;c++){
                    char curr = (char) (c+'a');
                    if (curr==beginWord.charAt(j)){
                        continue;
                    }
                    String word = beginWord.substring(0,j)+curr+beginWord.substring(j+1);
                    if (words.contains(word) && !visited.contains(word)){
                        queue.add(word);
                        visited.add(word);
                    }
                }
            }

            int ans =1;
            while (!queue.isEmpty()){
                ans++;
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    String curr = queue.poll();
                    if (curr.equals(endWord)){
                        return ans;
                    }
                    for (String s:map.getOrDefault(curr,new HashSet<>())){

                        if (!visited.contains(s)){
                            visited.add(s);
                            queue.add(s);
                        }
                    }
                }

            }

            return 0;

        }


}
