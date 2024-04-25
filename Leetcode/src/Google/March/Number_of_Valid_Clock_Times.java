package Google.March;

public class Number_of_Valid_Clock_Times {

    public int countTime(String time) {
        int count = 1;
        if (time.charAt(4)=='?'){
            count *= 10;
        }if (time.charAt(3)=='?'){
            count*= 6;
        }
        if (time.charAt(1)=='?'){
            if (time.startsWith("??")){
                count*=24;
            }
            if (time.startsWith("0") || time.startsWith("1")){
                count *= 10;
            }
            if (time.startsWith("2")){
                count *= 4;
            }
        }
        if(time.charAt(0)=='?'){
            if (time.charAt(1)-'4'<=0 ){
                count *= 3;
            }else{
                count *= 2;
            }
        }

        return count;

    }

}
