package Google.May.String;

public class Compare_Version_Numbers {


    public int compareVersion(String version1, String version2) {
        String[] left = version1.split("\\.");
        String[] right = version2.split("\\.");
        // System.out.println(Arrays.toString(left));
        //   System.out.println(Arrays.toString(right));
        for (int i=0;i<Math.max(left.length,right.length);i++){
            StringBuilder currLeft = new StringBuilder();
            StringBuilder currRight = new StringBuilder();

            if (i>=left.length){
                for (int j=0;j<right[i].length();j++){
                    currLeft.append("0");
                }
            }else {
                currLeft = new StringBuilder(left[i]);
            }

            if (i>=right.length){
                for (int j=0;j<left[i].length();j++){
                    currRight.append("0");
                }
            }else {
                currRight = new StringBuilder(right[i]);
            }

            // System.out.println("currLeft="+currLeft.toString());
            //  System.out.println("currRight="+currRight.toString());

//            if (currLeft.length() < currRight.length()){
//                for (int j=0;j<currRight.length()-currLeft.length();j++){
//                    currLeft.insert(0,"0");
//                }
//            }
//
//            if (currLeft.length() > currRight.length()){
//                for (int j=0;j<currLeft.length()-currRight.length();j++){
//                    currRight.insert(0,"0");
//                }

            if (Integer.parseInt(currLeft.toString())>Integer.parseInt(currRight.toString())){
                return 1;
            }else if (Integer.parseInt(currLeft.toString())<Integer.parseInt(currRight.toString())){
                return -1;
            }
//            }

//            for (int j =0;j<currRight.length();j++){
//                if ((currLeft.charAt(j)-'0')> (currRight.charAt(j)-'0')){
//                    return 1;
//                }else if ((currLeft.charAt(j)-'0')< (currRight.charAt(j)-'0')){
//                    return -1;
//                }
//            }

        }
        return 0;
    }

}
