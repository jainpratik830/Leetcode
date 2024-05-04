package Google.May.Array;

import java.util.HashMap;

public class Greatest_Common_Divisor_Traversal {

    class Union {

        int count;
        int[] parent;
        int[] rank;

        public Union(int size){
            this.count = size;
            parent= new int[size];
            rank = new int[size];
            for (int i=0;i<size;i++){
                parent[i]=i;
                rank[i]=1;
            }
        }

        public int find(int x){

            if (parent[x]==x){
                return x;
            }else {
                parent[x] =find(parent[x]);
                return parent[x];
            }
        }

        public void union(int a,int b){

            int par_a  = find(a);
            int par_b  = find(b);

            if (par_b==par_a){
                return;
            }
            count--;
            if (rank[par_a]>=rank[par_b]){
                parent[par_b]=par_a;
                rank[par_b]+=rank[par_a];
            }else {
                parent[par_a]=par_b;
                rank[par_a]+=rank[par_b];
            }

        }


    }

    public boolean canTraverseAllPairs(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        Union union = new Union(nums.length);

        for (int i=0;i<nums.length;i++){
            int curr = nums[i];

            for (int j=2;j*j<=curr;j++){
                if (curr%j==0){
                    if (map.containsKey(j)){
                        union.union(map.get(j),i);
                    }else {
                        map.put(j,i);
                    }
                    while (curr%j==0){
                        curr/=j;
                    }
                }
            }
            if (curr>1){
                if (map.containsKey(curr)){
                    union.union(map.get(curr),i);
                }else {
                    map.put(curr,i);
                }
            }

        }
        return union.count==1;


    }



}
