package Google.May.Others;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Maximum_Score_Words_Formed_by_Letters {

    int maxScore;
    int[] count;
    int[] score;

    public void generateSets(String[] words, int curr, List<String> currSet){

        if (curr==words.length){
            int[] temp = count.clone();
            int currScore = 0;
            for (String word:currSet){
                for (Character c:word.toCharArray()){
                    if (temp[c-'a']<=0){
                        currScore=0;
                        break;
                    }else {
                        currScore+= score[c-'a'];
                        temp[c-'a']--;
                    }
                }
            }
            maxScore = Math.max(currScore,maxScore);
            return;
        }

        String currWord = words[curr];
        currSet.add(currWord);
        generateSets(words,curr+1,currSet);
        currSet.remove(currSet.size()-1);
        generateSets(words,curr+1,currSet);

    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        maxScore = 0;
        count= new int[26];
        for (char c:letters){
            count[c-'a']++;
        }
        this.score =score;
        generateSets(words,0,new ArrayList<>());
        return maxScore;
    }

}
