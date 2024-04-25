package Google.April;

public class Time_Needed_to_Buy_Tickets {


    public int timeRequiredToBuy2(int[] tickets, int k) {
        int ans =0;

        for (int i =0;i<tickets.length;i++) {
            if (i<=k){
                ans+=Math.min(tickets[k],tickets[i]);

            }else{
                ans+=Math.min(tickets[k]-1,tickets[i]);
            }
        }
        return ans;

    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans =0;
        int i=0;
        while (tickets[k]!=0){
            if (tickets[i]!=0){
                ans++;
                tickets[i]--;
            }
            i++;
            i= i%tickets.length;
        }
        return ans;

    }

}

