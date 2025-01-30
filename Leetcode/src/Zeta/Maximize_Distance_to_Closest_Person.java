package Zeta;

public class Maximize_Distance_to_Closest_Person {

    public int maxDistToClosest(int[] seats) {
        int prev=-1;
        int future= 0;
        int count =0;
        int i=0;
        while (i<seats.length){
            if (seats[i]==1){
                prev=i;
            }else {
                while (i<seats.length && (seats[future]==0 || future<i)){
                    i++;
                }
                int left = (prev==-1)? seats.length : i-prev;
                int right = (future==seats.length) ? seats.length : future-i;
                count= Math.max(count,Math.min(left,right));
            }
        }
        return count;
    }

    public int maxDistToClosest2(int[] seats) {
        int ans = 0;
        int n=seats.length;
        //TRIMMING ZEROES FROM START
        int i = 0;
        while(seats[i]==0) {
            i++;
        }

        //TRIMMING ZEROES FROM END
        int j=n-1;
        while(seats[j]==0) {
            j--;
        }

        ans = Math.max(i,n-j-1);

        int zero = 0;
        for(int p=i;p<=j;p++) {
            if(seats[p] == 1) {
                zero = 0;
            } else {
                zero++;
                ans = Math.max(ans, (zero+1)/2);
            }
        }

        return ans;
    }


}
