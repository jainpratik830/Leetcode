package Google.July;

public class Construct_Quad_Tree {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public boolean sameValue(int row,int col,int length,int[][] grid){
        boolean hasOne = false;
        boolean hasZero = false;

        for (int i=row;i<row+length;i++){
            for (int j=col;j<col+length;j++){
                if (grid[i][j]==1){
                    hasOne=true;
                }
                if (grid[i][j]==0){
                    hasZero= true;
                }

                if (hasZero && hasOne){
                    return false;
                }
            }
        }

        return true;
    }

    public Node construct(int[][] grid) {
        return contructHelper(grid,0,0, grid.length);
    }

    public Node contructHelper(int[][] grid,int row,int col,int length){

        if (sameValue(row,col,length,grid)){
            return new Node(grid[row][col]==1,true);
        }

        Node node = new Node(false,false);
        node.topLeft= contructHelper(grid,row,col,length/2);
        node.topRight= contructHelper(grid,row,col+length/2,length/2);
        node.bottomLeft = contructHelper(grid,row+length/2,col,length/2);
        node.bottomRight = contructHelper(grid,row+length/2,col+length/2,length/2);

        return node;
    }

}
