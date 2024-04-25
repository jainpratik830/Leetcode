package Google.March;

import java.util.*;

public class MKAverage {

    int m,k;
    long sum;
    List<Integer> list;
    int[] count;
    TreeMap<Integer,Integer> less;
    TreeMap<Integer,Integer> middle;
    TreeMap<Integer,Integer> greater;


    public MKAverage(int m, int k) {
        this.m=m;
        this.k=k;
        this.list = new ArrayList<>();
        count = new int[3];
        less = new TreeMap<>();
        middle = new TreeMap<>();
        greater = new TreeMap<>();
        this.sum=0;

    }

    public void printList(){
        System.out.println("Count "+Arrays.toString(count));
        System.out.println("Less "+less);
        System.out.println("Middle "+middle);
        System.out.println("Greater "+greater);
    }

    public void addElement(int num) {
        list.add(num);
        if (list.size()>m){
            int removed = list.remove(0);
            removeElement(removed);
            addNewElement(num);
        }else if (list.size()==m){
            initializeSet();
        }

    }

    public void addNewElement(int element){
        middle.put(element,middle.getOrDefault(element,0)+1);
        sum+=element;
        count[1]+=1;
        if (count[0] < k || less.lastKey() > middle.firstKey()) {
            int q = middle.get(middle.firstKey());
            int ele = middle.firstKey();
            if (q-1>0){
                middle.put(ele,q-1);

            }else {
                middle.remove(ele);
            }
            sum-=ele;
            less.put(ele,less.getOrDefault(ele,0)+1);
            count[0]++;
            count[1]--;
            if (count[0] > k) {
                int q2 = less.get(less.lastKey());
                int ele2 = less.lastKey();
                if (q2-1>0){
                    less.put(ele2,q-1);

                }else {
                    less.remove(ele2);
                }
                middle.put(ele2,middle.getOrDefault(ele2,0)+1);
                sum+=ele2;
                count[1]++;
            }
        }

        if (count[1]==0) {
            return;
        }

        if (count[2] < k || greater.firstKey() > middle.lastKey()) {
            int q = middle.get(middle.lastKey());
            int ele = middle.lastKey();
            if (q-1>0){
                middle.put(ele,q-1);

            }else {
                middle.remove(ele);
            }
            sum-=ele;
            greater.put(ele,greater.getOrDefault(ele,0)+1);
            count[2]++;
            count[1]--;
            if (count[2] > k) {
                int q2 = greater.get(greater.firstKey());
                int ele2 = greater.firstKey();
                if (q2-1>0){
                    greater.put(ele2,q-1);

                }else {
                    greater.remove(ele2);
                }
                sum+=ele2;
                middle.put(ele2,middle.getOrDefault(ele2,0)+1);
                count[1]++;
                count[2]--;
            }
        }



//        if (element > greater.firstKey()){
//            int toRemove = greater.firstKey();
//            greater.put(element, greater.getOrDefault(element,0)+1);
//            count[2]++;
//            if (greater.get(toRemove)>1){
//                greater.put(toRemove,greater.get(toRemove)-1);
//            }else {
//                greater.remove(toRemove);
//            }
//            count[2]--;
//            addNewElement(toRemove);
//        }else if (element < less.lastKey()){
//            int toRemove = less.lastKey();
//            less.put(element, less.getOrDefault(element,0)+1);
//
//            count[0]++;
//
//            if (less.get(toRemove)>1){
//                less.put(toRemove,less.get(toRemove)-1);
//            }else {
//                less.remove(toRemove);
//            }
//            count[0]--;
//            addNewElement(toRemove);
//        }else{
//            middle.put(element, middle.getOrDefault(element,0)+1);
//            sum+=element;
//            count[1]++;
//        }

//
//        middle.put(element,middle.getOrDefault(element,0)+1);
//        sum+=element;
//        count[1]+=1;
//
//        if (count[1]==m-2*k){
//            return;
//        }
//        if (count[0]==k-1){
//            Map.Entry<Integer,Integer> entry =  middle.pollFirstEntry();
//            if (entry.getValue()-1>0){
//                less.put(entry.getKey(),less.getOrDefault(entry.getKey(),0)+1);
//                middle.put(entry.getKey() ,entry.getValue()-1);
//                sum -= entry.getKey();
//            }else{
//                less.put(entry.getKey(),less.getOrDefault(entry.getKey(),0)+1);
//                middle.remove(entry.getKey());
//                sum -= entry.getKey();
//                count[1]--;
//                count[0]++;
//            }
//        }else{
//            Map.Entry<Integer,Integer> entry =  middle.pollLastEntry();
//            if (entry.getValue()-1>0){
//                greater.put(entry.getKey(),greater.getOrDefault(entry.getKey(),0)+1);
//                middle.put(entry.getKey() ,entry.getValue()-1);
//                sum -= entry.getKey();
//            }else{
//                greater.put(entry.getKey(),greater.getOrDefault(entry.getKey(),0)+1);
//                middle.remove(entry.getKey());
//                sum -= entry.getKey();
//                count[1]--;
//                count[2]++;
//            }
//        }
    }

    public void removeElement(int element){
        if (middle.containsKey(element)){
            int qunat = middle.get(element)-1;
            if (qunat>0){
                middle.put(element,qunat);
            }else {
                middle.remove(element);
            }
            sum-=element;
            count[1]-=1;
        }else if (less.containsKey(element)){
            int qunat = less.get(element)-1;
            if (qunat>0){
                less.put(element,qunat);
            }else {
                less.remove(element);
            }
            count[0]-=1;
        } else if (greater.containsKey(element)) {
            int qunat = greater.get(element)-1;
            if (qunat>0){
                greater.put(element,qunat);
            }else {
                greater.remove(element);
            }
            count[2]-=1;

        }
    }

    public void initializeSet(){

        for (int i:list){
            middle.put(i, middle.getOrDefault(i,0)+1);
            count[1]++;
            sum += i;
        }
        int temp =k;
        while (temp>0){
            Map.Entry<Integer,Integer> entry =  middle.pollFirstEntry();
            if (temp -entry.getValue()>=0){
                less.put(entry.getKey(),entry.getValue());
                temp-= entry.getValue();
                sum -= entry.getKey()*entry.getValue();
            }else{
                less.put(entry.getKey(), temp);
                middle.put(entry.getKey() ,entry.getValue()-temp);
                sum -= entry.getKey()*(entry.getValue()-temp);
                temp=0;
            }

        }

        temp =k;
        while (temp>0){
            Map.Entry<Integer,Integer> entry =  middle.pollLastEntry();
            if (temp -entry.getValue()>=0){
                greater.put(entry.getKey(),entry.getValue());
                temp-= entry.getValue();
                sum -= entry.getKey()*entry.getValue();
            }else{
                greater.put(entry.getKey(), temp);
                middle.put(entry.getKey() ,entry.getValue()-temp);
                sum -= entry.getKey()*(entry.getValue()-temp);
                temp=0;
            }

        }
        count[0]=k;
        count[2]=k;
        count[1]=m-2*k;
    }

    public int calculateMKAverage() {
        if (list.size()<m){
            return -1;
        }
        return (int) (sum/(m-2*k));
    }

}
