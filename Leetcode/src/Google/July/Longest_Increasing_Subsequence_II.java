package Google.July;

import java.util.Arrays;

public class Longest_Increasing_Subsequence_II {

    public class SegmentTree {
        private SegmentTree left, right;
        private int start, end, val;

        SegmentTree(int st, int ed) {
            start = st;
            end = ed;
            if (start != end) {
                int mid = (start + end) / 2;
                left = new SegmentTree(start, mid);
                right = new SegmentTree(mid + 1, end);
                val = Math.max(left.val, right.val);
            }
        }

        private void update(int index, int value) {
            if (index > end || index < start) return;
            if (start == end) {
                val = value;
                return;
            }
            int mid = (start + end) / 2;
            if (index <= mid) {
                left.update(index, value);
            } else {
                right.update(index, value);
            }
            val = Math.max(left.val, right.val);
        }

        private int rangeMaxQuery(int l, int r) {
            if (l > end || r < start) return 0;

            if (l <= start && end <= r) {
                return val;
            }
            return Math.max(left.rangeMaxQuery(l, r), right.rangeMaxQuery(l, r));
        }
    }


    public int lengthOfLIS(int[] nums, int k) {
        SegmentTree root = new SegmentTree(0, 100001);

        int ans =1;
        for( int num : nums){
            int st = num-k;
            int end = num-1;
            int max = root.rangeMaxQuery(st, end);
            ans = Math.max(ans, max+1);

            root.update(num, max+1);

        }

        return ans;

    }
}
