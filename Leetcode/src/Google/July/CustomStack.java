package Google.July;

public class CustomStack {

    int maxSize;
    int curr;
    int[] arr;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.curr=0;
        arr= new int[maxSize];
    }

    public void push(int x) {
        if(curr>=maxSize){
            return;
        }
        arr[curr]=x;
        curr++;
    }

    public int pop() {
        if (curr==0){
            return -1;
        }
        return arr[--curr];
    }

    public void increment(int k, int val) {
        for (int i=0;i<Math.min(k,curr);i++){
            arr[i]+=val;
        }
    }

}
