package Zeta;

import java.util.Random;

public class Car_Pooling {

    public boolean carPooling(int[][] trips, int capacity) {
        int max= 1000;
        int[] arr = new int[max+1];
        for (int i=0;i<trips.length;i++){
            arr[trips[i][1]] += trips[i][0];
            arr[trips[i][2]] -= trips[i][0];
        }

        int count =0;
        for (int i=0;i<=max;i++){
            count += arr[i];
            if (capacity<count){
                return false;
            }
        }
        Random random= new Random();
        random.nextInt(100);

        int x=(int) Math.random()*100;
        return true;

    }

}
