package Google.July;

import java.util.LinkedList;
import java.util.Queue;

public class Battleships_in_a_Board {

    public int countBattleships(char[][] board) {
        int count = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'X' && !visited[row][col]) {
//                    board[row][col] = '.';
                    bfs(board, row, col,visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private void bfs(char[][] board, int i, int j,boolean[][] visited ) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            visited[row][col] = true;
            for (int[] dir : DIRS) {
                int nextR = row + dir[0];
                int nextC = col + dir[1];
                if (nextR >= 0 && nextR < board.length && nextC >= 0 && nextC < board[0].length && board[nextR][nextC] == 'X' && !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    queue.offer(new int[] {nextR, nextC});
                }
            }
        }
    }

}
