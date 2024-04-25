package Google.April;

import java.util.ArrayList;
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
        Point[] list = new Point[nums.length];
        List<Integer> ans = new ArrayList<>();
        res = new int[nums.length];

        for (int i=0;i<nums.length;i++){
            list[i]=(new Point(nums[i],i));
        }

        List<Integer> result = new ArrayList<>(res.length);
        mergeSort(list, 0, nums.length-1);
        for(int x=0; x<list.length; x++)
        {
            result.add(res[x]);
        }
        return result;
    }

    public void mergeSort(Point[] arr,int i,int j){
        if (i>=j){
            return;
        }
        int m = i+ (j-i)/2;
        mergeSort(arr,i,m);
        mergeSort(arr,m+1,j);
        merge(i,m,m+1,j,arr);
    }

    public void merge(int startLeft,int endLeft,int startRight, int endRight,Point[] arr){
        int m = endLeft-startLeft+1;
        int n = endRight-startRight+1;
        Point[] temp = new Point[m+n];
        int k=0;
        int i=0;
        int j=0;
        int toAdd  = 0;
        while (i<m && j<n){
            if (arr[startLeft+i].value <= arr[startRight+j].value){
                res[arr[startLeft+i].index]+=toAdd;
                temp[k++]=arr[startLeft+i];
                i++;
            }else{
                temp[k++]=arr[startRight+j];
                toAdd++;
                j++;
            }
        }
        while (i<m){
            res[arr[startLeft+i].index]+=toAdd;
            temp[k++]=arr[startLeft+i];
            i++;
        }
        while (j<n){
            temp[k++]=arr[startRight+j];
            toAdd++;
            j++;
        }
        for (int x=0;x<m+n;x++){
            arr[startLeft+x]=temp[x];
        }
    }
}
