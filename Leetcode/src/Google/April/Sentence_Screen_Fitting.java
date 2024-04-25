package Google.April;

import java.util.Arrays;

public class Sentence_Screen_Fitting {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int index = 0;
        //This represents the current column I am trying to insert my word at.
        int c = 0;
        int[] memo = new int[sentence.length];
        Arrays.fill(memo, -1);
        int temp = -1;
        while (rows > 0) {
            //If I already know how many words of the sentence I can fit on this row, because I've already computed a row starting with this specific word of the sentence before.
            //We store the index of the word, instead of the word itself.
            if (memo[getIndex(index, sentence.length)] >= 0 && c == 0) {
                index += memo[getIndex(index, sentence.length)];
                c = 0;
                rows--;
                continue;
            }
            String current = sentence[getIndex(index, sentence.length)];
            c += current.length();
            if (temp < 0) temp = index;
            //If after inserting a word I still have space on my row.
            if (c < cols) {
                index++;
                // We also add a space after a word.
                c++;
                //If after inserting a word I don't have space on my row anymore.
            } else {
			/*
			    If the last word I have inserted on this row coincides with the ending of the row.
			    (Or, put differently, if after I've inserted the last word that I can on that row, there is no more trailing space.)
			*/
                if (c == cols) index++;
                rows--;
                c = 0;
                //After I've completed a row, save how many words I have fitted on this row, starting with that specific word of the sentence.
                memo[getIndex(temp, sentence.length)] = index - temp;
                temp = -1;
            }
        }
		/*
		    If you divide the number of words that you have inserted in the editor, by the number of words that make out your sentence,
			then you will get the number of total sentences that you have inserted in the editor.
		*/
        return index / (sentence.length);
    }

    public int getIndex(int index, int maxLength) {
        return index % maxLength;
    }

}
