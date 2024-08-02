package Google.August;

import java.util.HashMap;
import java.util.Map;

public class Largest_Component_Size_by_Common_Factor {

    public class Union {

        int[] rank;
        int[] parent;
        int n;

        public Union(int size){
            this.n=size;
            rank = new int[n];
            parent = new int[n];
            for (int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=1;
            }
        }

        public int find(int x){
            if (parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }


        public void union(int a,int b){
            int par_a = find(a);
            int par_b = find(b);

            if (par_a==par_b){
                return;
            }

            if (rank[par_a]>=rank[par_b]){
                parent[par_b]=par_a;
                rank[par_a]+= rank[par_b];
            }else if (rank[par_a]<rank[par_b]){
                parent[par_a]=par_b;
                rank[par_b]+= rank[par_a];
            }
        }


//        public void print(){
//            System.out.println(Arrays.toString(parent));
//            System.out.println(Arrays.toString(rank));
//        }

        public int size(int a){
            int par_a = find(a);

            return rank[par_a];
        }


    }

    public int largestComponentSize(int[] nums) {

        Union union=  new Union(nums.length);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){

            int num = nums[i];
            for (int factor = 2; factor * factor <= num; factor++) {
                if (num%factor==0){
                    if (map.containsKey(factor)){
                        union.union(i,map.get(factor));
                    }else {
                        map.put(factor,i);
                    }

                    if (map.containsKey(num/factor)){
                        union.union(i,map.get(num/factor));
                    }else {
                        map.put(num/factor,i);
                    }
                }
            }
            if (!map.containsKey(num))
                map.put(num, i);
            else
                union.union(i, map.get(num));

        }
        // union.print();
        int max = 0;
        for (int i=0;i<nums.length;i++){
            max = Math.max(max,union.size(i));
        }

        return max;
    }

    public int gcd(int a,int b){

        while (b!=0){
            int temp = b;
            b= a%b;
            a= temp;
        }
        return a;
    }
}
