package Google.May.Others;

import java.util.List;

public class Delete_Node_in_a_Linked_List {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {

        ListNode temp = node;
        ListNode prev = temp;
        while (temp.next !=null){
            temp.val = temp.next.val;
            prev = temp;
            temp =temp.next;
        }

        prev.next = null;



    }


}
