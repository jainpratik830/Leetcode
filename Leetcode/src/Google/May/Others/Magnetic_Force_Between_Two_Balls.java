package Google.May.Others;

import java.util.Arrays;

public class Magnetic_Force_Between_Two_Balls {

    public boolean canBePlaced(int x,int[] position,int m){
        int lastPlaced = position[0];
        int placed = 1;

        for (int i=1;i<position.length && placed<m;i++){
            int curr = position[i];

            if (curr-lastPlaced >=x){
                lastPlaced = curr;
                placed++;
            }
        }

        return placed==m;
    }


    public int maxDistance(int[] position, int m) {
        int ans  =0;
        int n = position.length;
        Arrays.sort(position);
        int low = 0;
        int high =  (int) Math.ceil(position[n - 1] / (m - 1.0));

        while (low<=high){
            int mid = (high+low)/2;

            if (canBePlaced(mid,position,m)){
                ans = mid;
                low=mid+1;
            }else {
                high= mid-1;
            }


        }


        return ans;
    }

}
