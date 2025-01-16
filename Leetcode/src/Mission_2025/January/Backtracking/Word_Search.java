package Mission_2025.January.Backtracking;

public class Word_Search {

    public boolean check(char[][] board,int i,int j,boolean[][] visited,int curr,String word){

        if (curr==word.length()){
            return true;
        }

        if (i>=board.length || i<0 || j >= board[0].length || j<0 || visited[i][j] || board[i][j] != word.charAt(curr)){
            return false;
        }
        visited[i][j]=true;
        boolean possible = false;
         possible = possible || check(board,i+1,j,visited,curr+1,word);
         possible = possible || check(board,i,j+1,visited,curr+1,word);
        possible = possible || check(board,i,j-1,visited,curr+1,word);
        possible = possible || check(board,i-1,j,visited,curr+1,word);
        visited[i][j]=false;
        return possible;
    }

    public boolean exist(char[][] board, String word) {

        boolean ans = false;
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==word.charAt(0))
                    ans = ans || check(board,i,j,new boolean[board.length][board[0].length],0,word);
            }
        }
        return ans;

    }

}
