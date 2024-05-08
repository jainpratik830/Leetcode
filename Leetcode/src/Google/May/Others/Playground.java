package Google.May.Others;

import java.util.*;

public class Playground {


    class Circle {
        int x, y, radius;

        public Circle(int x, int y, int radius) {
            super();
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public boolean isOverLapping(Circle cir) {
            int radius_square = (cir.radius + this.radius) * (cir.radius +
                    this.radius);
            int distance = (this.x - cir.x) * (this.x - cir.x) - (this.y -
                    cir.y) * (this.y - cir.y);
            return distance <= radius_square;
        }
    }

    public boolean circleOfSameComponet(List<Circle> list) {
        int n = list.size();
        int parent[] = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && list.get(i).isOverLapping(list.get(j))) {
                    int iParent = findParent(i, parent);
                    int jParent = findParent(j, parent);
                    if (iParent != jParent) {
                        parent[iParent] = jParent;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                count++;
            }
            if (count > 1)
                return false;
        }
        return true;
    }

    private int findParent(int i, int[] parent) {
        if (parent[i] == -1)
            return i;
        return findParent(parent[i], parent);

    }

    public void main(String[] args) {

        List circles = new ArrayList<>();
        circles.add(new Circle(1, 2, 4));
        circles.add(new Circle(3, 7, 5));
        circles.add(new Circle(2, 2, 4));
        boolean result = circleOfSameComponet(circles);
        System.out.println(result);
    }
    class Node{
        String val;
        Node prev;
        Node next;
        public Node(String val){
            this.val = val;
        } }

    class SearchDS{
        int N;
        Map<String, Node> map;
        Node left;
        Node right;
        public SearchDS(int num){
            this.N = num;
            map = new HashMap<>();
            left.next = right;
            right.next = left;
        }
        //R : O(1)
        public void addSearch(String s){ if(!map.containsKey(s)){
            map.put(s, new Node(s));
        }else{
            map.remove(map.get(s));
        }
        } }


}
