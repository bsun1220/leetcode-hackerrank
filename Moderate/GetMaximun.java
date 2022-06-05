public class GetMaximun {
    public static int getMaximum(List<Integer> arr) {
        int numSwitch = -1;
        int lowSum, highSum;
        while(numSwitch != 0){
            numSwitch = 0;
            for(int i = arr.size() - 1; i>= 1; i--){
                if(arr.get(i) <= arr.get(i - 1)){
                    continue;
                }
                else{
                    int sum = (arr.get(i) + arr.get(i-1));
                    lowSum = sum/2;
                    highSum = sum % 2 == 1 ? lowSum +1 : lowSum;
                    arr.set(i, lowSum);
                    arr.set(i-1, highSum);
                    numSwitch = 1;
                }
            }
        }
        return arr.get(0);

    }
}
