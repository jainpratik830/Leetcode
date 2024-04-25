package Google.April;

public class Median_of_Two_Sorted_Arrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double ans = 0.0;
        if (nums1.length >nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0;
        int high = n1;
        int total = n1+n2;

        while (low<=high){
            int a_left = (low+high)/2;
            int b_left = (total + 1)/2-a_left;
            int a_1 = (a_left==0) ? Integer.MIN_VALUE : nums1[a_left-1];

            int b_1 = (b_left==0) ? Integer.MIN_VALUE : nums2[b_left-1];
            int a_2 = (a_left==n1) ? Integer.MAX_VALUE : nums1[a_left];
            int b_2 = (b_left==n2) ? Integer.MAX_VALUE : nums2[b_left];

            if (a_1<=b_2 && a_2>=b_1){
                if (total%2==0){
                    return (Math.max(a_1,b_1)+Math.min(a_2,b_2))/2.0;
                }else {
                    return (double) Math.max(a_1,b_1);
                }
            }

            if (a_1>b_2){
                high = a_left-1;
            }
            if (a_2<b_1){
                low = a_left+1;
            }
        }


        return ans;
    }


}
