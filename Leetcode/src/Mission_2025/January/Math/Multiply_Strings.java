package Mission_2025.January.Math;

public class Multiply_Strings {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }

        int n1= num1.length();
        int n2 = num2.length();
        int n = n1+n2;
        int[] result = new int[n];
        for (int i=n1-1;i>=0;i--){
            for (int j=n2-1;j>=0;j--){

                int prod = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                prod +=  result[i + j + 1];
                int unit = prod%10;
                int tens = prod/10;
                result[i+j+1]=unit;
                result[i+j]+=tens;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i:result){
            if (ans.length()==0 && i==0){
                continue;
            }
            ans.append(i);
        }
        return ans.toString();
    }

}
