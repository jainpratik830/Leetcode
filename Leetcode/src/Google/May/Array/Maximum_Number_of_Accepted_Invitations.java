package Google.May.Array;

import java.util.Arrays;

public class Maximum_Number_of_Accepted_Invitations {

    public boolean helper(int curr_row,int[][] grid,int[] connections, boolean[] visited){
        for(int i=0;i<grid[curr_row].length;i++){
            if(grid[curr_row][i]==1 && visited[i]==false){
                visited[i]=true;
                if(connections[i]==-1 || helper(connections[i],grid,connections,visited)){
                    connections[i]=curr_row;
                    return true;
                }
            }
        }
        return false;
    }

    public int maximumInvitations(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] connections = new int[col];
        Arrays.fill(connections,-1);

        for(int i=0;i<row;i++){
            boolean[] visited = new boolean[col];
            helper(i,grid,connections,visited);
        }

        int ans = 0;
        for(int i:connections){
            if(i!=-1){
                ans++;
            }
        }

        return ans;
    }


    public static  void main(String[] args){
        String s= "Hello %NAME%";
       s = s.replaceAll("%NAME%","Pratik");
        System.out.println(s);
        int[] a= {1,2,3,4,4,4,7,8,9};
        int low = 0;
        int high = a.length-1;
        int target = 4;
        while (low<=high){
            int mid = (high+low)/2;

//            if (a[mid]==target){
//                System.out.println(mid);
//            }
            if (a[mid]<target){
                low = mid+1;
            }else {
                high =mid-1;
            }
        }

        System.out.println(low);
        System.out.println(high);
    }

}
