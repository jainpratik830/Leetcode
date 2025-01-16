package Mission_2025.January.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens {

    List<List<String>> ans;

    public List<String> getBoard(char[][] board){
        List<String> curr =new ArrayList<>();
        for (char[] row:board){
            StringBuilder rowString = new StringBuilder();
            for (char c:row){
                rowString.append(c);
            }
            curr.add(rowString.toString());
        }
        return curr;
    }

    public void backtrack(char[][] board,int row){

        if (row==board.length){
            ans.add(getBoard(board));
            return;
        }

        for (int i=0;i<board[row].length;i++){

            if (isValid(board,row,i)){
                board[row][i]='Q';
                backtrack(board,row+1);
                board[row][i]='.';
            }
        }
    }

    public boolean isValid(char[][] board,int i,int j){


        for (int row = 0;row<i;row++){
            if (board[row][j]=='Q'){
                return false;
            }
        }

        for (int k=i,l=j;k>=0 && l>=0;k--,l--){
            if (board[k][l]=='Q'){
                return false;
            }
        }

        for (int k=i,l=j;k>=0 && l<board[0].length;k--,l++){
            if (board[k][l]=='Q'){
                return false;
            }
        }
        return true;

    }

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        char[][] board= new char[n][n];
        for (char[] row:board){
            Arrays.fill(row,'.');
        }
        backtrack(board,0);
        return ans;
    }

}
