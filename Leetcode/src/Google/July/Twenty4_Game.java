package Google.July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Twenty4_Game {

    public List<Double> generatePossible(double a,double b){
        List<Double> res =new ArrayList<>();
        res.add(a+b);
        res.add(a*b);
        res.add(a-b);
        res.add(b-a);
        if (b!=0){
            res.add(a/b);
        }

        if (a!=0){
            res.add(b/a);
        }
        return res;
    }

    public boolean check(List<Double> list){

        if (list.size()==1){
            if (Math.abs(list.get(0) - 24)-24<0.1){
                return true;
            }
            return false;
        }

        for (int i=0;i<list.size();i++){
            for (int j=1+i;j<list.size();j++){
                List<Double> newList = new ArrayList<>();
                for (int k=0;k<list.size();k++){
                    if (k!=i && k!=j){
                        newList.add(list.get(k));
                    }
                }

                List<Double> generated  = generatePossible(list.get(i),list.get(j));
                for (double k:generated){
                    newList.add(k);
                    if (check(newList)){
                        return true;
                    }
                    newList.remove(newList.size()-1);
                }
            }
        }

        return false;

    }

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int i:cards){
            list.add((double) i);
        }

        return check(list);
    }

}
