package Google.April;

import java.util.HashMap;

public class Greatest_Common_Divisor_Traversal {

    class Union {

        int[] size;
        int[] parent;
        int count;

        public Union(int capacity){
            this.count= capacity;
            size= new int[count];
            parent=new int[count];

            for (int i=0;i<count;i++){
                parent[i]=i;
                size[i]=1;
            }
        }

        public int find(int x){
            if (parent[x]==x){
                return x;
            }else{
                parent[x] = find(parent[x]);
                return parent[x];
            }
        }

        public void union(int a,int b){
            int pa = find(a);
            int pb = find(b);

            if (pa==pb){
                return;
            }
            count--;
            if (size[pa]>=size[pb]){
                parent[pb]=pa;
                size[pb]+=size[pa];
            }else {
                parent[pa]=pb;
                size[pa]+=size[pb];
            }
        }


    }

    public boolean canTraverseAllPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Union union= new Union(nums.length);
        for (int i=0;i< nums.length;i++){

            int curr = nums[i];
            for (int j=2;j*j<=curr;j++){
                if (curr%j==0){
                    if (map.containsKey(j)){
                        union.union(i,map.get(j));
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
                    union.union(i,map.get(curr));
                }else {
                    map.put(curr,i);
                }
            }

        }

        return union.count==1;

    }

}
