package Google.April;

import java.util.Stack;

public class Simplify_Path {

    public static String simplifyPath(String path) {
        Stack<String> stack =new Stack<>();
        String ans = "";
        path =path.replaceAll("//","/");
        for(String curr : path.split("/")){
            if (!curr.isEmpty() && (!curr.equals("..") && !curr.equals("."))){
                stack.add(curr);
            }else if (curr.equals("..")){
                if (stack.isEmpty()){
                    continue;
                }else {
                    stack.pop();
                }

            }

        }

        if (stack.isEmpty()){
            return "/";
        }
        // System.out.println(stack);
        while (!stack.isEmpty()){
            ans = "/"+stack.pop()+ ans;
        }


//        System.out.println(ans);
        return ans.toString();
    }

    public static void main(String[] args){
        String curr = "/home/../test/tes1.txt";
        simplifyPath(curr);
    }

}
