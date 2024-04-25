package Google.April;

public class Trapping_Rain_Water {

    public int trap(int[] height) {
        int ans =0;
        int n=height.length;
        int[] left = new int[n];
        int[] right= new int[n];
        left[0]=height[0];
        right[n-1]=height[n-1];
        for (int i=1;i<n;i++){
            left[i] = Math.max(height[i],left[i-1]);
            right[n-1-i]= Math.max(height[n-1-i],right[n-i]);
        }

        for (int i=1;i<n;i++){
            ans+=Math.min(left[i],right[i])-height[i];
        }
        return ans;
    }


}
