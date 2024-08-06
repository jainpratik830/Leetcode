package Google.August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Russian_Doll_Envelopes {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)->{
            // if (a[0]==b[0]){
            //     return a[1]-b[1];
            // }
            return a[0]-b[0];
        });
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }
        List<Integer> list= new ArrayList<>();

        list.add(heights[0]);
        for (int i=1;i<heights.length;i++){
            int curr = list.get(list.size()-1);
            if (heights[i]>curr ){
                list.add(heights[i]);
            }else {
                int index = binarySearch(list,heights[i]);
                // if(index == list.size()){
                //     list.add(heights[i]);
                // }else{
                list.set(index,heights[i]);
                // }

            }


        }

        return list.size();
    }

    public int binarySearch(List<Integer> list,int target){

        int start = 0;
        int end = list.size()-1;
        int ans = list.size();
        while (start<=end){

            int mid = start + (end-start)/2;
            int curr = list.get(mid);
            if (target>curr){
                start = mid+1;
            }else {
                ans = mid;
                end= mid-1;
            }

        }
        return ans;

    }
}
