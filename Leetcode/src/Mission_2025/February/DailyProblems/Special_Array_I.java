package Mission_2025.February.DailyProblems;

public class Special_Array_I {

    public boolean isArraySpecial(int[] nums) {
        for(int i=1;i< nums.length;i++){
            if (nums[i-1]%2+nums[i]%2!=1){
                return false;
            }
        }
        return true;
    }


}
