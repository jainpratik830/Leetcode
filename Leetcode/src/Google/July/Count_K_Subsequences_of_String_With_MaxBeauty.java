package Google.July;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Count_K_Subsequences_of_String_With_MaxBeauty {

    private long M = 1_000_000_007;

    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        int[] freq = new int[26];
        int n =s.length();
        for (char c:s.toCharArray()){
            freq[c-'a']++;
        }

        TreeMap<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());
        int count =0;
        for (int i:freq){
            if (i!=0){
                map.put(i,map.getOrDefault(i,0)+1);
                count++;
            }

        }

        if (count<k){
            return 0;
        }
        int remaining =k;
        long ans=1;

        for (int f:map.keySet()){
            int num = map.get(f);
            if (remaining>=num){
                ans = ans*power(f,num)%M;
                remaining -= num;
            }else {
                long comb = nCr(num,remaining)%M;
                long power  = (comb*power(f,remaining))%M;
                ans = ans*power%M;
                remaining=0;
            }
            if (remaining==0){
                break;
            }
        }
        return (int) (ans % M);
    }


    public long nCr(long n,long r){

        r = n-r <r ? n-r:r;

        double res  =0;
        for (int i=1;i<=r;i++){
            res += Math.log(n-i+1)-Math.log(i);

        }

        return  Math.round(Math.exp(res))%M;

    }

    public long  power(long  n,long  pow){
        if (pow==0){
            return 1;
        }

        n=n%M;
        if (pow%2==0){
            return power(n*n,pow/2)%M;
        }else {
            return n*power(n*n,pow/2)%M;
        }
    }

}
