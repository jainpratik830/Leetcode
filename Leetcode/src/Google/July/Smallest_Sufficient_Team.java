package Google.July;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Smallest_Sufficient_Team {

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

        int n = req_skills.length;;
        int m= people.size();

        HashMap<String,Integer> map = new HashMap<>();
        for (int i=0;i<n;i++){
            map.put(req_skills[i],i);
        }

        int[] skillPerson = new int[m];
        for (int i = 0; i < m; i ++) {
            int curr =0;
            for (String s:people.get(i)){
                curr |= (1<< map.get(s));
            }
            skillPerson[i]=curr;
        }

        long[] dp = new long[(1<<n)];
        Arrays.fill(dp, (1L << m) - 1);
        dp[0] = 0;
        for (int i=1;i<dp.length;i++){
            int skillMask = i;
            for (int j=0;j<m;j++){
                int reqSkill = skillMask & ~(skillPerson[j]);
                if (reqSkill!=skillMask){
                    long peopleMask = dp[reqSkill] | (1L<<j);

                    if (Long.bitCount(peopleMask)< Long.bitCount(dp[skillMask])){
                        dp[skillMask]=peopleMask;
                    }
                }
            }
        }


        long ansMask = dp[(1<<n)-1];
        int[] ans = new int[Long.bitCount(ansMask)];
        int index =0;
        for (int i=0;i<people.size();i++){
            if (((ansMask>>i)&  1)== 1){
                ans[index++]=i;
            }
        }

        return ans;

    }

}
