package Google.May.CodingRound;

import java.util.*;

public class Validate_Binary_Tree_Nodes {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer, List<Integer>> child = new HashMap<>();
        Map<Integer,Integer> parent = new HashMap<>();
        for (int i=0;i<n;i++){

            child.putIfAbsent(i,new ArrayList<>());


            if (leftChild[i]!=-1){
                child.putIfAbsent(leftChild[i],new ArrayList<>());
                child.get(i).add(leftChild[i]);

                if (parent.containsKey(leftChild[i])){
                    return false;
                }else {
                    parent.put(leftChild[i],i);
                }
            }

            if (rightChild[i]!=-1){
                child.putIfAbsent(rightChild[i],new ArrayList<>());
                child.get(i).add(rightChild[i]);

                if (parent.containsKey(rightChild[i])){
                    return false;
                }else {
                    parent.put(rightChild[i],i);
                }
            }

        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<n;i++){
                if (parent.getOrDefault(i,-1)==-1){
                    queue.add(i);
                }
        }

        if (queue.isEmpty() || queue.size()>1){
            return false;
        }
        Set<Integer> visited= new HashSet<>();

        while (!queue.isEmpty()){
            int curr = queue.poll();

            visited.add(curr);

            for (int i:child.getOrDefault(curr,new ArrayList<>())){
                if (visited.contains(i)){
                    return false;
                }
                queue.add(i);
            }

        }

        return visited.size()==n;

    }


}
