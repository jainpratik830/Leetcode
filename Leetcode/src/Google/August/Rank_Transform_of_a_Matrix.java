package Google.August;

import java.util.*;

public class Rank_Transform_of_a_Matrix {

    class DSU {
        public int[] roots;
        public int[] sizes;
        DSU(int n) {
            roots = new int[n];
            sizes = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
                sizes[i] = 1;
            }
        }
        public int find(int a) {
            int rootA = roots[a];
            if (rootA != a) {
                rootA = find(rootA);
            }
            return rootA;
        }
        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return;
            }
            if (sizes[rootA] >= sizes[rootB]) {
                sizes[rootA]+= sizes[rootB];
                roots[rootB] = rootA;
            } else {
                sizes[rootB]+= sizes[rootA];
                roots[rootA] = rootB;
            }
        }
    }
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans  =new int[m][n];
        int[] row = new int[m];
        int[] col = new int[n];
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                map.putIfAbsent(matrix[i][j],new ArrayList<>());
                map.get(matrix[i][j]).add(new int[]{i,j});
            }
        }
        DSU dsu = new DSU(n*m);
        for (int i:map.keySet()){
            List<int[]> curr = map.get(i);
            int currRank =0;
            if (curr.size()==1){
                int[] j=curr.get(0);
                currRank=Math.max(currRank, Math.max(row[j[0]],col[j[1]]))+1;
                ans[j[0]][j[1]]=currRank;
                row[j[0]]=currRank;
                col[j[1]]=currRank;
            }else {
                Collections.sort(curr,Comparator.comparingInt(a->a[0]));
                for (int j=1;j<curr.size();j++){
                    if (curr.get(j)[0]==curr.get(j-1)[0]){
                        dsu.union(n*curr.get(j)[0]+curr.get(j)[1],n*curr.get(j-1)[0]+curr.get(j-1)[1]);
                    }
                }
                Collections.sort(curr,Comparator.comparingInt(a->a[1]));
                for (int j=1;j<curr.size();j++){
                    if (curr.get(j)[1]==curr.get(j-1)[1]){
                        dsu.union(n*curr.get(j)[0]+curr.get(j)[1],n*curr.get(j-1)[0]+curr.get(j-1)[1]);
                    }
                }

                HashMap<Integer,List<int[]>> group = new HashMap<>();
                for (int j=0;j<curr.size();j++){
                    int currGroup = dsu.find(n*curr.get(j)[0]+curr.get(j)[1]);
                    group.putIfAbsent(currGroup,new ArrayList<>());
                    group.get(currGroup).add(curr.get(j));
                }

                for (int k:group.keySet()){
                    currRank=0;
                    for (int[] j:group.get(k)){
                        currRank = Math.max(currRank, Math.max(row[j[0]],col[j[1]]));
                    }
                    currRank++;
                    for (int[] j:group.get(k)){
                        ans[j[0]][j[1]]=currRank;
                        row[j[0]]=currRank;
                        col[j[1]]=currRank;
                    }
                }
            }
//            System.out.println("Row Col");
//            System.out.println(Arrays.toString(row));
//            System.out.println(Arrays.toString(col));
        }

        return ans;
    }

}
