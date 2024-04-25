package Google.April;

import java.util.PriorityQueue;

public class Reorganize_String {

    public String reorganizeString(String s) {
        StringBuilder ans = new StringBuilder();
        int[] count = new int[26];
        for (char c:s.toCharArray()){
            count[c-'a']++;
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));

        for (int i=0;i<26;i++){
            if (count[i]>0){
                priorityQueue.offer(new int[]{i,count[i]});
            }
        }

        while (!priorityQueue.isEmpty()){
            int[] first = priorityQueue.poll();
            if (ans.length()==0 || ans.charAt(ans.length()-1)!=first[0]+'a'){
                ans.append((char)(first[0]+'a'));
                if (--first[1]>0){
                    priorityQueue.offer(first);
                }
            }else {
                if (priorityQueue.isEmpty()){
                    return "";
                }
                int[] second = priorityQueue.poll();
                ans.append((char)(second[0]+'a'));
                if (--second[1]>0){
                    priorityQueue.offer(second);
                }

                priorityQueue.offer(first);
            }
        }

        return ans.toString();

    }

}
