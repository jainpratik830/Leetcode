package Mission_2025.January.Two_Pointers;

public class Container_With_Most_Water {

    public int maxArea(int[] height) {
        int ans =0;
        int left =0;
        int right= height.length-1;

        while (left<right){
            int curr = Math.min(height[left],height[right])*(right-left);
            ans =Math.max(ans,curr);
            if (height[left]<height[right]){
                left++;
            }else if (height[left]>height[right]){
                right--;
            }else {
                left++;
                right--;
            }
        }
        return ans;
    }

}
