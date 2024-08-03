package Google.August;

public class Next_Greater_Element_III {

    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int i=arr.length-2;

        while (i>=0 && arr[i]>=arr[i+1]){
            i--;
        }

        if (i<0){
            return -1;
        }

        int j=arr.length-1;
        while (j>=0 && arr[j]<=arr[i]){
            j--;
        }

        swap(arr,i,j);
        reverse(arr,i+1,arr.length-1);

        try {
            return Integer.parseInt(new String(arr));
        }catch (Exception e){
            return -1;
        }

    }

    public void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public void reverse(char[] arr,int start,int end){
        while (start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }


}
