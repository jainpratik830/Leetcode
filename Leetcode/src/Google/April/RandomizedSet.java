package Google.April;

import java.util.*;

public class RandomizedSet {

    List<Integer> list;
    Map<Integer,Integer> map;
    Random random;
    // int count;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random=new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        // count++;
        return true;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)){
            int index=  map.get(val);
            map.remove(val);
            int newVal = list.get(list.size()-1);
            list.set(index,newVal);
            map.put(newVal,index);
            list.remove(list.size()-1);
            // count--;
            return true;
        }
        return false;
    }

    public int getRandom() {
        // System.out.println(list);
        return list.get(random.nextInt(list.size()));
    }

}
