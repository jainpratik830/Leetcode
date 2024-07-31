package Google.July;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Stickers_to_Spell_Word {

    HashMap<String,Integer> dp;
    public int dfs(String target,List<HashMap<Character,Integer>> stickerList){

        if (target.isEmpty()){
            return 0;
        }

        if (dp.containsKey(target)){
            return dp.get(target);
        }

        HashMap<Character,Integer> targetMap = new HashMap<>();
        for (char c:target.toCharArray()){
            targetMap.put(c,targetMap.getOrDefault(c,0)+1);
        }
        int ans = 50;
        for (HashMap<Character,Integer> stickerMap: stickerList){
            if (!stickerMap.containsKey(target.charAt(0))){
                continue;
            }
            HashMap<Character,Integer> newTargetMap = new HashMap<>();
            for (char c: targetMap.keySet()){
                int count  =Math.max(0,targetMap.get(c)-stickerMap.getOrDefault(c,0));
                if (count<=targetMap.get(c) && count!=0){
                    newTargetMap.put(c,count);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (char c: newTargetMap.keySet()){
                int count = newTargetMap.get(c);
                for (int i=0;i<count;i++){
                    stringBuilder.append(c);
                }


            }

            ans = Math.min(ans,1+dfs(stringBuilder.toString(),stickerList));
        }
        dp.put(target,ans);
        return ans;
    }

    public int minStickers(String[] stickers, String target) {
        List<HashMap<Character,Integer>> stickerList = new ArrayList<>();
        for (String sticker :stickers){
            HashMap<Character,Integer> map = new HashMap<>();
            for (char c:sticker.toCharArray()){
                map.put(c,map.getOrDefault(c,0)+1);
            }
            stickerList.add(map);
        }

        dp = new HashMap<>();
        int ans =dfs(target,stickerList);
        if (ans <50 ){
            return ans;
        }
        return -1;
    }

}
