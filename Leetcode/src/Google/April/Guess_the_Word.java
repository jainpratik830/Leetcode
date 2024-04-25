package Google.April;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Guess_the_Word {

    interface Master {

        public int guess(String word) ;

    }

    public int count_match(String a,String b){

        int count =0;
        for (int i=0;i<a.length();i++){
            if (a.charAt(i)==b.charAt(i)){
                count++;
            }
        }
        return count;

    }
    public void findSecretWord(String[] words, Master master) {
        List<String> candidates = new ArrayList<>();
        for (String word:words){
            candidates.add(word);
        }
        Random random = new Random();
        while (true){

            int curr = random.nextInt(candidates.size());
            String curr_word = candidates.get(curr);
            int matches = master.guess(curr_word);

            if (matches==6){
                return;
            }
            List<String> new_candidates=new ArrayList<>();
            for (String word:candidates){
                if (count_match(word,curr_word)==matches){
                    new_candidates.add(word);
                }
            }
            candidates= new_candidates;


        }
    }

}
