package Google.July;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Escape_a_Large_Maze {

    static final int limit= 1000000;
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target)
    {
        Set<String> blocks= new HashSet<>();

        for(int block[] : blocked)
            blocks.add(block[0]+ "-"+ block[1]);//putting the blocked node into the HashSet to access it at O(1)

        return bfsRange(source, target, blocks) && bfsRange(target, source, blocks);//sector division

    }


    public boolean bfsRange(int[] source, int[] target, Set<String> blocks)
    {

        Set<String> visited= new HashSet<>();//visited hash set is so that we dont visit the visited cell again and the access time is O(1)
        Queue<int[]> q= new LinkedList<>();//as we use in  BT

        q.offer(source);//adding the starting BFS node to the Queue

        visited.add(source[0] + "-" + source[1]);//marking it as visited so  that we dont traverse it again
        int level=0;
        int count= 0;//number of node traverse total outside + inside
        while(!q.isEmpty())
        {//r m* w a*
            int temp[]= q.poll();//poling the node
            count+= 1;//counting the number of node traverse

            int trav[][]= {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};//Traversing in 4-Direction

            for(int direction[] : trav)
            {
                int i= temp[0] + direction[0];
                int j= temp[1] + direction[1];

                String key= (i+ "-"+ j);

                if(i < 0 || j < 0 || i >= limit || j >= limit || visited.contains(key) || blocks.contains(key))
                    continue;//base case 1)checking the index 2)We dont visit the blocked node 3) we dont visit the visited node

                if(i == target[0] && j == target[1]) //when we find the target within the boundary(same sector or the quadrand) we just return true //best case saves a lot of time
                    return true;

                visited.add(key);//marking the node as visited and adding it to the Queue

                q.offer(new int[]{i, j});//Expaning the search for path and adding the node

                if(count > 20000) //number of cell, crossing the boundary limit
                    return true;//path exists from this node
            }
        }
        return false;
        //no path, to reach the node//boundary blocked us
    }

}
