package Google.August;

import java.util.HashMap;

public class LRU_Cache {

    class LRUCache {

        class LinkedListNode {

            LinkedListNode prev,next;
            int val,key;


            public LinkedListNode(int key,int val){
                this.key=key;
                this.val = val;
            }

        }

        LinkedListNode head,tail;

        public void deleteNode(LinkedListNode node){

            if (head==tail){
                head=tail=null;
                return;
            }

            if (node==head){
                head=head.next;
                head.prev=null;
                return;
            }

            if(node==tail){
                tail=tail.prev;
                tail.next=null;
                return;
            }


            LinkedListNode prev= node.prev;
            LinkedListNode next = node.next;
//            node.prev=null;
//            node.next=null;
            prev.next=next;
            next.prev=prev;
            return;
        }

        public void insertAtEnd(LinkedListNode node){

            if (head==null && tail==null){
                head=tail=node;
            }

            tail.next= node;
            node.prev=tail;
            tail=node;
        }

        HashMap<Integer,LinkedListNode> map;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity= capacity;
            this.map = new HashMap<>();

        }

        public int get(int key) {

            if (map.containsKey(key)){

                LinkedListNode node= map.get(key);
                deleteNode(node);
                insertAtEnd(node);
                return node.val;
            }


            return -1;
        }

        public void put(int key, int value) {

            if(map.containsKey(key)){
                LinkedListNode node= map.get(key);
                node.val= value;
                deleteNode(node);
                insertAtEnd(node);
            }

            if (!map.containsKey(key)){
                LinkedListNode node =new LinkedListNode(key,value);
                map.put(key,node);
                insertAtEnd(node);

                if (map.keySet().size()>capacity){
                    map.remove(head.key);
                    deleteNode(head);
                }
            }


        }
    }



}
