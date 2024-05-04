package Google.May.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Count_of_Smaller_Numbers_After_Self {
    public class Point{

        int value,index;

        public Point(int value,int index){
            this.value = value;
            this.index = index;
        }

    }
    int[] res;
    public List<Integer> countSmaller(int[] nums) {
        res = new int[nums.length];
        List<Integer> result = new ArrayList<>();
        Point[] arr=  new Point[nums.length];
        for (int i=0;i<nums.length;i++){
            arr[i]= new Point(nums[i],i);
        }
        mergeSort(arr,0,nums.length-1);
        for (int i :res){
            result.add(i);
        }
        return result;
    }

    public void mergeSort(Point[] nums,int start,int end){

        if (start>=end){
            return;
        }

        int mid = (start+end)/2;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid+1,end);
        merge(start,mid,mid+1,end,nums);

    }

    public void merge(int startLeft,int endLeft,int startRight,int endRight,Point[] nums){

        int m = endLeft-startLeft+1;
        int n = endRight-startRight+1;
        Point[] temp = new Point[m+n];
        int toAdd = 0;
        int i = startLeft;
        int j= startRight;
        int k=0;
        while (i<m+startLeft && j<n+startRight){

            if (nums[i].value<=nums[j].value){
                res[nums[i].index] += toAdd;
                temp[k++]=nums[i];
                i++;
            }else{
                toAdd++;
                temp[k++]=nums[j];
                j++;
            }

        }

        while (i<m+startLeft){
            res[nums[i].index] += toAdd;
            temp[k++]=nums[i];
            i++;
        }
        while (j<n+startRight){
            temp[k++]=nums[j];
            j++;
        }

        for (int x=0;x<m+n;x++){
            nums[startLeft+x]=temp[x];
        }

    }

    public int binarySearch(int element,List<Integer>  list){
        int low =0;
        int high= list.size()-1;
        int ans = 0;
        while (low<high){
            int mid = (low+high)/2;

            if (list.get(mid)>=element){
                high = mid-1;
                ans = mid;
            }else {
                low = mid+1;
            }

        }

        return ans;
    }



    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i=nums.length-1;i>=0;i--){
            int index = binarySearch(nums[i],temp);
            temp.add(index,nums[i]);
            result.add(index);
        }
        Collections.reverse(result);
        return result;
    }

}
