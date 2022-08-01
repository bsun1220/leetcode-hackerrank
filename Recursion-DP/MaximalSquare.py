def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix[0])
        n = len(matrix)
        dp = [[0 for x in range(m)] for y in range(n)]
        
        maxSize = 0
        
        for row in range(n):
            for col in range(m):
                if(matrix[row][col] == "0"):
                    continue
                topCol = 0 if row == 0 else dp[row - 1][col]
                leftCol = 0 if col == 0 else dp[row][col - 1]
                topLeftCol = 0 if row == 0 or col == 0 else dp[row -1][col - 1]
                dp[row][col] = 1 + min(topCol, leftCol, topLeftCol)
                maxSize = max(dp[row][col], maxSize)
        
      
        return maxSize * maxSize