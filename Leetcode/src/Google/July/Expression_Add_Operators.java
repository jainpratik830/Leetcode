package Google.July;

import java.util.ArrayList;
import java.util.List;

public class Expression_Add_Operators {
    List<String> ans;
    public int target;
    public String num;

    public void solve(int index,long curr,long prev,long value,ArrayList<String> currList){

        if (index==num.length()){
            if (value==target && curr==0){
                StringBuilder s= new StringBuilder();
                currList.subList(1,currList.size()).forEach(a->s.append(a));
                ans.add(s.toString());
            }
            return;
        }


        curr   = curr*10 + Character.getNumericValue(num.charAt(index));
        String tempStr = String.valueOf(curr);

        if (curr>0 ){
            solve(index+1,curr,prev,value,currList);
        }

        currList.add("+");
        currList.add(tempStr);
        solve(index+1,0,curr,value+curr,currList);
        currList.remove(currList.size()-1);
        currList.remove(currList.size()-1);

        if (currList.size()>=1){
            currList.add("-");
            currList.add(tempStr);
            solve(index+1,0,-curr,value-curr,currList);
            currList.remove(currList.size()-1);
            currList.remove(currList.size()-1);
        }

        if (currList.size()>=1){
            currList.add("*");
            currList.add(tempStr);
            solve(index+1,0,prev*curr,value-prev+prev*curr,currList);
            currList.remove(currList.size()-1);
            currList.remove(currList.size()-1);
        }

    }

    public List<String> addOperators(String num, int target) {


        this.target = target;
        this.num = num;
        this.ans  = new ArrayList<>();
        solve(0,0,0,0,new ArrayList<>());
        return ans;
    }


}
