package Mission_2025.January.Daily_Problems;

public class Minimum_Number_of_Operations_to_Move_All_Balls_to_Each_Box {

    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];

        int left=0,left_balls=0;
        int right=0,right_balls=0;
        for (int i=0;i<n;i++){

            ans[i]+=left;
            left_balls += Character.getNumericValue(boxes.charAt(i));
            left += left_balls;
        }

        for (int i=n-1;i>=0;i--){

            ans[i]+=right;
            right_balls += Character.getNumericValue(boxes.charAt(i));
            right += right_balls;
        }

        return ans;
    }

    public int[] minOperations2(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];

        for (int i=0;i<n;i++){
            int curr =0;
            for (int j=0;j<n;j++){
                if (i==j)
                    continue;
                if (boxes.charAt(j)!='0')
                    curr += Math.abs(i-j);
            }

            ans[i]=curr;
        }

        return ans;
    }

}
