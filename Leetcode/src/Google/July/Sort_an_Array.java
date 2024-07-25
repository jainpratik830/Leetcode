package Google.July;

public class Sort_an_Array {

    void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int partition(int start,int end,int[] arr){
        int pivot = arr[end];

        int i=start-1;

        for (int j=start;j<=end;j++){
            if (arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        i++;
        swap(arr,i,end);
        return i;
    }

    public void quickSort(int[] nums,int start,int end)
    {
        if (start<=end){

            int partition = partition(start,end,nums);
            quickSort(nums,start,partition-1);
            quickSort(nums,partition+1,end);
        }

        return;
    }
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

}
