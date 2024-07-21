package Google.July;

import java.util.Arrays;
import java.util.Comparator;

public class Filling_Bookcase_Shelves {

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length+1];
        return helper(books,dp,shelfWidth,0);
    }

    public int helper(int[][] books,int[] dp,int shelf,int index){

        if (index==books.length){
            return 0;
        }

        if (dp[index]>0){
            return dp[index];
        }

        int ans = Integer.MAX_VALUE;
        int height = 0;
        int width=0;
        for (int i=index;i<books.length;i++){

            width+= books[i][0];
            if (width>shelf){
                break;
            }

            height = Math.max(height,books[i][1]);
            ans  = Math.min(ans,height+helper(books,dp,shelf,i+1));

        }

        return dp[index]=ans;
    }

}
