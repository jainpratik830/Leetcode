package Google.April;

import java.util.HashSet;
import java.util.Set;

public class Longest_Repeating_Character_Replacement {
    //     T(n)= O(n)
//     S(n) = 1
    public int characterReplacement2(String s, int k) {
        int ans =0;
        int i=0;
        int j=0;
        int MAX =Integer.MIN_VALUE;
        int[] count = new int[26];
        for (i=0;i<s.length();i++){
            count[s.charAt(i)-'A']++;
            MAX = Math.max(MAX,count[s.charAt(i)-'A']);
            if (i-j-MAX+1>k){
                count[s.charAt(j)-'A']--;
                j++;
            }
            ans = Math.max(ans,i-j+1);
        }
        return ans;
    }

//     T(n)= O(n)
//     S(n) = O(1)

    public int characterReplacement(String s, int k) {
        int ans =0;
        int i=0;
        int j=0;
        int count =0;
        char curr = s.charAt(0);
        Set<Character> set = new HashSet<>();
        for(char c:s.toCharArray()){
            set.add(c);
        }

        for (char c:set){
            i=0;
            j=0;
            count =0;
            curr = c;
            while (j<s.length()){

                if (curr!=s.charAt(j)){
                    if (count<k){
                        count++;
                        ans = Math.max(ans,j-i+1);
                        j++;
                    }else{
                        while (s.charAt(i)==curr){

                            i++;

                        }
                        i++;
                        count--;
                    }
                }else{

                    j++;
                }
                System.out.println("i="+i+" j="+j);

            }
        }




        return ans;
    }

}
