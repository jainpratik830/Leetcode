package Mission_2025.January.Linked_List;

public class Merge_Two_Sorted_Lists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode newHead = head;
        while (list1!=null && list2!=null){
            if (list1.val<list2.val){
                head.next = (list1);
                head = head.next;
                list1= list1.next;
            }else {
                head.next= list2;
                head = head.next;
                list2=list2.next;
            }
        }

        while (list1!=null){
            head.next = (list1);
            head = head.next;
            list1= list1.next;
        }

        while (list2!=null){
            head.next = (list2);
            head = head.next;
            list2=list2.next;
        }

        return newHead.next;
    }

}
