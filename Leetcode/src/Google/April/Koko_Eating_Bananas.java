package Google.April;

public class Koko_Eating_Bananas {

    public int minEatingSpeed(int[] piles, int h) {
        int ans =0;
        int max = Integer.MIN_VALUE;
        int min = 1;

        for (int i:piles){
            max = Math.max(i,max);
            // max +=i;
        }


        int mid= 0;
        while (min<max){
            mid = min + (max-min)/2;
            int day = calcSplits(piles,mid);
            if (day>h){
                min  = mid+1;
            }else{
                max = mid;
            }
        }

        return min;
    }


    public int calcSplits(int[] weights,int i){
        int curr = 0;
        int sum = 0;
        for (int j=0;j<weights.length;j++){
            sum+=Math.ceil((weights[j]*1.0)/i);
        }
        return sum;
    }

}
