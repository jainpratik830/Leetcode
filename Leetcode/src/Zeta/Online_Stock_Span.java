package Zeta;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Online_Stock_Span {

    class StockSpanner {


        List<Integer> originalList,sortedList;
        Stack<int[]> stack;

        public StockSpanner() {
            originalList = new LinkedList<>();
            sortedList= new LinkedList<>();
            stack = new Stack<>();
        }

        public int next(int price) {
            originalList.add(price);
            int ans =1;
            while (!stack.isEmpty() && stack.peek()[0]<=price){
                ans+= stack.pop()[1];
            }

            stack.add(new int[]{price,ans});
            return ans;
        }
    }


}
