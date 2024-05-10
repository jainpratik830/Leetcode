package Google.May.CodingRound.BinarySearch;

public class Maximum_Running_Time_of_N_Computers {

    public long maxRunTime(int n, int[] batteries) {
        long start = 1;
        long end = 0;
        for(int e : batteries){
            end+=e;
        }
        while(start<=end){
            long mid = start+(end-start)/2;
            if(isPossible(batteries,n,mid)){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return end;
    }
    public boolean isPossible (int [] batteries,int n,long min){
        int comp = n;
        long rem = 0;
        for(int e : batteries){
            if(e>=min){
                comp--;
                if(comp==0)return true;
            }else{
                rem+=e;
            }
        }
        return rem>=min*comp?true:false;
    }

}
