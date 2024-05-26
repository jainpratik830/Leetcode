package Google.May.Neetcode150;

public class Two_Sum_II_Input_Array_Is_Sorted {

    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int i=0;
        int j=numbers.length-1;
        while (i<j){
            if (numbers[i]+numbers[j]==target){
                return new int[]{i+1,j+1};
            }
            if (numbers[i]+numbers[j]>target){
                j--;
            }else {
                i++;
            }
        }
        return ans;
    }

}
