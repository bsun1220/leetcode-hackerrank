def combinationSum4(self, nums: List[int], target: int) -> int:
        dp = [0 for _ in range(target + 1)]
        dp[0] = 1
        for i in range(1, target + 1):
            for index,coin in enumerate(nums):
                if(i >= coin):
                    dp[i] += dp[i - coin]
    
        
        return dp[target]