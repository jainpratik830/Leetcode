package Google.July;

import java.util.*;

public class Robot_Collisions {

    public class Robot {

        int position,index,health;
        char direction;


        public Robot(int position, int index, int health, char direction) {
            this.position = position;
            this.index = index;
            this.health = health;
            this.direction = direction;
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "position=" + position +
                    ", index=" + index +
                    ", health=" + health +
                    ", direction=" + direction +
                    '}';
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> ans = new ArrayList<>();

        List<Robot> robotList = new ArrayList<>();
        for (int i=0;i<positions.length;i++){
            Robot robot = new Robot(positions[i],i,healths[i],directions.charAt(i));
            robotList.add(robot);
        }

        Collections.sort(robotList, Comparator.comparingInt(a-> a.position));
        Stack<Robot> stack = new Stack<>();
        for (Robot robot:robotList){
            stack.add(robot);

            while (stack.size()>=2 ) {
                Robot curr = stack.pop();
                Robot curr2 = stack.pop();
                if ((curr.position == curr2.position || (curr.direction == 'R' && curr2.direction == 'L' && curr.position < curr2.position) || (curr.direction == 'L' && curr2.direction == 'R' && curr.position > curr2.position))) {
                    if (curr.health == curr2.health) {
                        continue;
                    } else {
                        if (curr.health > curr2.health) {

                            stack.push(new Robot(curr.position, curr.index, curr.health - 1, curr.direction));
                        } else {
                            stack.push(new Robot(curr2.position,curr2.index,curr2.health-1, curr2.direction));
                        }
                    }
                }else {
                    stack.push(curr2);
                    stack.push(curr);
                    break;
                }
            }
        }
        List<Robot> robotList2=new ArrayList<>();
        for (Robot r:stack){
            robotList2.add(r);
        }
        Collections.sort(robotList2,Comparator.comparingInt(a->a.index));
        for (Robot robot:robotList2){
            ans.add(robot.health);
        }

        return ans;
    }

}
