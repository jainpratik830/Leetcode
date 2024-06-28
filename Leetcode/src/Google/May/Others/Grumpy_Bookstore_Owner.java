package Google.May.Others;

public class Grumpy_Bookstore_Owner {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        int count = 0;

        for (int i=0;i<customers.length;i++){
            if (grumpy[i]==0){
                count+= customers[i];
            }
        }
        int curr = 0;
        for (int i=0;i<minutes;i++){
            if (grumpy[i]==1){
                count+= customers[i];
            }

        }
        ans = Math.max(ans,count);

        for (int i=1;i<=customers.length-minutes;i++){
            if (grumpy[i-1]==1){
                count-= customers[i-1];
            }
            if (grumpy[i+minutes-1]==1){
                count+= customers[i+minutes-1];
            }
            ans = Math.max(ans,count);
        }

        return ans;
    }

}
