package Mission_2025.January.Linked_List;

public class Remove_Nth_Node_From_End_of_List {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count =n;
        ListNode temp = head;
        if (head.next== null){
            return null;
        }
        while (count-->0){
            temp= temp.next;
        }

        ListNode toDelete= head;
        ListNode prev = null;
        while (temp!=null){
            prev= toDelete;
            toDelete=  toDelete.next;
            temp= temp.next;
        }
        if (toDelete==head){
            return head=head.next;
        }
        prev.next = toDelete.next;
        toDelete.next = null;
        return head;
    }

}
