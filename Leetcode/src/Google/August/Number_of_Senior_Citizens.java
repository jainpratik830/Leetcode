package Google.August;

public class Number_of_Senior_Citizens {

    public int countSeniors(String[] details) {
        int count=0;
        for(String s:details){
            if(Integer.parseInt(s.substring(11,13))>60){
                count++;
            }
        }

        return count;
    }

}
