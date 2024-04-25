package Google.April;

public class Capacity_To_Ship_Packages_Within_D_Days {

    public int shipWithinDays(int[] weights, int days) {
        int ans =0;
        int min = Integer.MIN_VALUE;
        int max = 0;

        for (int i:weights){
            min = Math.max(i,min);
            max +=i;
        }


        int mid= 0;
        while (min<max){
            mid = min + (max-min)/2;
            int day = calcDays(weights,mid);
            if (day>days){
                min  = mid+1;
            }else{
                max = mid;
            }
        }

        return min;

    }

    public int calcDays(int[] weights,int i){
        int curr = 0;
        int sum = 0;
        for (int j=0;j<weights.length;j++){
            sum+=weights[j];
            // System.out.println(sum);
            if (sum>i){
                curr++;
                sum= weights[j];
            }

        }
        return curr+1;
    }

}
