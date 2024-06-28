package Google.May.Others;

public class Patching_Array {

    public int minPatches(int[] nums, int n) {
        int i=0;
        int miss = 1;
        int patch = 0;

        while (miss<=n){
            if (i<nums.length && miss>=nums[i]){
                miss += nums[i];
                i++;
            }else {
                miss += miss;
                patch++;
            }

        }

        return patch;
    }

}
