class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        total = 0
        largest = 0
        total_sum = 0
        slow = 0
        fast = 0
        
        while(slow < len(colors) and fast < len(colors)):
            if(colors[slow] != colors[fast]):
                if(fast - slow > 1):
                    total += total_sum - largest
                largest = 0
                total_sum = 0
                slow = fast
            elif(fast == len(colors) - 1):
                total_sum += neededTime[fast]
                largest = max(largest, neededTime[fast])
                if(fast - slow + 1 > 1):
                    total += total_sum - largest
            
            total_sum += neededTime[fast]
            largest = max(largest, neededTime[fast])
            fast += 1
        
        return total