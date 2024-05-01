package Google.May;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Smallest_Sufficient_Team {

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int[] ans;
        int m = req_skills.length;
        int n = people.size();
        HashMap<String,Integer> skillId = new HashMap<>();
        for (int i=0;i<req_skills.length;i++){
            skillId.put(req_skills[i],i);
        }

        long dp[] = new long [1 << m];

        Arrays.fill(dp,((1<<n)-1));
        int[] personSkill = new int[n];
        for (int i=0;i<n;i++){
            for (String skill: people.get(i)){
                personSkill[i] |= (1<<skillId.get(skill));
            }
        }
        dp[0] = 0;
        for (int skillMask = 1; (skillMask)<(1<<m);skillMask++) {
            for (int i = 0; i < n; i++) {

                int smallSkillMask = skillMask & ~personSkill[i];

                if (smallSkillMask !=skillMask){
                    long peopleMask  =  dp[smallSkillMask] | (1L<<i);

                    if (Long.bitCount(peopleMask) < Long.bitCount(dp[skillMask])){
                        dp[skillMask]=peopleMask;
                    }

                }


            }
        }

        long ansMask = dp[(1<<m)-1];
        ans = new int[Long.bitCount(ansMask)];
        int index =0;
        for (int i=0;i<people.size();i++){
            if (((ansMask>>i)&  1)== 1){
                ans[index++]=i;
            }
        }




        return ans;
    }

}
