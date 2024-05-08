package Google.May.String;

import java.util.Arrays;

public class Zigzag_Conversion {

    public String convert(String s, int numRows) {
        StringBuilder ans = new StringBuilder();
        String[] arr= new String[numRows];
        Arrays.fill(arr,"");
        if(numRows==1){
            return s;
        }
        int i=0;
        int curr =0;
        boolean goingDown = true;
        while (i<s.length()){
            arr[curr]= arr[curr]+s.charAt(i);
            if (curr==0){
                goingDown=true;
            }else if (curr==numRows-1){
                goingDown=false;
            }

            if (goingDown){
                curr++;
            }else {
                curr--;
            }
            i++;
        }

        for (String str:arr){
            ans.append(str);
        }

        return ans.toString();
    }

}
