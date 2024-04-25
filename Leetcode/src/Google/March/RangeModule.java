package Google.March;

import java.util.ArrayList;

public class RangeModule {




    ArrayList<int[]> list ;



    public RangeModule() {
        list = new ArrayList<int[]>();
    }

    public int findLeftBoundaryIndex(int target) {
        int low = 0, high = list.size() - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid)[0] == target) {
                return mid;
            } else if (list.get(mid)[0] < target) {
                index = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }


    public void addRange(int left, int right) {

        int[] newInterval = { left, right };
        int index = 0;
        while (index < list.size() && list.get(index)[0] < newInterval[0]) {
            index++;
        }
        list.add(index,newInterval);

        ArrayList<int[]> temp = new ArrayList<>();
        int j=1;
        int[] first = list.get(0);
        int[] curr;
        temp.add(first);
        while (j<list.size()){
            curr = temp.get(temp.size()-1);
            if(j<list.size() && curr[1]>=list.get(j)[0]){
                curr[1]=Math.max(curr[1],list.get(j)[1]);
            }else{
                temp.add(list.get(j));
            }
            j++;
        }
        this.list= temp;
    }

    public boolean queryRange(int left, int right) {
        int l= findLeftBoundaryIndex(left);
        if (l>=0 && l<list.size() && list.get(l)[0]<=left && list.get(l)[1]>=right){
            return true;
        }
        return false;
    }

    public void removeRange(int left, int right) {
        ArrayList<int[]> temp = new ArrayList<>();
        for (int[] i:list){
            if (i[1] <= left || i[0] >= right) {
                temp.add(i);
            }else if (i[0]<left && i[1]>right){
                temp.add(new int[]{i[0],left});
                temp.add(new int[]{right,i[1]});
            }else if(i[0]<left){
                temp.add(new int[]{i[0],Math.min(i[1],left)});
            }else if (right<i[1]){
                temp.add(new int[]{Math.max(i[0], right),i[1]});
            }
        }

        list= temp;
    }
}
