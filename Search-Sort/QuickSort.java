public class QuickSort {
    int[] array;
    public int[] sortArray(int[] nums) {
        int[] helper = new int[nums.length];
        array = nums;
        quickSort(array, 0, nums.length - 1);
        return array;
    }

    public void quickSort(int [] arr, int left, int right){
        int index = partition(arr, left, right);
        if(left < index - 1){
            quickSort(arr, left, index - 1);
        }
        if(index < right){
            quickSort(arr, index, right);
        }
    }

    public int partition(int [] arr, int left, int right){
        int pivot = arr[(left + right)/2];
        while(left <= right){
            while(arr[left] < pivot) left++;
            while(arr[right] > pivot) right--;

            if(left <= right){
                int temp =  arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}
