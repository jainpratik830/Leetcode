package Google.April;

import java.util.TreeMap;

public class SnapshotArray {

    TreeMap<Integer,Integer>[] map;
    int snapCount;

    public SnapshotArray(int length) {
        snapCount = 0;
        map= new TreeMap[length];
        for (int i=0;i<length;i++){
            map[i] = new TreeMap<>();
            map[i].put(0,0);
        }
    }

    public void set(int index, int val) {
        map[index].put(snapCount,val);
    }

    public int snap() {
        return snapCount++;
    }

    public int get(int index, int snap_id) {
        return map[index].floorEntry(snap_id).getValue();
    }

}
