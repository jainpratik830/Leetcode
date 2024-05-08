package Google.May.Others;

import java.util.Stack;

public class Double_a_Number_Represented_as_a_Linked_List {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode doubleIt(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp!=null){
            stack.push(temp);
            temp=temp.next;
        }

        int carry=0;
        while (!stack.isEmpty()){
            ListNode curr = stack.pop();
            int val = (curr.val*2+carry)%10;
            carry = (curr.val*2+carry)/10;
            curr.val = val;

        }

        if (carry!=0){
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            head = newHead;
        }

        return head;
    }
}
