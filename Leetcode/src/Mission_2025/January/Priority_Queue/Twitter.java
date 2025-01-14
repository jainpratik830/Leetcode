package Mission_2025.January.Priority_Queue;

import java.util.*;

public class Twitter {

    HashMap<Integer,ArrayList<int[]>> map;
    HashMap<Integer, Set<Integer>> follower;
    int timer;

    public Twitter() {
        map = new HashMap<>();
        follower = new HashMap<>();
        timer= 0;
    }

    public void postTweet(int userId, int tweetId) {
        ArrayList<int[]> list =  map.getOrDefault(userId,new ArrayList<>());
        list.add(new int[]{timer,tweetId});
        map.put(userId,list);
        timer++;
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        ArrayList<int[]> userTweet = map.getOrDefault(userId,new ArrayList<>());

        for (int[] i:userTweet){
            pq.add(i);
            if (pq.size()>10){
                pq.poll();
            }
        }

        for (int i:follower.getOrDefault(userId,new HashSet<>())){
            userTweet = map.getOrDefault(i,new ArrayList<>());
            for (int[] j:userTweet){
                pq.add(j);
                if (pq.size()>10){
                    pq.poll();
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()){
            ans.add(pq.poll()[1]);
        }
        timer++;
        Collections.reverse(ans);
        return ans;

    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> curr = follower.getOrDefault(followerId,new HashSet<>());
        curr.add(followeeId);
        follower.put(followerId,curr);
        // System.out.println(follower);
        timer++;
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> curr = follower.getOrDefault(followerId,new HashSet<>());
        curr.remove(followeeId);
        follower.put(followerId,curr);
        // System.out.println(follower);
        timer++;
    }

}
