public class TrailingZeroes {
    public int trailingZeroes(int n) {

        int index = 1;
        int sum = 0;
        int current = 5;

        while(current <= n){
            sum+= n/current;
            index++;
            current = (int)Math.pow(5, index);
        }



        return sum;
    }
}
