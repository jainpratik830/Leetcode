package Google.April;

public class Add_Two_Numbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode curr  = root;
        int carry = 0;
        ListNode prev = null;
        while (l1!=null && l2!=null){
            int a = l1.val+ l2.val+carry;
            if (a>=10){
                carry =a/10;
                a=a%10;
            }else{
                carry=0;
            }
            curr.val=a;
            ListNode node = new ListNode();
            curr.next=node;
            prev=curr;
            curr=curr.next;
            l1=l1.next;
            l2=l2.next;
        }

        while (l2!=null){
            int a = l2.val+carry;
            if (a>=10){
                carry =a/10;
                a=a%10;
            }else{
                carry=0;
            }
            curr.val=a;
            ListNode node = new ListNode();
            curr.next=node;
            prev=curr;
            curr=curr.next;
            l2=l2.next;
        }

        while (l1!=null){
            int a = l1.val+carry;
            if (a>=10){
                carry =a/10;
                a=a%10;
            }else{
                carry=0;
            }
            curr.val=a;
            ListNode node = new ListNode();
            curr.next=node;
            prev=curr;
            curr=curr.next;

            l1=l1.next;
        }

        if (carry!=0){
            curr.val=carry;
            ListNode node = new ListNode();
            curr.next=node;
            prev=curr;
            curr=curr.next;
        }
        prev.next= null;

        return root;
    }

}
