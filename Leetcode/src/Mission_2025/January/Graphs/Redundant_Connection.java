package Mission_2025.January.Graphs;

import java.util.Arrays;

public class Redundant_Connection {

    public class DSU {

        int[] parent;
        int[] rank;
        int size;

        public DSU(int n){
            size = n;
            parent=  new int[n];
            rank=  new int[n];
            Arrays.fill(rank,1);
            for (int i=0;i<n;i++){
                parent[i]=i;
            }
        }

        public int findParent(int i){
            if (parent[i]==i){
                return i;
            }
            return parent[i]=findParent(parent[i]);
        }

        public boolean union(int x,int y){
            int par_x = findParent(x);
            int par_y = findParent(y);

            if (par_x==par_y){
                return false;
            }

            if (rank[par_x]>rank[par_y]){
                parent[par_y]=par_x;
                rank[par_x]+=rank[par_y];
            }else {
                parent[par_x]=par_y;
                rank[par_y]+=rank[par_x];
            }
            return true;
        }

    }


    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n+1);
        for (int[] edge:edges){
            boolean possible = dsu.union(edge[0],edge[1]);
            if (!possible){
                return edge;
            }
        }

        return null;
    }
}
