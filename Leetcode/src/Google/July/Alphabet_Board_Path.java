package Google.July;

public class Alphabet_Board_Path {

    public String alphabetBoardPath(String target) {

        int x = 0;
        int y = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);

            int x1 = (ch - 'a') / 5;
            int y1 = (ch - 'a') % 5;
            // if you want to move UpSide form the Current Position..
            while (x1 < x) {
                x--;
                sb.append('U');
            }
            // if you want to move Right form the Current Position..
            while (y1 > y) {
                y++;
                sb.append('R');
            }
            // if you want to move Left form the Current Position..
            while (y1 < y) {
                y--;
                sb.append('L');
            }
            // if you want to move Down form the Current Position..
            while (x1 > x) {
                x++;
                sb.append('D');
            }
            sb.append('!');
        }
        return sb.toString();
    }

}
