class KLongestSubstringDistinct:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        map_word = {}
        indices = (0, 0)
        maxLength = 0
        left = 0
        right = 0 
        for key, val in enumerate(s):
            map_word[val] = key
            if(len(map_word) > k):
                minKey = self.getMinIndex(map_word)
                left = map_word[minKey] + 1
                map_word.pop(minKey)
        
            maxLength = max(maxLength, right - left + 1)
                
            right += 1
            
        return maxLength
                
    def getMinIndex(self, map_word):
        minIndex = float("inf")
        minKey = ""
        for key in map_word:
            if map_word[key] < minIndex:
                minKey = key
                minIndex = map_word[key]
                
        return minKey