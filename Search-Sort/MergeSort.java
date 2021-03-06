public class MergeSort {
    int[] arr;
    public int[] sortArray(int[] nums) {
        int[] helper = new int[nums.length];
        arr = nums;
        mergesort(arr, helper, 0, nums.length - 1);
        return arr;
    }
    public void mergesort(int [] array, int [] helper, int low, int high){
        if(low < high){
            int middle = (low + high)/2;
            mergesort(array, helper, low, middle);
            mergesort(array, helper, middle + 1, high);
            merge(array, helper, low, middle, high);
        }
    }
    public void merge(int [] array, int [] helper, int low, int middle, int high){
        for(int i = low; i <= high; i++){
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        while(helperLeft <= middle && helperRight <= high){
            if(helper[helperLeft] <= helper[helperRight]){
                array[current] = helper[helperLeft];
                helperLeft++;
            }
            else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;

        }
        int remaining = middle - helperLeft;
        for(int i = 0; i <= remaining; i++){
            array[current + i] = helper[helperLeft + i];
        }
    }
}
