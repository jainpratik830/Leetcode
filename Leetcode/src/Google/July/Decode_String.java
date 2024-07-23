package Google.July;

import java.util.Stack;

public class Decode_String {

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int i=0;
        while (i<s.length()){
            // System.out.println(stack);
            if (s.charAt(i)==']'){
                String temp ="";
                while (!stack.isEmpty() && !stack.peek().equals("[")){
                    temp=stack.pop()+temp;
                    // temp.append(stack.pop());
                }
                stack.pop();
                // temp=temp.reverse();
                StringBuilder temp2 = new StringBuilder();
                String count2="";
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
                    count2 = stack.pop()+count2;
                }

                int count = Integer.parseInt(count2);
                for (int k=0;k<count;k++){
                    temp2.append(temp);
                }
                stack.push(temp2.toString());
                i++;

            }else {
                stack.push(s.charAt(i)+"");
                i++;
            }

        }

        String temp ="";
        while (!stack.isEmpty()){
            temp=stack.pop()+temp;
        }


        return temp;
    }

}
