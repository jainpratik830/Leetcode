package Mission_2025.January.Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Max_Area_of_Island {

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

    public boolean isValid(int i,int j,int[][] grid){

        if (Math.min(i,0)>=0 && Math.min(j,0)>=0 && i<grid.length && j < grid[0].length && grid[i][j]==1){
            return true;
        }

        return false;

    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        DSU dsu = new DSU(n*m);
        int[] x = {0,0,-1,1};
        int[] y= {-1,1,0,0};
        for (int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        if (isValid(i + x[k], j + y[k], grid)) {
                            dsu.union(i * n + j, (i + x[k]) * n + j + y[k]);
                        }
                    }
                }
            }
        }

        Map<Integer, Integer> areaMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int parent = dsu.findParent(i * m + j);
                    areaMap.put(parent, areaMap.getOrDefault(parent, 0) + 1);
                }
            }
        }

        int ans = 0;
        for (int size : areaMap.values()) {
            ans = Math.max(ans, size);
        }
        return ans;
    }
}
