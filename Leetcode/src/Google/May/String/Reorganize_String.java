package Google.May.String;

import java.util.PriorityQueue;

public class Reorganize_String {

    public String reorganizeString(String s) {
        int[] count = new int[26];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[1]-a[1]));
        for (int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }

        for (int i=0;i<26;i++){
            if (count[i]>0){
                pq.offer(new int[]{i,count[i]});
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()){
            int[] first = pq.poll();
            if (!ans.isEmpty() || ans.charAt(ans.length()-1)!=(first[0]+'a')){
                ans.append((char)  (first[0]+'a'));
                if (--first[1]>0){
                    pq.offer(first);
                }
            }else {
                if (pq.isEmpty()){
                    return "";
                }
                int[] second = pq.poll();
                ans.append((char)  (second[0]+'a'));
                if (--second[1]>0){
                    pq.offer(second);
                }
                pq.offer(first);
            }
        }

        return ans.toString();
    }

}
