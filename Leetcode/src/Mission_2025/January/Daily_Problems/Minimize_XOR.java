package Mission_2025.January.Daily_Problems;

public class Minimize_XOR {

    public int minimizeXor(int num1, int num2) {
        int result = num1;

        int target = Integer.bitCount(num2);
        int count = Integer.bitCount(num1);

        int current = 0;
        while (count<target){
            if (!isSet(result,current)){
                result= set(result,current);
                count++;

            }
            current++;
        }

        while (count>target){
            if (!isSet(result,current)){
                result= unSet(result,current);
                count--;
            }
            current++;
        }
        return result;

    }

    public boolean isSet(int num,int bit){
        return (num & (1<< bit))!=0;
    }

    public int set(int num,int bit){
        return ( num | (1 << bit)  );
    }

    public int unSet(int num,int bit){
        return ( num & ~(1<<bit) );
    }

}
