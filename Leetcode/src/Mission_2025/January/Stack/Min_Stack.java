package Mission_2025.January.Stack;

import java.util.Stack;

public class Min_Stack {

    class MinStack{

        Stack<Integer> stack;
        int min;

        public MinStack(){
            stack= new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int val){
            if (stack.isEmpty()){
                stack.push(val);
                min = val;
                stack.push(val);
            }else {
                if (val<=min){
                    stack.push(min);
                    min = val;
                }
                stack.push(val);
            }
        }

        public void pop(){
           if (stack.pop()==min){
               min =stack.pop();
           }
        }

        public int top(){
            return stack.peek();
        }

        public int getMin(){
            return min;
        }

    }


    class MinStack2{

        Stack<Integer> stack, minEle;

        public MinStack2(){
            stack= new Stack<>();
            minEle = new Stack<>();
        }

        public void push(int val){
            if (stack.isEmpty()){
                stack.push(val);
                minEle.push(val);
            }else {
                stack.push(val);
                minEle.push(Math.min(minEle.peek(),val));
            }
        }

        public void pop(){
            stack.pop();
            minEle.pop();
        }

        public int top(){
            return stack.peek();
        }

        public int getMin(){
            return minEle.peek();
        }

    }

}
