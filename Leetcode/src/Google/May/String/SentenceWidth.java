package Google.May.String;

import java.util.ArrayList;
import java.util.List;

public class SentenceWidth {

    public static int maxLines(String text,int width){

        int curr = 0;
        int count=0;
        int i=0;
        String[] words = text.split(" ");
        List<String> list =new ArrayList<>();
        String line= "";
        while (i<words.length){
            if (words[i].length()>width){
//                list.add( line);
//                System.out.println(line);
//                System.out.println(curr);
                if (curr<=width-1){
                    list.add( line+words[i].substring(0,width-1-curr)+"-");
                    words[i] = words[i].substring(width-1-curr);
//                    line = "";
//                    curr = 0;
                }else{
                    list.add( line);
                    list.add(words[i].substring(0,width-1)+"-");
                    words[i] = words[i].substring(width-1);
                    count++;
                }
//                list.add( line+words[i].substring(0,width-1-curr)+"-");
//                words[i] = words[i].substring(width-1);
                count++;
                line = "";
                curr = 0;
                continue;
            }

             if (curr+words[i].length()<=width){
                line = line+words[i]+" ";
                curr += words[i].length()+1;
                i++;
            }else{
                list.add( line);
                line = words[i]+" ";
                curr = words[i].length()+1;
                count++;
                i++;
            }
        }
        list.add( line);
        count++;
        for (String s:list){
            System.out.println(s);
        }

        System.out.println(count);

        return count;
    }

    public static void main(String[] args){
        String text = "This is a really looooooooooooooooooong sample text example";
        int width =8;

        maxLines(text,width);
    }

}
