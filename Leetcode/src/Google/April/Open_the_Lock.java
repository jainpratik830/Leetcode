package Google.April;

import java.util.*;

public class Open_the_Lock {



    public int openLock(String[] deadends, String target) {

        Map<Character, Character> nextSlot = Map.of(
                '0', '1',
                '1', '2',
                '2', '3',
                '3', '4',
                '4', '5',
                '5', '6',
                '6', '7',
                '7', '8',
                '8', '9',
                '9', '0'
        );
        // Map the previous slot digit for each current slot digit.
        Map<Character, Character> prevSlot = Map.of(
                '0', '9',
                '1', '0',
                '2', '1',
                '3', '2',
                '4', '3',
                '5', '4',
                '6', '5',
                '7', '6',
                '8', '7',
                '9', '8'
        );

        HashSet<String> visited = new HashSet<>(Arrays.stream(deadends).toList());
        Queue<String> queue =new LinkedList<>();

        if (visited.contains("0000") || visited.contains(target)){
            return -1;
        }

        queue.add("0000");
        visited.add("0000");
        int turns = 0;
        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i=0;i<size;i++){

                String curr = queue.poll();

                if (curr.equals(target))
                    return turns;

                for (int wheel=0;wheel<4;wheel++){

                    StringBuilder newCombUp = new StringBuilder(curr);
                    newCombUp.setCharAt(wheel, nextSlot.get(newCombUp.charAt(wheel)));
                    if (!visited.contains(newCombUp.toString())){
                        queue.add(newCombUp.toString());
                        visited.add(newCombUp.toString());
                    }

                    StringBuilder newCombDown = new StringBuilder(curr);
                    newCombDown.setCharAt(wheel, prevSlot.get(newCombDown.charAt(wheel)));
                    if (!visited.contains(newCombDown.toString())){
                        queue.add(newCombDown.toString());
                        visited.add(newCombDown.toString());
                    }

                }
            }
            turns+=1;

        }


        return -1;
    }

}
