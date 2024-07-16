package Google.July;

public class Next_Greater_Element_III {

    public int nextGreaterElement(int n) {
        char[] a = (""+n).toCharArray();
        int i = a.length-2;
        while (i>=0 && (a[i+1]<= a[i])){
            i--;
        }
        if (i<0){
            return -1;
        }
        int j = a.length-1;
        while (j>=0 && a[j]<=a[i]){
            j--;
        }
        swap(i,j,a);
        reverse(i+1,a);

        try {
           return Integer.parseInt(new String(a));
        }catch (Exception e){
            return -1;
        }

    }

    public void swap(int i,int j,char[] s){
        char temp = s[i];
        s[i]=s[j];
        s[j] = temp;

    }

    public void reverse(int start,char[] s){
        int i=start;int j= s.length-1;
        while (i<j){
            swap(i,j,s);
            i++;
            j--;
        }
    }

}
