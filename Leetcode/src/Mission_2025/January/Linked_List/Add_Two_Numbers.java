package Mission_2025.January.Linked_List;

public class Add_Two_Numbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry =0;
        ListNode head = new ListNode();
        ListNode prev = head;
        while (l1!=null && l2!=null){

            int curr = l1.val+l2.val+carry;
            int currVal = curr%10;
            carry = curr/10;
            prev.next = new ListNode(currVal);
            prev=  prev.next;
            l1= l1.next;
            l2= l2.next;
        }

        while (l1!=null){
            int curr = l1.val+carry;
            int currVal = curr%10;
            carry = curr/10;
            prev.next = new ListNode(currVal);
            prev=  prev.next;
            l1= l1.next;
        }

        while (l2!=null){
            int curr = l2.val+carry;
            int currVal = curr%10;
            carry = curr/10;
            prev.next = new ListNode(currVal);
            prev=  prev.next;
            l2= l2.next;
        }

        if (carry!=0){
            prev.next = new ListNode(carry);
            prev=  prev.next;
        }

        return head.next;

    }

}
