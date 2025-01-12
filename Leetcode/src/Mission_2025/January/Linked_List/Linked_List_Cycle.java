package Mission_2025.January.Linked_List;

public class Linked_List_Cycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        if (head==null || head.next==null){
            return false;
        }
        ListNode fast = head.next.next;

        while (slow != fast && fast!= null){
            slow = slow.next;
            if (fast.next==null){
                return false;
            }
            fast = fast.next.next;
        }

        return slow==fast;
    }

}
