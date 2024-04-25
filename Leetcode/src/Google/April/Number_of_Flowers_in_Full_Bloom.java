package Google.April;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Number_of_Flowers_in_Full_Bloom {


    public int[] fullBloomFlowers2(int[][] flowers, int[] people) {
        int[] ans = new int[people.length];
        List<Integer> startTime = new ArrayList<>();
        List<Integer> endTime = new ArrayList<>();
        for (int[] i:flowers){
            startTime.add(i[0]);
            endTime.add(i[1]+1);
        }

        Collections.sort(startTime);
        Collections.sort(endTime);
        // System.out.println(startTime);
        // System.out.println(endTime);
        for (int i=0;i<people.length;i++){
            int s= binarySearch(startTime,people[i]);
            int e = binarySearch(endTime,people[i]);
            ans[i] = s-e > 0 ? s-e : 0;
        }


        return ans;
    }

    public int binarySearch(List<Integer> list,int target){

        int left = 0;
        int right = list.size();
        while (left<right){

            int mid  = left+(right-left)/2;
            if (list.get(mid)>target){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return left;

    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] ans = new int[people.length];

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int[] flower : flowers){
            map.putIfAbsent(flower[0],new ArrayList<>());
            map.get(flower[0]).add(flower[1]);
        }
        System.out.println(map);
        int index=0;
        for (int i: people){
            for (int j: map.headMap(i,true).keySet()){
                for (int k: map.get(j)){
                    if (k>=i){
                        ans[index]++;
                    }
                }
            }
            index++;
        }


        return ans;
    }

}
