public class isPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n < 0){
            return false;
        }

        int ones = 0;
        while(n!= 0){
            ones = ones + (n&1);
            n = n >>> 1;
        }
        return ones == 1;
    }
}
