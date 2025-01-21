package Mission_2025.January.Daily_Problems;

public class Neighboring_Bitwise_XOR {

    public boolean doesValidArrayExist(int[] derived) {
        int ans =0;
        for (int i:derived){
            ans = ans ^ i;
        }

        return ans==0;
    }

}
