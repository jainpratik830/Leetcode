package Zeta;

import java.util.Arrays;

public class Tower {

    public static int number_of_tower(int house[], int range, int n) {
        int ans =0;
        int last_tower =-1;
        Arrays.sort(house);
        for (int i=0;i<n;i++){
            if (last_tower==-1 && i==0 ){
                int last=  house[i];
                last_tower= last+range;
                ans++;
                System.out.println(last_tower);
            }else {
                if (Math.abs(house[i]-last_tower)<=range){
                    System.out.println("Skinpping "+house[i]);
                    continue;
                }else {
                    last_tower=  house[i]+range;
                    System.out.println(last_tower);
                    ans++;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args){
        int[] n = new int[]{1,2,3,4,5};
        int[] n2 = new int[]{10, 15, 20, 25, 30, 35};
        int range2 = 5;
        int size2= n2.length;
        int range= 1;
        int size = n.length;
//        System.out.println(number_of_tower(n,range,size));
        System.out.println(number_of_tower(n2,range2,size2));
    }
}
