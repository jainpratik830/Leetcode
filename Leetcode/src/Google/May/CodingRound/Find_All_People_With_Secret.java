package Google.May.CodingRound;

import java.util.*;

public class Find_All_People_With_Secret {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        LinkedHashMap<Integer,List<int[]>> map = new LinkedHashMap<>();
        Arrays.sort(meetings,Comparator.comparingInt(a->a[2]));
            for (int[] i:meetings){
            map.putIfAbsent(i[2],new ArrayList<>());
            map.get(i[2]).add(new int[]{i[0],i[1]});
        }

        Set<Integer> knows = new HashSet<>();
        knows.add(0);
        knows.add(firstPerson);
        System.out.println(map);
        for (int key:map.keySet()){
            HashMap<Integer,List<Integer>> map1 = new HashMap<>();
            Set<Integer> seen = new HashSet<>();
            for (int[] i:map.get(key)){
                map1.putIfAbsent(i[0],new ArrayList<>());
                map1.putIfAbsent(i[1],new ArrayList<>());
                map1.get(i[0]).add(i[1]);
                map1.get(i[1]).add(i[0]);
                if (knows.contains(i[0])){
                    seen.add(i[0]);
                }

                if (knows.contains(i[1])){
                    seen.add(i[1]);
                }
            }
            Queue<Integer> queue= new LinkedList<>();
            queue.addAll(seen);
            while (!queue.isEmpty()){
                int curr = queue.poll();;
                for (int neigh:map1.getOrDefault(curr,new ArrayList<>())){
                    if (!knows.contains(neigh)){
                        queue.add(neigh);
                        knows.add(neigh);
                    }
                }
            }

        }

        return knows.stream().toList();
    }

}
