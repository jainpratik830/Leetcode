package Google.May.Others;

public class Steps_to_Reduce_Binary_to_One {

    public void divideBy2(StringBuilder s){
        s.deleteCharAt(s.length()-1);
    }

    public void add1(StringBuilder s){
        int i = s.length()-1;

        while (i>=0 && s.charAt(i)=='1'){
            s.setCharAt(i,'0');
            i--;
        }

        if (i<0){
            s.insert(0,'1');
        }else {
            s.setCharAt(i,'1');
        }
    }

    public int numSteps(String s) {
        StringBuilder sb =new StringBuilder(s);
        int ops =0;

        while (sb.length()>1){
            if (sb.charAt(sb.length()-1)=='1'){
                add1(sb);
            }else {
                divideBy2(sb);
            }
            ops++;
        }

        return ops;
    }


}

