package Mission_2025.January.Bit_Manupulation;

public class Reverse_Bits {

    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // Extract the least significant bit and add it to ans
            ans = (ans << 1) | (n & 1);
            // Right shift n to process the next bit
            n >>= 1;
        }
        return ans;
    }

}
