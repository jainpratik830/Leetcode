package Google.April;

public class Number_of_Wonderful_Substrings {

    public long wonderfulSubstrings(String word) {
        int[] count = new int[10];

        for (char c:word.toCharArray()){
            count[c-'a']++;
        }

        boolean firstOdd = false;
        for (int i:count){
            if (i%2==0){
                if (!firstOdd){
                    firstOdd=true;
                }else {
//                    return false;
                }
            }
        }

        return 0;
    }


}
