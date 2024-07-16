package Google.July;

public class Crawler_Log_Folder {

    public int minOperations(String[] logs) {
        int count = 0;
        for (String s:logs){
            if (s.equals("./")){
                continue;
            }else if (s.equals("../")){
                if (count==0){
                    continue;
                }
                count--;
            }else {
                count++;
            }
        }

        return count;
    }

}
