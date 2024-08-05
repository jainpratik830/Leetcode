package Google.August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Push_Dominoes {

    public String pushDominoes(String dominoes) {
        int n =dominoes.length();
        StringBuilder ans = new StringBuilder();
        dominoes = "L"+dominoes+"R";
        System.out.println(dominoes);
        List<Character> list = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        for (int i=0;i<n+2;i++){
            if (dominoes.charAt(i)!='.'){
                list.add(dominoes.charAt(i));
                index.add(i);
                // System.out.println(Arrays.toString(new String[]{dominoes.charAt(i)+"",String.valueOf(i)}));
            }
        }

        for (int i=0;i<list.size()-1;i++){
            char left = list.get(i);
            char right = list.get(i+1);
            int leftIndex= index.get(i);
            int rightIndex= index.get(i+1);
            // System.out.println("LR");
            // System.out.println(Arrays.toString(left));
            // System.out.println(Arrays.toString(right));
            if (left==right){
                for (int j=0;j<rightIndex-leftIndex;j++){
                    ans.append(left);
                }
            }else if(left>right){
                // System.out.println(Integer.parseInt(left[1]));
                // System.out.println(Integer.parseInt(right[1]));
                for (int j=leftIndex;j<=rightIndex;j++){
                    // Sys
                    if (j-leftIndex>rightIndex-j){
                        ans.append("L");
                    }else if (j-leftIndex<rightIndex-j){
                        ans.append("R");
                    }else {
                        ans.append(".");
                    }
                }
            }else {
                for (int j=0;j<rightIndex-leftIndex-1;j++){
                    ans.append(".");
                }
            }
        }


        return ans.toString();
    }

}
