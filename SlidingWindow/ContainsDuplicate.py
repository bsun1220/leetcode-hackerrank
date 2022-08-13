class ContainsDuplicate:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        window = set()
        
        if len(nums) <= 1:
            return False
        
        for i in range(min(k + 1, len(nums))):
            if nums[i] in window:
                return True
            window.add(nums[i])

            
        for i in range(k + 1, len(nums)):
            window.remove(nums[i - k - 1])
            if nums[i] in window:
                return True
            window.add(nums[i])
            
        
        return False