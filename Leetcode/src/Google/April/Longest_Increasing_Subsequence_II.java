package Google.April;

public class Longest_Increasing_Subsequence_II {

    static class SegmentTree {
        private int n;
        private int[] st;
        public SegmentTree(int n){
            this.n=n;
            st = new int[4*n+1];
        }

        public void update(int idx,int val){
            update(0,n-1,idx,val,0);
        }

        public void update(int stLeft,int stRight,int idx,int val,int stIdx){

            if (idx<stLeft || idx>stRight){
                return;
            }

            st[stIdx] = Math.max(st[stIdx],val);

            if (stLeft!=stRight){
                int mid = stLeft+ (stRight-stLeft)/2;
                update(stLeft,mid,idx,val,2*stIdx+1);
                update(mid+1,stRight,idx,val,2*stIdx+2);
            }
        }

        public int queryMax(int left,int right){
            return queryMax(0,n-1,left,right,0);
        }

        public int queryMax(int start,int end,int left,int right,int stIdx){

            if (right<start || left>end){
                return Integer.MIN_VALUE;
            }

            if (start>=left && end<=right){
                return st[stIdx];
            }

            int mid = start+ (end-start)/2;
            return Math.max(queryMax(start,mid,left,right,2*stIdx+1),queryMax(mid+1,end,left,right,2*stIdx+2));

        }

    }


    public int lengthOfLIS(int[] nums, int k) {

        int ans = 1;
        int max = 0;
        for (int n:nums){
            max = Math.max(n,max);
        }

        SegmentTree root = new SegmentTree(max+1);


        for (int i=0;i<nums.length;i++)
        {
            int left = Math.max(nums[i]-k,0);
            int right = nums[i]-1;
            int currMax = 1+ root.queryMax(left,right);
            root.update(nums[i],currMax);
            ans = Math.max(ans,currMax);
        }
        return ans;

    }


}
