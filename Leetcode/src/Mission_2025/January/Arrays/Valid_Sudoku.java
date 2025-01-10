package Mission_2025.January.Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Valid_Sudoku {

    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] columns = new int[9];
        int[] boxes = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                int num = board[i][j] - '1'; // Convert '1'-'9' to 0-8
                int mask = 1 << num;         // Create bitmask for the number
                int boxIndex = (i / 3) * 3 + j / 3;

                // Check if the number is already set in the row, column, or box
                if ((rows[i] & mask) != 0 || (columns[j] & mask) != 0 || (boxes[boxIndex] & mask) != 0) {
                    return false;
                }

                // Mark the number in the row, column, and box
                rows[i] |= mask;
                columns[j] |= mask;
                boxes[boxIndex] |= mask;
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {

        Map<Integer, HashSet<Integer>> rowMap = new HashMap<>();
        Map<Integer, HashSet<Integer>> colMap = new HashMap<>();
        Map<Integer, HashSet<Integer>> boxMap = new HashMap<>();

        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){

                int row = i;
                int col = j;
                int box = 3*(i/3)+(j/3);
                rowMap.putIfAbsent(row,new HashSet<>());
                colMap.putIfAbsent(col,new HashSet<>());
                boxMap.putIfAbsent(box,new HashSet<>());
                if (board[i][j]=='.'){
                    continue;
                }
                int curr = board[i][j]-'0';
                if (rowMap.get(row).contains(curr) || colMap.get(col).contains(curr) || boxMap.get(box).contains(curr)){
                    return false;
                }
                rowMap.get(row).add(curr);
                colMap.get(col).add(curr);
                boxMap.get(box).add(curr);

                System.out.println(rowMap);
                System.out.println(colMap);
                System.out.println(boxMap);
            }
        }
        return true;

    }

}
