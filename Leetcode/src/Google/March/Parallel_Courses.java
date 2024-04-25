package Google.March;

import java.util.*;

public class Parallel_Courses {

    boolean[] visited;

    public int minimumSemesters(int n, int[][] relations) {

        visited = new boolean[n];

        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for (int[] i:relations){
            List<Integer> list = map.getOrDefault(i[0],new ArrayList<>());
            list.add(i[1]);
            map.put(i[0],list);
        }
        int ans =0;
        for (int i=1;i<=n;i++){
            int curr = bfs(i,map);
            visited = new boolean[n];
            if (curr==-1){
                return -1;
            }
            ans = Math.max(ans,curr);
        }

//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(1);
//        int steps =0;
//        while (!queue.isEmpty()){
//            int curr = queue.poll();
//            if (visited[curr-1]){
//                return -1;
//            }else{
//                queue.addAll(map.getOrDefault(curr,new ArrayList<>()));
//
//            }
//            visited[curr-1]=true;
//            steps++;
//
//        }

//        for (boolean i:visited){
//            if (!i){
//                return -1;
//            }
//        }

        return ans;
    }


    public int bfs(int start,HashMap<Integer,List<Integer>> map){
        if(visited[start]){
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int steps =0;
        while (!queue.isEmpty()){
            int curr = queue.poll();
            if (visited[curr-1]){
                return -1;
            }else{
                queue.addAll(map.getOrDefault(curr,new ArrayList<>()));

            }
            visited[curr-1]=true;
            steps++;

        }
        return steps;
    }

}
