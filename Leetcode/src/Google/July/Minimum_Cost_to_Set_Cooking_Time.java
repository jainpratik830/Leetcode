package Google.July;

public class Minimum_Cost_to_Set_Cooking_Time {

    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int mins = targetSeconds/60;
        int seconds = targetSeconds%60;
        return Math.min(cost(mins,seconds,moveCost,pushCost,startAt),cost(mins-1,seconds+60,moveCost,pushCost,startAt));
    }

    public int cost(int min,int sec,int move,int push,int start){

        if (sec<0 || sec>99 || min <0 || min >99){
            return Integer.MAX_VALUE;
        }
        int ans=0;
        String s = String.valueOf(min*100+sec);
        char curr =(char) (start+'0');
        for (int i=0;i<s.length();i++){
            if (curr==s.charAt(i)){
                ans+= push;
            }else {
                ans+=push;
                ans+=move;
                curr = (s.charAt(i));
            }
        }

        return ans;

    }

}
