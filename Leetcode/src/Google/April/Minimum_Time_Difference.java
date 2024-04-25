package Google.April;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Minimum_Time_Difference {

    public int findMinDifference(List<String> timePoints) {
        List<Integer> list = new ArrayList<>();
        for (String s:timePoints){
            int curr = Integer.parseInt(s.split(":")[0])*60+Integer.parseInt(s.split(":")[1]);
            list.add(curr);
        }

        Collections.sort(list);
        int ans =list.get(0)-list.get(list.size()-1)+(24*60);
        for (int i=1;i<list.size();i++){
            ans = Math.min(ans,list.get(i)- list.get(i-1));
        }

        return ans;
    }

}
