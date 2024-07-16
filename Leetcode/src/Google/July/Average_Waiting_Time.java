package Google.July;

public class Average_Waiting_Time {

    public double averageWaitingTime(int[][] customers) {
        double ans =0;
        int curr = customers[0][0];
        for (int[] i:customers){
            curr = Math.max(i[0],curr)+ i[1];
            ans+= (curr-i[0])/(customers.length*1.0);
            // ans /= ;
            // System.out.println(curr);
        }

        return ans;
    }

}
