package Google.April;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Sudoku_Solver {

    Map<Integer,HashSet<Integer>> row;
    Map<Integer,HashSet<Integer>> col;
    Map<Integer,HashSet<Integer>> box;

    char[][] ans;
    boolean solved = false;

    public void getNext(char[][] board,int i,int j){

        if(i==8 && j==8){
            solved= true;
        }else{
            if (j==8){
                solve(board,i+1,0);
            }else{

                solve(board,i,j+1);
            }

        }



    }

    public void solve(char[][] board,int i,int j){
        // System.out.println(count);
        // if (solved){
        //     System.out.println(count);
        //     // ans = board.clone();
        //     return;
        // }
        // if(i==8 && j==8){
        //     solved= true;
        //     return;
        // }

        if (board[i][j] == '.') {
            for (int k=1;k<=9;k++){
                if (!row.getOrDefault(i,new HashSet<>()).contains(k)  && !col.getOrDefault(j,new HashSet<>()).contains(k)  &&  !box.getOrDefault((i/3)*3+(j/3),new HashSet<>()).contains(k) ){
                    board[i][j]= (char) (k+'0');
                    // System.out.println(board[i][j]);
                    row.getOrDefault(i,new HashSet<>()).add(k);
                    col.getOrDefault(j,new HashSet<>()).add(k);
                    box.getOrDefault((i/3)*3+(j/3),new HashSet<>()).add(k);
                    getNext(board,i,j);

                    if (!solved){
                        row.getOrDefault(i,new HashSet<>()).remove(k);
                        col.getOrDefault(j,new HashSet<>()).remove(k);
                        box.getOrDefault((i/3)*3+(j/3),new HashSet<>()).remove(k);
                        board[i][j]= '.';
                        // }else{
                        //     ans = board.clone();
                    }

                }
            }


        }else{
            getNext(board,i,j);

        }

    }

    public void solveSudoku(char[][] board) {

        row = new HashMap<>();
        col = new HashMap<>();
        box = new HashMap<>();
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j]!='.'){
                    int curr = board[i][j]-'0';
                    row.putIfAbsent(i,new HashSet<>());
                    row.get(i).add(curr);
                    col.putIfAbsent(j,new HashSet<>());
                    col.get(j).add(curr);
                    box.putIfAbsent((i/3)*3+(j/3),new HashSet<>());
                    box.get((i/3)*3+(j/3)).add(curr);
                }
            }
        }
        solve(board,0,0);
        // board = ans.clone();

    }

}
