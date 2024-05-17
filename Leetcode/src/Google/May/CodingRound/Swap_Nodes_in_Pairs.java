package Google.May.CodingRound;

public class Swap_Nodes_in_Pairs {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode swapPairs(ListNode head) {
        ListNode first = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        if (head==null || head.next==null){
            return head;
        }
        ListNode second =head.next;

        while (second!=null && first!=null){
            ListNode temp = second.next;
            prev.next = second;
            second.next = first;
            first.next = temp;
            prev  = first;
            first = temp;

            if (first==null){
                break;
            }
            second = first.next;
        }


        return dummy.next;
    }
}
