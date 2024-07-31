package Google.July;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Trapping_Rain_Water_II {

    public void print(int[][] arr){
        for (int[] i:arr){
            System.out.println(Arrays.toString(i));
        }
    }

    public class Point implements Comparable<Point> {
        int row,col,val;

        public Point(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public int compareTo(Point o) {
            return this.val-o.val;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        int[][] dirs = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[m][n];
        for (int i=0;i<m;i++){
            pq.add(new Point(i,0,heightMap[i][0]));
            pq.add(new Point(i,n-1,heightMap[i][n-1]));
            visited[i][0]=true;
            visited[i][n-1]=true;
        }

        for (int i=1;i<n-1;i++){
            pq.add(new Point(0,i,heightMap[0][i]));
            pq.add(new Point(m-1,i,heightMap[m-1][i]));
            visited[0][i]=true;
            visited[m-1][i]=true;
        }
        int ans =0;
        int max = 0;
        while (!pq.isEmpty()){

            Point curr = pq.poll();
            max = Math.max(curr.val,max);
            for (int i=0;i<4;i++){
                int new_row = curr.row+dirs[i][0];
                int new_col = curr.col+dirs[i][1];
                if (Math.min(new_row,new_col)>=0 && new_col<n && new_row<m && !visited[new_row][new_col]){
                    if (heightMap[new_row][new_col]<max){
                        ans += max - heightMap[new_row][new_col];
                    }
                    visited[new_row][new_col]=true;
                    pq.add(new Point(new_row,new_col,heightMap[new_row][new_col]));
                }
            }



        }

        return ans;
    }

}
