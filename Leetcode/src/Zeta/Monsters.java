//package Zeta;

import java.util.*;

public class Monsters {


    public static void findPath(char[][] map){
        int m= map.length;
        int n = map[0].length;
//        R =1 , D=2,L=3,U=4
        int[][] direction = {{0,1,1},{1,0,2},{0,-1,3},{-1,0,4}};
        Queue<int[]> robot = new LinkedList<>();
        boolean[][] isMonster = new boolean[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> monsters = new LinkedList<>();
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (map[i][j]=='A'){
                    robot.add(new int[]{i,j,0});
                    visited[i][j]=true;
                }
                if (map[i][j]=='M'){
                    monsters.add(new int[]{i,j});
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!robot.isEmpty()){

            if (!monsters.isEmpty()){
                int size = monsters.size();
                for (int i=0;i<size;i++){
                    int[] curr = monsters.poll();
                    for (int[] j:direction){
                        int x = curr[0]+j[0];
                        int y = curr[1]+j[1];
                        if (x>=0 && y>=0 && x<m && y<n && !isMonster[x][y] && map[x][y]=='.'){
                            isMonster[x][y]=true;
                            monsters.add(new int[]{x,y});
                        }
                    }
                }
            }
            int size = robot.size();
            for (int i=0;i<size;i++){
                int[] curr = robot.poll();
                if (curr[0]==0 || curr[1]==0 || curr[0]==m-1 || curr[1]==n-1){
                    System.out.println("YES");
                    System.out.println(Integer.toString(curr[2]).length());
                    for (char c: Integer.toString(curr[2]).toCharArray()){
                        if (c=='1'){
                            System.out.print('R');
                        }
                        else if (c=='2'){
                            System.out.print('D');
                        }
                        else if (c=='3'){
                            System.out.print('L');
                        }
                        else if (c=='4'){
                            System.out.print('R');
                        }
                    }
                    return;
                }
                for (int[] j:direction){
                    int x = curr[0]+j[0];
                    int y = curr[1]+j[1];

                    if (x>=0 && y>=0 && x<m && y<n && !isMonster[x][y] && !visited[x][y] && map[x][y]=='.'){

                        visited[x][y]=true;
                        robot.add(new int[]{x,y,curr[2]*10+j[2]});
                    }
                }
            }


        }
        System.out.print("NO");
    }

//    #.#.M#.#
//#M#..#..
//#.######

    public static void main(String[] args){
        Scanner scanner=  new Scanner(System.in);
        String line  = scanner.nextLine();
        int m =Integer.parseInt(line.split(" ")[0]);
        int n =Integer.parseInt(line.split(" ")[1]);
        char[][] map2=  new char[m][n];
        for (int i=0;i<m;i++){
            String row = scanner.nextLine();
            int j=0;
            for (char c:row.toCharArray()){
                map2[i][j]=c;
                j++;
            }
            System.out.print(Arrays.toString(map2[i]));
        }
//        Math.pow()

        findPath(map2   );
//        String[] lines = {
//            "###MMMMM",
//            "#.AMMMMM",
//            "#.#MMMMM",
//            "#.#MMMMM",
//            "#.#MMMMM",
//            "#.#MMMMM",
//            "#.#MMMMM",
//            "#.#MMMMM"
//        };
//        int M = lines.length;
//        int N = lines[0].length();
//        char[][] map3=  new char[M][M];
//        for (int i=0;i<M;i++){
//            String row = lines[i];
//            int j=0;
//            for (char c:row.toCharArray()){
//                map3[i][j]=c;
//                j++;
//            }
//        }
//        findPath(map3   );
//        char[][] map=  {
//                {'#','#','#','#','#','#','#','#'},
//                {'#','M','.','.','A','.','.','#'},
//                {'#','.','#','.','M','#','.','#'},
//                {'#','M','#','.','.','#','.','.'},
//                {'#','.','#','#','#','#','#','#'},
//        };
//
    }

}
