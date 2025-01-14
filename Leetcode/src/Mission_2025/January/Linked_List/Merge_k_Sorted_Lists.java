package Mission_2025.January.Linked_List;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_k_Sorted_Lists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.val));
        for (ListNode l:lists){
            if (l !=null)
                pq.add(l);
        }

        ListNode newHead= new ListNode();
        ListNode temp =newHead;
        while (!pq.isEmpty()){
            ListNode top= pq.poll();
            ListNode next= top.next;
            if (next!=null){
                pq.add(next);
            }
            if (newHead.next==null){
                newHead.next=temp;
            }
            temp.next= top;
            temp = top;
            temp.next = null;
        }

        return newHead.next;

    }


}
