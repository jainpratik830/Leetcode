package Google.July;

import java.util.*;

public class Build_a_Matrix_With_Conditions {

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] ans = new int[k][k];

        int[] orderRows = topoSort(rowConditions, k);
        // System.out.println(Arrays.toString(orderRows));
        int[] orderColumns = topoSort(colConditions, k);
        // System.out.println(Arrays.toString(orderColumns));
        if (
                orderRows.length == 0 || orderColumns.length == 0
        ) return new int[0][0];
        int[][] matrix = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (orderRows[i] == orderColumns[j]) {
                    matrix[i][j] = orderRows[i];
                }
            }
        }
        return matrix;
    }


    private int[] topoSort(int[][] edges, int n) {

        int[] deg = new int[n+1];
        HashMap<Integer, List<Integer>> rowMap = new HashMap<>();
        int[] order = new int[n];
        int idx = 0;
        for (int[] i:edges){
            rowMap.putIfAbsent(i[0],new ArrayList<>());
            rowMap.get(i[0]).add(i[1]);
            deg[i[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (deg[i] == 0) q.offer(i);
        }


//         System.out.println(rowMap);
//         System.out.println(Arrays.toString(deg));

        while (!q.isEmpty()) {
            int f = q.poll();
            order[idx++] = f;
            n--;
            for (int v : rowMap.getOrDefault(f,new ArrayList<>())) {
                if (--deg[v] == 0) q.offer(v);
            }
        }
        if (n != 0) return new int[0];
        return order;

    }

}
