package Google.May.Array;

public class Trapping_Rain_Water {

    public int trap(int[] height) {

        int[] left =new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        right[height.length-1]= height[height.length-1];
        for (int i=1;i<height.length;i++){
            left[i] = Math.max(height[i],left[i-1]);
            right[height.length-1-i]= Math.max(height[height.length-1-i],right[height.length-i]);
        }

        int ans =0;
        for (int i=0;i<height.length;i++){
            ans += Math.min(left[i],right[i])-height[i];
        }

        return ans;

    }

}
