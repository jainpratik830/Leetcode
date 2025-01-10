package Mission_2025.January.Two_Pointers;

public class Two_Sum_II_Input_Array_Is_Sorted {

    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0;
        int right = numbers.length-1;
        while (left<right){
            int curr = numbers[left]+numbers[right];
            if (curr==target){
                return new int[]{left+1,right+1};
            }else if (curr<target){
                left++;
            }else {
                right--;
            }
        }

        return ans;
    }

}
