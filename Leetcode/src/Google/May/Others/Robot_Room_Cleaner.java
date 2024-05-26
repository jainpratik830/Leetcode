package Google.May.Others;

import java.util.HashSet;
import java.util.Set;

public class Robot_Room_Cleaner {


    interface Robot {
      // Returns true if the cell in front is open and robot moves into the cell.
              // Returns false if the cell in front is blocked and robot stays in the current cell.
              public boolean move();
 
              // Robot will stay in the same cell after calling turnLeft/turnRight.
              // Each turn will be 90 degrees.
              public void turnLeft();
      public void turnRight();
 
              // Clean the current cell.
              public void clean();
  }

  int[][] directions= {{0,1},{1,0},{0,-1},{-1,0}};
    Set<String> visited;
    public void turnBack(Robot robot){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    public void dfs(Robot robot ,int curr_x,int curr_y,int direction){
        visited.add(curr_x+","+curr_y);
        robot.clean();
        for (int i=0;i<4;i++){
            int new_direction = (direction+i)%4;
            int new_x = curr_x+directions[new_direction][0];
            int new_y = curr_y+directions[new_direction][1];

            if (!visited.contains(new_x+","+new_y) && robot.move() ){
                dfs(robot,new_x,new_y,new_direction);
                turnBack(robot);
            }
            robot.turnRight();

        }

    }


    public void cleanRoom(Robot robot) {
        visited = new HashSet<>();
        dfs(robot,0,0,0);
    }
}
