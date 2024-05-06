package Google.May.Array;

public class Frog_Jump {

    Boolean[][] dp;

    public boolean helper(int curr,int[] stones,int k){




        if (curr<0 || curr>stones.length-1){
            return false;
        }



        if (curr==stones.length-1){
            // System.out.println("curr="+curr+" k="+k);
            // System.out.println("here1");
            return true;
        }

        if (dp[curr][k] !=null){

            return dp[curr][k];
        }

        boolean possible = false;


        if(k>0){
            int kthJump = binarySearch(stones[curr]+k,curr,stones);
            if (kthJump!=-1){
                possible = possible || helper(kthJump,stones, k);
                if (possible){
                    // System.out.println("curr="+kthJump+" k="+k);
                    // System.out.println("here2");
                    return dp[curr][k]=true;
                }
            }
        }


        int kPlusthJump = binarySearch(stones[curr]+k+1,curr,stones);
        if (kPlusthJump!=-1){
            possible = possible || helper(kPlusthJump,stones, k+1);
            if (possible){
                // System.out.println("curr="+kPlusthJump+" k="+(k+1));
                // System.out.println("here3");
                return dp[curr][k]=true;
            }
        }

        if(k-1>0){
            int kMinusthJump = binarySearch(stones[curr]+k-1,curr,stones);
            if (kMinusthJump!=-1){
                possible = possible || helper(kMinusthJump,stones, k-1);
                if (possible){
                    // System.out.println("curr="+kMinusthJump+" k="+(k-1));
                    // System.out.println("here4");
                    return dp[curr][k]=true;
                }
            }
        }



        return dp[curr][k]= possible;
    }

    public boolean canCross(int[] stones) {

        dp = new Boolean[2001][2001];
        if(stones[1]-stones[0]>1){
            return false;
        }


        return helper(0,stones,0);
    }

    public int binarySearch(int target,int i,int[] nums){

        int low = i;
        int high = nums.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if (nums[mid]==target){
                return mid;
            }

            if (nums[mid]>target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }

}
