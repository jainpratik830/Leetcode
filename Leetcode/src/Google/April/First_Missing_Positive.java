package Google.April;

public class First_Missing_Positive {

    public int firstMissingPositive(int[] nums) {
        int[] count = new int[nums.length];
        for (int i:nums){
            if (i<=0 || i>nums.length){
                continue;
            }
            count[i-1]++;
        }

        for (int i=0;i<count.length;i++){
            if (count[i]==0){
                return i+1;
            }
        }

        return count.length+1;
    }

}
