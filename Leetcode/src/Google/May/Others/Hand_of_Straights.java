package Google.May.Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand_of_Straights {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if (n%groupSize!=0){
            return false;
        }else {
            int count = n/groupSize;
            List<Integer>[] groups = new ArrayList[count];
            for (int i=0;i<count;i++){
                groups[i]=new ArrayList<>();
            }

            Arrays.sort(hand);
            int curr =0;
            int i=0;
            while (i<n){
                while (groups[curr].size()==groupSize){
                    curr++;
                }
                if (groups[curr].size()==0 || groups[curr].get(groups[curr].size()-1)==hand[i]-1){

                    groups[curr].add(hand[i]);
                    i++;
                }else if (groups[curr].get(groups[curr].size()-1)==hand[i]){
                    curr++;

                }else {
                    return false;
                }

                curr=curr%count;
            }

            return true;
        }

    }

}
