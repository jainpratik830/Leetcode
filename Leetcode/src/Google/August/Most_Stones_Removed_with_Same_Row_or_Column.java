package Google.August;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Most_Stones_Removed_with_Same_Row_or_Column {


    public int removeStones(int[][] stones) {
        if (stones == null || stones.length <= 1) {
            return 0;
        }

        int n = stones.length;

        UnionFind uf = new UnionFind();
        for (int[] edge : stones) {
            uf.union(edge[0] + 10001, edge[1]);
        }

        return n - uf.getCount();
    }

    class UnionFind {
        Map<Integer, Integer> parents;
        int count;

        public UnionFind() {
            parents = new HashMap<>();
            count = 0;
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            if (!parents.containsKey(x)) {
                parents.put(x, x);
                count++;
            }

            if (x != parents.get(x)) {
                parents.put(x, find(parents.get(x)));
            }

            return parents.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parents.put(rootX, rootY);
            count--;
        }
    }

}
