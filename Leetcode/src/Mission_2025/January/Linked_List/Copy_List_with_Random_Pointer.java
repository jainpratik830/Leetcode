package Mission_2025.January.Linked_List;

import java.util.HashMap;

public class Copy_List_with_Random_Pointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node curr = head;
        Node temp = null;
        while (curr!=null){
            temp= curr.next;
            Node newNode =new Node(curr.val);
            curr.next=newNode;
            newNode.next= temp;
            curr= temp;
        }

        curr= head;
        while (curr!=null){
            temp= curr.next;
            Node next = temp.next;
            if (curr.random!=null)
                curr.next.random = curr.random.next;
            else
                curr.next.random=null;
            curr= next;
        }
        // return head;
        Node newHead = head.next;
        curr= head;
        while (curr!=null){
            temp = curr.next;
            curr.next = temp.next;
            curr =curr.next;
            if(curr!=null)
                temp.next = curr.next;
            else
                temp.next = null;
        }

        return newHead;
    }

    public Node copyRandomList2(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        if (head==null){
            return null;
        }
        Node temp = head;
        Node newHead = new Node(head.val);
        Node prev=null;
        int count =0;
        while (temp!=null){
            prev = newHead;

            newHead = new Node(temp.val);
            prev.next = newHead;
            map.put(temp,newHead );
            temp= temp.next;
            count++;
        }

        temp= head;
        count = 0;
        while (temp!=null){
            if (temp.random!=null){
                System.out.println(temp.random.val);
            }
            map.get(temp).random =temp.random!=null ? map.get(temp.random) : null;
            count++;
            temp = temp.next;
        }


        return map.get(head);

    }

}
