package Google.April;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {


    List<Integer> prefix;

    public ProductOfNumbers() {
        prefix= new ArrayList<>();
    }

    public void add(int num) {

        if (num==0){
            prefix = new ArrayList<>();
            return;
        }
        if (prefix.size()==0){
            prefix.add(num);

        }else {
            int curr = prefix.get(prefix.size()-1)*num;
            prefix.add(curr);
        }


    }

    public int getProduct(int k) {

        if (prefix.size()<k){
            return 0;
        }
        if (prefix.size()==k){
            return (prefix.get(prefix.size()-1));
        }
        return (int) (prefix.get(prefix.size()-1)/prefix.get(prefix.size()-1-k));
    }

}
