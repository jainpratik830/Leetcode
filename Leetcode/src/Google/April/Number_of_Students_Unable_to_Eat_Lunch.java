package Google.April;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Number_of_Students_Unable_to_Eat_Lunch {

    public int countStudents(int[] students, int[] sandwiches) {
        int ans =0;
        Stack<Integer> stack= new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i=sandwiches.length-1;i>=0;i--){
            stack.push(sandwiches[i]);
            queue.add(students[i]);
        }


        while (!stack.isEmpty()){

            if (stack.isEmpty()){
                return 0;
            }
            int curr_size = stack.size();
            int queue_size= queue.size();
            for (int i=0;i< queue_size;i++){
                if (stack.peek()==queue.peek()){
                    stack.pop();
                    queue.poll();
                }else {
                    queue.add(queue.poll());
                }
            }
            if (curr_size==stack.size()){
                return stack.size();
            }

        }

        return ans;
    }

}
