package Mission_2025.January.Graphs;

import java.util.*;

public class Alien_Dictionary {

    public String foreignDictionary(String[] words) {
        HashMap<Character, Set<Character>> map = new HashMap<>();
        HashMap<Character,Integer> inDegree = new HashMap<>();
        Set<Character> characterSet = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }
        for (int i=1;i<words.length;i++){
            int l=0,r=0;
            if (words[i-1].equals(words[i])){
                continue;
            }
            while (l<words[i-1].length() && r<words[i].length() && words[i-1].charAt(l)==words[i].charAt(r)){
                characterSet.add(words[i-1].charAt(l));
                l++;
                r++;
            }

            if (l<words[i-1].length() && r==words[i].length()){
                return "";
            }
            if(l==words[i-1].length()){
                continue;
            }
            // map.putIfAbsent(words[i].charAt(r),new ArrayList<>());
            // map.get(words[i].charAt(r)).add(words[i-1].charAt(l));
            if (!map.get(words[i-1].charAt(l)).contains(words[i].charAt(r))) {
                map.putIfAbsent(words[i-1].charAt(l),new HashSet<>());
                map.get(words[i-1].charAt(l)).add(words[i].charAt(r));
                characterSet.add(words[i-1].charAt(l));
                characterSet.add(words[i].charAt(r));
                inDegree.put(words[i].charAt(r),inDegree.getOrDefault(words[i].charAt(r),0)+1);
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (Character c:inDegree.keySet()){
            if (inDegree.get(c)==0){
                queue.add(c);
            }
        }
        System.out.println(inDegree);
        System.out.println(map);
        System.out.println(characterSet.toString());
        System.out.println(queue);
        StringBuilder ans = new StringBuilder();
        while (!queue.isEmpty()){
            Character curr =queue.poll();
            ans.append(curr);
            for (Character c:map.getOrDefault(curr,new HashSet<>())){
                inDegree.put(c,inDegree.get(c)-1);
                if (inDegree.get(c)==0){
                    queue.add(c);
                    // inDegree.remove(c);
                }
            }
        }

        return ans.length()==inDegree.size() ? ans.toString(): "";

    }

}
