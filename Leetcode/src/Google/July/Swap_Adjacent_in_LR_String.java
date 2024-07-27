package Google.July;

import java.util.ArrayList;
import java.util.List;

public class Swap_Adjacent_in_LR_String {

    public boolean canTransform(String start, String end) {

        if(!start.replace("X","").equals(end.replace("X",""))) return false;

        if (start.length()!=end.length()){
            return false;
        }

        List<Integer> lStart = new ArrayList<>();
        List<Integer> rStart = new ArrayList<>();
        List<Integer> lEnd = new ArrayList<>();
        List<Integer> rEnd = new ArrayList<>();

        for (int i=0;i<start.length();i++){
            if (start.charAt(i)=='R'){
                rStart.add(i);
            }
            if (start.charAt(i)=='L'){
                lStart.add(i);
            }
        }

        for (int i=0;i<end.length();i++){
            if (end.charAt(i)=='R'){
                rEnd.add(i);
            }
            if (end.charAt(i)=='L'){
                lEnd.add(i);
            }
        }

        int i=0,j=0;
        while(i<lStart.size() && j<lEnd.size()){
            if (lStart.get(i)<lEnd.get(j)){
                return false;
            }
            i++;
            j++;
        }

        i=0;
        j=0;
        while(i<rStart.size() && j<rEnd.size()){
            if (rStart.get(i)>rEnd.get(j)){
                return false;
            }
            i++;
            j++;
        }

        return true;
    }

}
