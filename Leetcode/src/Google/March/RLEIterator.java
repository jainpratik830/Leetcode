package Google.March;

import java.util.HashMap;

public class RLEIterator {
    int curr ;
    int[] encoding;
    HashMap<Integer,Integer> map;
    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
    }

    public int next(int n) {
        int ans =-1;
        while (curr<encoding.length){
            if (encoding[curr]==0){
                curr+=2;
                continue;
            }else{
                int i= Math.min(n,encoding[curr]);
                n-=i;
                encoding[curr]-=i;

            }

            if (n==0){
                return encoding[curr+1];
            }
            curr+=2;
        }
        return ans;
    }

}
