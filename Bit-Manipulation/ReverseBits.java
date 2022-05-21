public class ReverseBits {
    public int reverseBits(int n) {
        int start = 0;
        for(int i = 32; i >= 0 ; i--){
            int temp = ((n >> i)&1) << (31 - i);
            start = start | temp;
        }




        return start;
    }
}
