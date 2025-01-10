package Google.August;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Count_of_Smaller_Numbers_After_Self {

    public class SegmentTree {
        int n;
        int[] arr;

        public SegmentTree(int size) {
            n = 4 * size + 1;
            arr = new int[n];
        }

        public void build(int index, int[] nums, int left, int right) {
            // System.out.println("left="+left+" right="+right);
            if (left == right) {
                // System.out.println(left);
                arr[index] = nums[left];
                return;
            }

            int mid = left + (right - left) / 2;

            build(2 * index + 1, nums, left, mid);
            build(2 * index + 2, nums, mid + 1, right);

            arr[index] = arr[2 * index + 1] + arr[2 * index + 2];

        }

        public int query(int index, int start,int end,int left, int right) {

            if (start > right || end < left) {
                return 0;
            }

            if (left >= start && right <= end) {
                return arr[index];
            }

//            if (left<= start && right >=end){


            int mid = left + (right - left) / 2;
            int leftQuery = query(2 * index + 1, start, end, left, mid);
            int rightQuery = query(2 * index + 2, start, end, mid + 1, right);
            return leftQuery + rightQuery;
//            }
        }

        public void update(int index,int indexToUpdate, int left, int right) {

            if (left == right) {
                arr[index]++;
                return;
            }


            int mid = left + (right - left) / 2;
            if (indexToUpdate <= mid)
                update(2 * index + 1, indexToUpdate, left, mid);
            else
                update(2 * index + 2, indexToUpdate, mid + 1, right);

            arr[index] = arr[2 * index + 1] + arr[2 * index + 2];
        }

    }


    public List<Integer> countSmaller(int[] nums) {
        int max =10001;
        int n=  2*max;
        SegmentTree segmentTree = new SegmentTree(n);
        List<Integer> ans = new ArrayList<>();
        for (int i=nums.length-1;i>=0;i--){
            ans.add(segmentTree.query(0,1,nums[i]+max-1,0,n));
            segmentTree.update(0,nums[i]+max,0,n);
        }
        Collections.reverse(ans);
        return ans;

    }

}
