package Google.June.Daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Find_the_Nodes_Between_Critical_Points {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {-1,-1};
        HashMap<ListNode,Integer> map = new HashMap<>();
        List<ListNode> points = new ArrayList<>();
        ListNode curr = head;
        ListNode prev = null;
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;
        int position =  0;
        while (curr!=null){
            position++;
            map.put(curr,position);
            if (prev==null){
                prev =curr;
                curr=curr.next;
                continue;
            }
            if (curr.next==null){
                break;
            }
            if (prev.val<curr.val && curr.val>curr.next.val){
                points.add(curr);
                if (points.size()>1){
                    maxDistance = Math.max(position-map.get(points.get(0) ),maxDistance);
                    minDistance = Math.min(position-map.get(points.get(points.size()-2) ),minDistance);
                }
            }
            if (prev.val>curr.val && curr.val<curr.next.val){
                points.add(curr);
                if (points.size()>1){
                    maxDistance = Math.max(position-map.get(points.get(0) ),maxDistance);
                    minDistance = Math.min(position-map.get(points.get(points.size()-2) ),minDistance);
                }
            }
            prev =curr;
            curr=curr.next;

        }

        if (points.size()>1){

            ans[0]= minDistance;
            ans[1] = maxDistance;
        }

        return ans;
    }

}
