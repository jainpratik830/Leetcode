package Google.March;

import java.util.Arrays;
import java.util.Comparator;

public class The_Earliest_Moment_When_Everyone_Become_Friends {

    static int[] representative;
    static int[]  size;

    public static int find(int x){
        if (representative[x]==x){
            return x;
        }
        return find(representative[x]);
    }

    public static boolean union(int a,int b){
        int x = find(a);
        int y = find(b);
        if (x==y){
            return false;
        }

        if (size[x]>size[y]){
            representative[y]=representative[x];
            size[x]+= size[y];
        }else{
            representative[x]=representative[y];
            size[y]+= size[x];
        }
        return true;
    }
    public static int minTime(int[][] logs, int n) {
        representative = new int[n];
        size= new int[n];
        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));
        for (int i=0;i<n;i++){
            representative[i]=i;
            size[i]=1;
        }

        int ans = -1;
        int count = n;
        for (int[] i:logs){
            if (union(i[1],i[2])){
                count--;
            }
            if (count==1){
                return i[0];
            }
        }


        return ans;
    }

    public static void main(String[] args){
        int[][] a = new int[][]{{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
        System.out.println(minTime(a,6));
    }

}
