package Google.July;

import java.util.Arrays;

public class Redundant_Connection_II {


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

        public boolean union(int a,int b){

            int par_a  = find(a);
            int par_b  = find(b);

            if (par_b==par_a){
                return true;
            }
            count--;
            if (rank[par_a]>=rank[par_b]){
                parent[par_b]=par_a;
                rank[par_b]+=rank[par_a];
            }else {
                parent[par_a]=par_b;
                rank[par_a]+=rank[par_b];
            }
            return false;
        }


    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] indegree = new int[n+1];
        Arrays.fill(indegree,-1);
        int red1 = -1;
        int red2 = -1;
        for (int i=0;i<n;i++){
            if (indegree[edges[i][1]]==-1){
                indegree[edges[i][1]]=i;
            }else {
                red2 = indegree[edges[i][1]];
                red1 = i;
                break;
            }
        }


        Union union = new Union(n+1);

        for (int i=0;i<n;i++){

            if (red1==i){
                continue;
            }

            boolean unionRes = union.union(edges[i][0],edges[i][1]);

            if (unionRes)
            {
                if (red1==-1){
                    return edges[i];
                }else {
                    return edges[red2];
                }
            }
        }

        return edges[red1];

    }

}
