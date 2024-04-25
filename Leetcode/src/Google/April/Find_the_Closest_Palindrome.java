package Google.April;

public class Find_the_Closest_Palindrome {

    public String nearestPalindromic(String n) {
       Long original = Long.parseLong(n);

       Long prev = previous(String.valueOf(original-1).toCharArray());
        Long next = next(String.valueOf(original+1).toCharArray());

        if (original-prev<=next-original){
            return String.valueOf(prev);
        }

        return String.valueOf(next);

    }

    public long previous(char[] arr){
        int left =0;
        int right = arr.length-1;
        while (left<right){
            while (arr[left]!=arr[right]) {
                decrement(arr, right);
                if(arr[0]=='0') return Long.parseLong(new String(arr));
            }
            left++;
            right--;

        }
        return Long.parseLong(new String(arr));
    }

    public long next(char[] arr){
        int left =0;
        int right = arr.length-1;
        while (left<right){
            while (arr[left]!=arr[right]) {
                increment(arr, right);

            }
            left++;
            right--;

        }
        return Long.parseLong(new String(arr));
    }

    public void decrement(char[] arr,int i){
        while (arr[i]=='0'){
            arr[i]='9';
            i--;
        }
        arr[i]--;
    }

    public void increment(char[] arr,int i){
        while (arr[i]=='9'){
            arr[i]='0';
            i--;
        }
        arr[i]++;
    }

}
