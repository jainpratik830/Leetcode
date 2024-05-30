package Google.May.Others;

public class Get_Equal_Substrings_Within_Budget {

    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();

        int[] cost = new int[n];

        for (int i=0;i<n;i++){
            cost[i]=Math.abs(s.charAt(i)-t.charAt(i));

        }

        int low = 0;
        int high = 0;
        int ans =0;
        int curr = 0;
        while (high<n && low<=high){
            curr+=cost[high];
            while (curr>maxCost){

                curr-=cost[low++];
            }

            ans = Math.max(ans,high-low+1);
            high++;

        }

        return ans;
    }

}
