package Google.April;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Reveal_Cards_In_Increasing_Order {

    public int[] deckRevealedIncreasing(int[] deck) {
        int[] ans = new int[deck.length];
        Arrays.sort(deck);
        Queue<Integer> queue= new LinkedList<>();

        for (int i=0;i<deck.length;i++){
            queue.add(i);
        }

        for (int i=0;i<deck.length;i++){
            ans[queue.poll()]=deck[i];
            queue.add(queue.poll());
        }
        return ans;
    }

}
