package Google.May.Array;

public class Reverse_Prefix_of_Word {

    public String reversePrefix(String word, char ch) {
        int occur = -1;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
                occur = i;
                break;
            }
        }

        if(occur==-1){
            return word;
        }
        StringBuilder newWord =new StringBuilder();
        for(int i=0;i<=occur;i++){
            newWord.append(word.charAt(occur-i));
        }
        word =newWord.toString() + word.substring(occur+1);
        return word;
    }

}
