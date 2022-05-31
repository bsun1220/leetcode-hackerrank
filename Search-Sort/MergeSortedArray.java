public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        for(int i = m; i < m + n; i++){
            nums1[i] = nums2[i - m];
        }

        int [] helper = new int [nums1.length];
        for(int i = 0; i < helper.length; i++){
            helper[i] = nums1[i];
        }

        int helperLeft = 0;
        int helperRight = m;
        int current = 0;

        while(helperLeft < m && helperRight < m + n){
            if(helper[helperLeft] < helper[helperRight]){
                nums1[current] = helper[helperLeft];
                helperLeft++;
            }
            else{
                nums1[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        int remain = m - helperLeft - 1;
        for(int i = 0; i <= remain; i++){
            nums1[current + i] = helper[helperLeft + i];
        }


    }
}
