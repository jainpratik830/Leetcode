package Mission_2025.January.Daily_Problems;

public class Make_Lexicographically_Smallest_Array_by_Swapping_Elements {

    class DSU {
        public int[] parent;
        public int[] sizes;
        DSU(int n) {
            parent = new int[n];
            sizes = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                sizes[i] = 1;
            }
        }
        public int find(int a) {
            int rootA = parent[a];
            if (rootA != a) {
                rootA = find(rootA);
            }
            return rootA;
        }
        public int union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return rootA;
            }
            if (rootA >= rootB) {
                sizes[rootA]+= sizes[rootB];
                parent[rootA] = rootB;
                return rootB;
            } else {
                sizes[rootB]+= sizes[rootA];
                parent[rootB] = rootA;
                return rootA;
            }

        }
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        return new int[0];
    }

}
