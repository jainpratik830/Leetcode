package Google.July;

public class Get_the_Maximum_Score {

    public int maxSum(int[] nums1, int[] nums2) {
        int mod = (int)1e9+7;

        int i=0, j=0;
        long sum1=0, sum2=0;
        int n = nums1.length, m = nums2.length;


        while(i<n && j<m){
            if(nums1[i] < nums2[j]){
                sum1 += nums1[i++];
            }
            else if(nums1[i] > nums2[j]){
                sum2 += nums2[j++];
            }
            else{
                sum1 = sum2 = Math.max(sum1, sum2) + nums1[i];
                i++;
                j++;
            }

        }

        while(i<n){
            sum1 += nums1[i++];
        }

        while(j<m){
            sum2 += nums2[j++];
        }

        return (int)(Math.max(sum1, sum2) % mod);
    }


}
