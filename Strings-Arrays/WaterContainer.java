public class WaterContainer {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left < right){
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(area, max);
            if(height[left] > height[right]){
                right--;
            }
            else if (height[right] > height[left]){
                left++;
            }
            else{
                right--;
                left++;
            }
        }
        return max;
    }
}
