package Zeta;

import java.util.Stack;

public class MinimizeString {

    /*
    I was asked a question about strings. I was given a string consisting only of A's and B's, and my task was to minimize the string by deleting occurrences of AA or BB. I needed to do this in as few moves as possible, but I don't remember the exact question.
input = AABABBA
output would be "B" as we first remove the AA then we will remove BB which will make the string as BAA and the we can remove AA from the string and the total number of deletion would be 3.
     */

    public static int minimizeString(String input) {
        Stack<Character> stack= new Stack<>();
        int i=0;
        int count = 0;
        while (i<input.length()){
            if (!stack.isEmpty() && stack.peek()==input.charAt(i)){
                stack.pop();
                count++;
            }else {
                stack.push(input.charAt(i));
            }
            i++;
        }

        StringBuilder remainingString = new StringBuilder();
        while (!stack.isEmpty()) {
            remainingString.append(stack.pop());
        }
        System.out.println("Remaining string: " + remainingString.reverse().toString());
        return count;
    }
}
