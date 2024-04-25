package Google.April;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Text_Justification {


    //     T = O(n)
//     S = O(n)
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> res = new ArrayList<>();
        int width = 0;
        List<String> curr = new ArrayList<>();
        int i=0;
        while(i<words.length){
            String word = words[i];
            if (width+word.length()<=maxWidth){

                width+= word.length()+1;
                curr.add(word);
                i++;
                // System.out.println(curr);
            }else{

                int spaces = maxWidth-width+curr.size();
                int added = 0;
                int j=0;
                // System.out.println(curr);
                while(added<spaces){
                    if (j>=curr.size()-1){
                        j=0;
                    }
                    curr.set(j, curr.get(j)+" ");
                    added++;
                    j++;

                }

                res.add(curr.stream().collect(Collectors.joining("")));
                curr = new ArrayList<>();
                width=0;
            }
        }
// System.out.println(curr);
        for(i=0;i<curr.size()-1;i++){
            curr.set(i, curr.get(i)+" ");
        }

        while(width<=maxWidth){
            curr.set(curr.size()-1, curr.get(curr.size()-1)+" ");
            width++;
        }
        res.add(curr.stream().collect(Collectors.joining("")));


        return res;
    }

}
