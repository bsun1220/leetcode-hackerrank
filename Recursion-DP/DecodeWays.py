def numDecodings(self, s: str) -> int:
        if(len(s) == 1 or int(s[0]) == 0):
            converted = int(s[0])
            return 1 if converted != 0 else 0
 
        total = 0
        dp = [0 for x in range(len(s))]
        dp[0] = 1
        
        for index in range(1, len(s)):
            prevTwo = int(s[index-1:index+1])
            prevOne = int(s[index])
            
            if(prevTwo >= 10 and prevTwo <= 26):
                dp[index] += dp[index - 2] if index - 2 >= 0 else 1;
            if(prevOne != 0):
                dp[index] += dp[index - 1];
        
        return dp[len(s) - 1];