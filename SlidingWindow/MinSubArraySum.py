class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        minLength = len(nums) + 2
        left = 0
        right = 0
        currentSum = 0
        while right < len(nums):
            currentSum += nums[right]
            if currentSum >= target:
                while currentSum - nums[left] >= target:
                    currentSum -= nums[left]
                    left += 1
                minLength = min(minLength, right - left + 1)
            right += 1
        
        
        return minLength if minLength != len(nums) + 2 else 0