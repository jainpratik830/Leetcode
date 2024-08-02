package Google.July;

public class Range_Sum_Query_Mutable {


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

        public int query(int index, int start, int end, int left, int right) {

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

        public void update(int index, int val, int indexToUpdate, int left, int right) {

            if (left == right) {
                arr[index] = val;
                return;
            }


            int mid = left + (right - left) / 2;
            if (indexToUpdate <= mid)
                update(2 * index + 1, val, indexToUpdate, left, mid);
            else
                update(2 * index + 2, val, indexToUpdate, mid + 1, right);

            arr[index] = arr[2 * index + 1] + arr[2 * index + 2];
        }

    }

    class NumArray {

        SegmentTree segmentTree;
        int n;
        public NumArray(int[] nums) {
            segmentTree = new SegmentTree(nums.length);

            n= nums.length;
            segmentTree.build(0,nums,0,n-1);
        }

        public void update(int index, int val) {
            segmentTree.update(0,val,index,0,n-1);
        }

        public int sumRange(int left, int right) {
            return segmentTree.query(0,left,right,0,n-1);
        }
    }


}
