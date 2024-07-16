package Google.July;

import java.util.*;

public class Find_the_Winner_of_the_Circular_Game {

    public int findTheWinner(int n, int k) {
        List<Integer> queue = new LinkedList<Integer>();
        for (int i=1;i<=n;i++){
            queue.add(i);
        }
        int next =0 ;
        while ((queue.size() >1)){
            next = (next+k-1)%queue.size();
            queue.remove(next);
        }

        return queue.get(0);
    }

}
