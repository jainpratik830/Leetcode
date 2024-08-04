package Google.August;

public class Verify_Preorder_Serialization_of_a_Binary_Tree {

    public boolean isValidSerialization(String preorder) {
        int slots =1;
        for (String s:preorder.split(",")){

            if (s.equals("#")){
                slots = slots-1+0;
            }else {
                slots = slots-1+2;
            }
            if (slots<=0){
                return false;
            }
        }

        return slots==0;
    }

}
