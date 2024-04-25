package Google.March;

public class Water_and_Jug_Problem {
    public boolean canMeasureWater(int x, int y, int target) {
        if(x+y<target){
            return false;
        }


        int a =x;
        int b= y;

        while(b!=0){
            int temp =b;
            b = a%b;
            a= temp;

        }

        if(target%a==0){
            return true;
        }
        return false;
    }

}
