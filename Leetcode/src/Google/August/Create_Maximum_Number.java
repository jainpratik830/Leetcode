package Google.August;

import java.util.Arrays;
import java.util.Stack;

public class Create_Maximum_Number {



    public int[] mostCompetitive(int[] nums, int k) {
        int toRemove = nums.length-k;

        Stack<Integer> stack = new Stack<>();

        for (int i:nums){
            while (!stack.isEmpty() && stack.peek()<i && toRemove>0){
                stack.pop();
                toRemove--;
            }
            stack.push(i);
        }

        while (toRemove > 0){
            stack.pop();
            toRemove--;
        }

        int[] ans = stack.stream().mapToInt(i->i).toArray();
        return ans;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        if (j == nums2.length) return true;
        if (i == nums1.length) return false;
        return nums1[i] > nums2[j];
    }

    public int[] merge (int[] a,int[] b){
        int n1 = a.length;
        int n2= b.length;
        int[] ans = new int[n1+n2];
        int i=0;
        int j=0,k=0;
        while (i<n1 && j<n2){

            if (greater(a,i,b,j)){
                ans[k++]=a[i++];
            }else {
                ans[k++]=b[j++];
            }
        }

        while (i<n1){
            ans[k++]=a[i++];
        }

        while (j<n2){
            ans[k++]=b[j++];
        }

        return ans;
    }

    public boolean isGreater(int[] a,int[] b){

        for (int i=0;i<a.length;i++){
            if (a[i]>b[i]){
                return true;
            }else if (a[i]<b[i]){
                return false;
            }
        }

        return false;
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[k];
        Arrays.fill(ans, 0);

        for (int i=0;i<=k;i++){
            int j = k-i;
            if (i<=n1 && j<=n2){
                int[] left = mostCompetitive(nums1,i);
                int[] right =mostCompetitive(nums2,j);
                int[] merge = merge(left,right);
                if (isGreater(merge,ans)){
                    ans = merge;
                }
            }
        }
        return ans;


    }

}
