package Google.April;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {


    class LinkedList {


        LinkedList prev,next;
        int value,key;

        public LinkedList(int key,int value){
            this.prev = null;
            this.next= null;
            this.value = value;
            this.key= key;
        }

    }

    public void insertAtEnd(LinkedList node)
    {
        if (tail == null) {
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void deleteNode(LinkedList node){
        if (head==tail){
            head=null;
            tail=null;
            return;
        }

        if (node==tail){



            tail=tail.prev;
            tail.next=null;
            node.prev=node;
            return;
        }

        if (node == head){
            head=head.next;
            node.next=null;
            head.prev=null;
            return;
        }

        LinkedList prev = node.prev;
        LinkedList next = node.next;
        prev.next = next;
        next.prev = prev;
        node.next=null;
        node.prev=null;
    }

    LinkedList head,tail;
    Map<Integer,LinkedList> map;
    int cap;

    public LRUCache(int capacity) {
        map= new HashMap<>(capacity);
        this.cap= capacity;

    }

    public int get(int key) {
        if (map.containsKey(key)){
            LinkedList node = map.get(key);
            int ans =node.value;
            deleteNode(node);
            insertAtEnd(node);
            return ans;
        }

        return -1;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)){
            LinkedList node = map.get(key);
            node.value=value;
            deleteNode(node);
            insertAtEnd(node);
            map.put(key,node);
            return;
        }

        if (map.size()==cap){
            int currKey = head.key;;
            deleteNode(head);
            map.remove(currKey);
        }


        LinkedList node = new LinkedList(key,value);
        insertAtEnd(node);
        map.put(key,node);
    }

}
