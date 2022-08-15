class RainWater:
    def trap(self, height: List[int]) -> int:
        total = 0
        left_max = [0 for __ in range(len(height))]
        right_max = [0 for __ in range(len(height))]
        left_max[0] = height[0]
        
        for i in range(1, len(height)):
            left_max[i] = max(left_max[i - 1], height[i])
        
        right_max[len(height) - 1] = height[len(height) - 1]
        
        for i in range(len(height) - 2, -1, -1):
            right_max[i] = max(height[i], right_max[i + 1])
        
        for i in range(1, len(height) - 1):
            total += min(left_max[i], right_max[i]) - height[i]
        
    
        
        return total