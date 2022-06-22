public class ArrayProduct {
    public int[] productExceptSelf(int[] nums) {
        int [] first = new int[nums.length];
        first[0] = 1;
        int [] second = new int[nums.length];
        second[nums.length - 1] = 1;
        int [] fin = new int[nums.length];

        for(int i = 1; i < nums.length; i++){
            first[i] = first[i - 1] * nums[i - 1];
        }
        for(int i = nums.length - 2; i >= 0; i--){
            second[i] = second[i + 1] * nums[i + 1];
        }
        for(int i = 0; i < nums.length; i++){
            fin[i] = first[i] * second[i];
        }
        return fin;
    }
}
