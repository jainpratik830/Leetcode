package Google.April;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Validate_Binary_Tree_Nodes {



    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];
        parent[0]=-1;
        Arrays.fill(parent,-1);

        Queue<Integer> queue= new LinkedList<>();



        for (int i=0;i<n;i++){
            if (leftChild[i]==0 || rightChild[i]==0){
                return false;
            }

            if (leftChild[i]!=-1){
                if (parent[leftChild[i]]!=-1){
                    return false;
                }
                parent[leftChild[i]]=i;
            }
            if (rightChild[i]!=-1){
                if (parent[rightChild[i]]!=-1){
                    return false;
                }
                parent[rightChild[i]]=i;
            }
            System.out.println(Arrays.toString(leftChild));
        }

        int count =0;
        for (int i=0;i<n;i++){
            if (parent[i]==-1){
                queue.add(i);
                count++;
                if (count>1){
                    return false;
                }

            }
        }

        boolean[] visited =new boolean[n];
        while (!queue.isEmpty()){
            int curr = queue.poll();
            if (visited[curr]){
                return false;
            }
            visited[curr]=true;
            if (leftChild[curr]!=-1){
                if ( visited[leftChild[curr]]){
                    return false;
                }
                queue.add(leftChild[curr]);
            }
            if (rightChild[curr]!=-1){
                if ( visited[rightChild[curr]]){
                    return false;
                }
                queue.add(rightChild[curr]);
            }
        }

        for (boolean i:visited){
            if (!i){
                return false;
            }
        }

        return true;
    }


}
