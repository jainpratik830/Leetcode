package Interview;

import java.util.Arrays;

public class Solution {

    /*
    n ballons 0-> n-1
    [5,3,.....]
    [5,3,1]
    burst 5->
    burst -> 3-> 15 [5,1] -> 5 =20 -> [1] =21

    coins = (i-1)*(i)*(i+1)

     */
//    static int total_ballons;

    public static int helper(int[] ballons,boolean[] bursted,int burst_count){

        if (burst_count==0){
            return 0;
        }

        int ans =0;

        for (int i=1;i<ballons.length-1;i++){
            if (!bursted[i]){
                bursted[i]=true;
                int left = i-1;
                int right = i+1;
                while (bursted[left]){
                    left--;
                }
                while (bursted[right]){
                    right++;
                }
                ans = Math.max(ans,ballons[left] *ballons[i]*ballons[right]+helper(ballons,bursted,burst_count-1));
                bursted[i]=false;
            }
        }

        return ans;
    }

    public static int getMaxScore(int[] ballons){
        int n= ballons.length;
        int to_burst = n;
        int[] new_ballons = new int[n+2];
        for (int i=1;i<=n;i++){
            new_ballons[i]=ballons[i-1];
        }
        new_ballons[0]=1;
        new_ballons[n+1]=1;
//        System.out.println(Arrays.toString(new_ballons));
        return helper(new_ballons,new boolean[n+2],to_burst);
    }

    public static void main(String[] args){
        int[] ballons = new int[]{3,1,5,8};
        System.out.print(getMaxScore(ballons));
    }

}

