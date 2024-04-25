package Google.April;

import java.util.ArrayList;
import java.util.List;

public class Gray_Code {

    public List<Integer> grayCode(int n) {

        List<String> store=findGrayCode(n);
        List<Integer> ans=new ArrayList<>();
        for(String elem:store){
            ans.add(Integer.parseInt(elem,2));
        }
        return ans;
    }
    public List<String> findGrayCode(int n){
        if(n==1){
            List<String> bres=new ArrayList<>();
            bres.add("0");
            bres.add("1");
            return bres;
        }
        List<String> str=findGrayCode(n-1);
        List<String> ans=new ArrayList<>();
        for(int i=0;i<str.size();i++){
            String st=str.get(i);
            st="0"+st;
            ans.add(st);
        }
        for(int i=str.size()-1;i>=0;i--){
            String st=str.get(i);
            st="1"+st;
            ans.add(st);
        }
        return ans;
    }

}
