public class CountingBits {
    public int[] countBits(int n) {
        int ret [] = new int [n + 1];
        for(int i = 0; i <= n; i++){
            ret[i] = solve(i);
        }
        return ret;
    }
    public int solve(int n){
        if(n == 1){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        return n % 2 == 0 ? solve(n/2) : 1 + solve(n/2);
    }
}
