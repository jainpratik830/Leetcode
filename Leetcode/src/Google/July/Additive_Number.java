package Google.July;

public class Additive_Number {

    public boolean isAdditiveNumber(String num) {

        String a="";
        String b="";

        for (int i=0;i<num.length();i++){
            a = num.substring(0,i+1);
            if (a.length()>1 && a.charAt(0)=='0'){
                continue;
            }

            for (int j=i+1;j<num.length();j++){
                b= num.substring(i+1,j+1);
                if (b.length()>1 && b.charAt(0)=='0'){
                    continue;
                }
                if (valid(num.substring(j+1),Long.parseLong(a),Long.parseLong(b))){
                    return true;
                }
            }
        }


        return false;
    }

    public boolean valid(String str, long a, long b) {
        long sum = a+b;
        String val = String.valueOf(sum);
        if (val.length()>str.length()){
            return false;
        }
        if (str.length()==val.length() && str.equals(val) ){
            return true;
        }
        return str.substring(0,val.length()).equals(val) && valid(str.substring(val.length()),b,sum);

    }

}
