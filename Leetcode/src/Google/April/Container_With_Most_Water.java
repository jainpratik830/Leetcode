package Google.April;

public class Container_With_Most_Water {

    public int maxArea(int[] height) {
        int area = 0;
        int left =0;
        int right = height.length-1;
        while(left<right){
            int w = right - left;
            int currH = Math.min(height[left],height[right]);
            area = Math.max(area,w*currH);
            if(height[left]<height[right]){
                left++;
            }
            else if(height[left]>height[right]){
                right--;
            }else{
                left++;
                right--;
            }
        }

        return area;
    }

}
