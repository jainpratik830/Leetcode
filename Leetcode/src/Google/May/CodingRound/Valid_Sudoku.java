package Google.May.CodingRound;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Valid_Sudoku {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer,HashSet<Integer>> row = new HashMap<>();
        Map<Integer,HashSet<Integer>> col = new HashMap<>();
        Map<Integer,HashSet<Integer>> box = new HashMap<>();
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j]!='.'){
                    int curr = board[i][j]-'0';
                    row.putIfAbsent(i,new HashSet<>());
                    // row.get(i).add(curr);
                    col.putIfAbsent(j,new HashSet<>());
                    // col.get(j).add(curr);
                    box.putIfAbsent((i/3)*3+(j/3),new HashSet<>());
                    // box.get((i/3)*3+(j/3)).add(curr);
                }
            }
        }
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]!='.'){
                    if (row.getOrDefault(i,new HashSet<>()).contains(board[i][j]-'0') || col.getOrDefault(j,new HashSet<>()).contains(board[i][j]-'0') ||
                            box.getOrDefault((i/3)*3+(j/3),new HashSet<>()).contains(board[i][j]-'0')){
                        // System.out.println(row);
                        //  System.out.println(col);
                        //  System.out.println(box);
                        // System.out.println("i="+i+" j="+j);
                        return false;
                    }
                    row.getOrDefault(i,new HashSet<>()).add(board[i][j]-'0');
                    col.getOrDefault(j,new HashSet<>()).add(board[i][j]-'0');
                    box.getOrDefault((i/3)*3+(j/3),new HashSet<>()).add(board[i][j]-'0');
                }
                // System.out.println(box);
            }
        }



        return true;
    }

}
