package Google.July;

import java.util.HashMap;
import java.util.TreeMap;

public class StockPrice {

    int currPrice;
    int currTime;
    HashMap<Integer,Integer> hashMap;
    TreeMap<Integer,Integer> map;

    public StockPrice() {
        hashMap =new HashMap<>();
        map =new TreeMap<>();

    }

    public void update(int timestamp, int price) {
        if (timestamp>currTime  || currTime==-1 ){
            currTime= timestamp;
            currPrice=price;
            hashMap.put(currTime,currPrice);
            map.put(currPrice,map.getOrDefault(currPrice,0)+1);
        } else if (timestamp<currTime){
            if (!hashMap.containsKey(timestamp)){
                hashMap.put(timestamp,price);
                map.put(price,map.getOrDefault(price,0)+1);
            }
            int orgPrice =hashMap.get(timestamp);

            hashMap.put(timestamp,price);
            int times = map.get(orgPrice);
            if (times==1){
                map.remove(orgPrice);
            }else {
                map.put(orgPrice,times-1);
            }
            map.put(price,map.getOrDefault(price,0)+1);
        }else {
            currPrice=price;
            int orgPrice =hashMap.get(timestamp);

            hashMap.put(timestamp,price);
            int times = map.get(orgPrice);
            if (times==1){
                map.remove(orgPrice);
            }else {
                map.put(orgPrice,times-1);
            }
            map.put(price,map.getOrDefault(price,0)+1);
        }
    }

    public int current() {
        return currPrice;
    }

    public int maximum() {
        return map.lastKey();
    }

    public int minimum() {
        return map.firstKey();
    }

}
