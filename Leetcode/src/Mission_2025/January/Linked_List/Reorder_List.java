package Mission_2025.January.Linked_List;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Reorder_List {

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;
        while (fast!=null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next= null;

        ListNode curr = slow;
        ListNode prev = null;
        ListNode next= curr.next;
        while (curr!=null){
            next= curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;
        }

        ListNode list1 = head;
        ListNode list2 = prev;

        while (list2!=null){
            ListNode nextNode = list1.next;
            list1.next= list2;
            list1 = list2;
            list2 =nextNode;
        }


    }

    public void reorderList2(ListNode head) {
        Stack<ListNode> stack= new Stack<>();
        int count = 0;
        ListNode curr = head;
        while (curr!=null){
            stack.push(curr);
            curr=curr.next;
            count++;
        }

        ListNode temp;
        curr = head;
        for (int i=0;i<count/2;i++){
            temp= curr.next;
            curr.next = stack.pop();
            curr= curr.next;
            curr.next= temp;
            curr= temp;
        }

        curr.next=null;

    }

}
