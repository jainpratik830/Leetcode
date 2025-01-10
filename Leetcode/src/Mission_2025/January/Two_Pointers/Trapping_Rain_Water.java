package Mission_2025.January.Two_Pointers;

public class Trapping_Rain_Water {


    public int trap(int[] height) {
        int ans =0;
        int n =height.length;
        int left_max = height[0];
        int i=0;
        int j=n-1;
        int right_max = height[j];

        while (i<j){

            if (left_max<right_max){
                ans += left_max-height[i];
                i++;
                left_max= Math.max(left_max,height[i]);

            }else {
                ans += right_max-height[j];
                j--;
                right_max= Math.max(right_max,height[j]);
            }

        }

        return ans;
    }

    public int trap2(int[] height) {
        int ans =0;
        int n =height.length;
        int[] left = new int[n+2];
        int[] right = new int[n+2];
        left[0]=0;
        left[n+1]=0;
        right[0]=0;
        right[n+1]=0;
        for (int i=1;i<=n;i++){
            left[i] =Math.max(left[i-1],height[i-1]);
            right[n+1-i]=Math.max(height[n-i],right[n+2-i]);
        }

        for (int i=1;i<=n;i++){
            ans += Math.min(left[i],right[i])-height[i-1];
        }
        return ans;
    }

}
