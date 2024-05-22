package Google.May.CodingRound;

public class Count_and_Say {

    public String RLE(String s){
        StringBuilder ans = new StringBuilder();
        int i=1;
        int count =1;
        while (i<s.length()){
           if (s.charAt(i)==s.charAt(i-1)){
               count++;
           }else {
               ans.append(count);
               ans.append(s.charAt(i-1));
               count=1;
           }
           i++;
        }

            ans.append(count);
            ans.append(s.charAt(i-1));

        return ans.toString();
    }


    public String countAndSay(int n) {
        if (n==1){
            return "1";
        }else {
            String prev = countAndSay(n-1);
            return RLE(prev);
        }
    }

}
