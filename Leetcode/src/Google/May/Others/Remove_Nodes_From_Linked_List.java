package Google.May.Others;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Remove_Nodes_From_Linked_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNodes(ListNode head) {

        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;

        // Add nodes to the stack
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        current = stack.pop();
        int maximum = current.val;
        ListNode resultList = new ListNode(maximum);

        // Remove nodes from the stack and add to result
        while (!stack.isEmpty()) {
            current = stack.pop();
            // Current should not be added to the result
            if (current.val < maximum) {
                continue;
            }
            // Add new node with current's value to front of the result
            else {
                ListNode newNode = new ListNode(current.val);
                newNode.next = resultList;
                resultList = newNode;
                maximum = current.val;
            }
        }

        return resultList;
    }

}
