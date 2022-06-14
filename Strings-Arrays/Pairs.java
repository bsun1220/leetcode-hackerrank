public class Pairs {

    public static int pairs(int k, List<Integer> arr) {
    Collections.sort(arr);
    int total = 0;
    int slow = 0;
    int fast = 1;
    while(fast < arr.size() && slow < arr.size()){
        int diff = arr.get(fast) - arr.get(slow);
        if(diff >= k){
            slow = slow + 1;
            if(diff == k){
                total++;
            }
        }
        else{
            fast++;
        }

    }
    return total;
}
}
