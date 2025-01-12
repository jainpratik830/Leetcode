package Mission_2025.January.Binary_Search;

public class Median_of_Two_Sorted_Arrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = nums1.length;
        int m = nums1.length;
        int n = nums2.length;
        while (left<=right){

            int mid = left+ (right-left)/2;
            int mid_2 = (m+n+1)/2-mid;


            int a_left = mid == 0 ? Integer.MIN_VALUE : nums1[mid-1];
            int a_right = mid == m ? Integer.MAX_VALUE : nums1[mid];
            int b_left = mid_2 == 0 ? Integer.MIN_VALUE : nums2[mid_2-1];
            int b_right = mid_2 == n? Integer.MAX_VALUE : nums2[mid_2];

            if (a_left<=b_right && b_left<=a_right){
                if (((m+n)%2)==0){
                    return (double) ( Math.max(a_left,b_left)+ Math.min(a_right,b_right))/2.0;
                }else {
                    return Math.max(a_left,b_left);
                }
            }else if (a_left>b_right){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        return 0.0;
    }

}
