package Google.July;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RangeModule {

    List<int[]> ranges;


    public RangeModule() {
        ranges = new ArrayList<>();

    }

    public int leftBoundary(int target){
        int low = 0;
        int high = ranges.size()-1;
        int index =-1;

        while (low<=high){
            int mid = low+ (high-low)/2;
            if (ranges.get(mid)[0]==target){
                return mid;
            }else if (ranges.get(mid)[0]<target){
                index =mid;
                low = mid+1;
            }   else {
                high=mid-1;
            }
        }

        return index;
    }

    public void addRange(int left, int right) {
       int index=0;
       int[] interval = { left,right};
       while (index<ranges.size() && ranges.get(index)[0]< interval[0]){
           index++;
       }
       ranges.add(index,interval);
       ArrayList<int[]> temp = new ArrayList<>();
       int j=1;
       int[] first = ranges.get(0);
       int[] curr;
       temp.add(first);
       while (j<ranges.size()){
           curr = temp.get(temp.size()-1);
           if (j<ranges.size() && ranges.get(j)[0]<=curr[1]){
               curr[1] = Math.max(curr[1],ranges.get(j)[1]);
           }else {
               temp.add(ranges.get(j));
           }
           j++;
       }

       ranges =temp;

    }

    public boolean queryRange(int left, int right) {
        int l = leftBoundary(left);

        if (l>=0 && l<ranges.size() &&  ranges.get(l)[0]<=left && ranges.get(l)[1]>=right){
            return true;
        }
        return false;
    }

    public void removeRange(int left, int right) {
        ArrayList<int[]> temp = new ArrayList<>();
        for (int i=0;i<ranges.size();i++){
            int[] curr =ranges.get(i);
            if (curr[1]<= left || curr[0]>=right){
                temp.add(curr);
            }else if (curr[0]<left && curr[1]>right){
                temp.add(new int[]{curr[0],left});
                temp.add(new int[]{right,curr[1]});
            }else if (curr[0]<left){
                temp.add(new int[]{curr[0],Math.min(curr[1],left)});
            }else if (curr[1]>right){
                temp.add(new int[]{Math.max(right, curr[0]),curr[1]});
            }
        }
        ranges= temp;
    }


}
