package Google.August;

public class Kth_Smallest_Number_in_Multiplication_Table {

    public boolean isValid(int mid,int m,int n,int k){
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(mid/i,n);
        }

        return count<k;

    }

    public int findKthNumber(int m, int n, int k) {
        int low =1;
        int high = m*n;
        while (low<high){
            int mid = low + (high-low)/2;
            if (isValid(mid,m,n,k)){
                low = mid+1;
            }else {
                high= mid;
            }
        }

        return low;
    }

}
