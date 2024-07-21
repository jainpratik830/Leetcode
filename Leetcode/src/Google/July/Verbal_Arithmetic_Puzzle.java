package Google.July;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Verbal_Arithmetic_Puzzle {

    HashMap<Character,Integer> map;
    boolean[] visited= new boolean[10];
    String[] words;
    String result;

    public boolean isSolvable(String[] words, String result) {
        this.words = words;
        map= new HashMap<>();
        this.result= new StringBuilder(result).reverse().toString();
        int maxLength = 0;
        for (int i=0;i< words.length;i++){
            words[i]= new StringBuilder(words[i]).reverse().toString();
            if (words[i].length()>result.length()){
                return false;
            }
            maxLength =Math.max(maxLength,words[i].length());
        }

        if (result.length()-maxLength>1){
            return false;
        }
        return isPossible(0,0,0);

    }

    public boolean isPossible(int row,int col,int sum){

        if (col==result.length()){
            if (sum!=0){
                return false;
            }
            if (result.length()>1 && (map.get(result.charAt(result.length()-1))==0)){
                return false;
            }
            return true;
        }


        if (row== words.length){
            Character curr = result.charAt(col);
            if (map.containsKey(curr)){
                if (map.get(curr)!= sum%10){
                    return false;
                }else {
                    return isPossible(0,col+1,sum/10);
                }
            }else {
                if (visited[sum%10]){
                    return false;
                }
                map.put(curr,sum%10);
                visited[sum%10]=true;
                if (isPossible(0,col+1,sum/10)){
                    return true;
                }
                map.remove(curr);
                visited[sum%10]=false;
                return false;
            }
        }

        if (col>=words[row].length()){
            return isPossible(row+1,col,sum);
        }

        Character curr = words[row].charAt(col);
        if (map.containsKey(curr)){
            if (words[row].length()>1 && col==words[row].length()-1 && map.get(curr)==0){
                return false;
            }
            return isPossible(row+1,col,sum+map.get(curr));
        }else {

            for (int i=0;i<10;i++){
                if (visited[i]){
                    continue;
                }
                if (i==0 && words[row].length()>1 && col==words[row].length()-1){
                    continue;
                }
                visited[i]=true;
                map.put(curr,i);
                if (isPossible(row+1,col,sum+i)){
                    return true;
                }
                map.remove(curr);
                visited[i]=false;
            }

        }

        return false;


    }
}
